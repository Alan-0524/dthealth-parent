package com.dthealth.simulation.controller;


import com.dthealth.dao.entity.BodyIndex;
import com.dthealth.simulation.message.MessageReceiver;
import com.dthealth.simulation.message.MessageSender;
import com.dthealth.simulation.service.CurrentStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.function.Function;

@RestController
@RequestMapping("/currentState")
public class SimulationController {

    @Autowired
    MessageSender messageSender;

    @Autowired
    MessageReceiver messageReceiver;

    @Autowired
    CurrentStateService currentStateService;

    @GetMapping(path = "/{userAccount}")
    public Flux<ServerSentEvent<String>> getState(@PathVariable String userAccount) {

        return Flux.interval(Duration.ofSeconds(1))
                .map(new Function<Long, ServerSentEvent<String>>() {
                    @Override
                    public ServerSentEvent<String> apply(Long aLong) {
                        return currentStateService.loadingCurrentState(userAccount);
                    }
                });

//        return Flux.interval(Duration.ofSeconds(1))
//                .map(new Function<Long, Tuple2<Long, Integer>>() {
//                    @Override
//                    public Tuple2<Long, Integer> apply(Long seq) {
//                        return Tuples.of(seq, ThreadLocalRandom.current().nextInt());
//                    }
//                })
//                .map(new Function<Tuple2<Long, Integer>, ServerSentEvent<Integer>>() {
//                    @Override
//                    public ServerSentEvent<Integer> apply(Tuple2<Long, Integer> data) {
//                        return ServerSentEvent.<Integer>builder().event(userAccount).id(Long.toString(data.getT1())).data(data.getT2()).build();
//                    }
//                });
    }

    @GetMapping("/hello_world")
    public Mono<String> sayHelloWorld() {
        return Mono.just("Hello World");
    }

    @GetMapping("/presentCurrentState")
    public Mono<BodyIndex> presentCurrentState() {
        return Mono.just(new BodyIndex());
    }
}
