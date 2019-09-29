package com.dthealth.interaction.controller;


import com.dthealth.interaction.service.CurrentStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.RejectedExecutionException;
import java.util.function.Function;

@RestController
@RequestMapping("/currentState")
public class SimulationController {

    @Autowired
    CurrentStateService currentStateService;

    @GetMapping(path = "loadingCurrentHeartbeat/{id}")
    public Flux<ServerSentEvent<String>> loadingCurrentHeartbeat(@PathVariable String id) {
        return Flux.interval(Duration.ofMillis(400)).concatWith(Flux.error(new RejectedExecutionException())).retry()
                .map(new Function<Long, ServerSentEvent<String>>() {
            String timestamp = "";
            @Override
            public ServerSentEvent<String> apply(Long aLong) {
                String data = currentStateService.loadingCurrentHeartbeat(id);
                if (!StringUtils.isEmpty(data)) {
                    String[] value = data.split("@@@");
                    if (!timestamp.equals(value[1])) {
                        timestamp = value[1];
                        return ServerSentEvent.<String>builder().data(value[0]).build();
                    }
                }
                return ServerSentEvent.<String>builder().build();
            }
        });
    }

    @GetMapping(path = "loadingCurrentIndex/{id}")
    public Flux<ServerSentEvent<String>> loadingCurrentIndex(@PathVariable String id) {
        return Flux.interval(Duration.ofMillis(2000)).concatWith(Flux.error(new RejectedExecutionException())).retry()
                .map(new Function<Long, ServerSentEvent<String>>() {
            String timestamp = "";
            @Override
            public ServerSentEvent<String> apply(Long aLong) {
                String data = currentStateService.loadingOtherIndex(id);
                if (!StringUtils.isEmpty(data)) {
                    String[] value = data.split("@@@");
                    if (!timestamp.equals(value[1])) {
                        timestamp = value[1];
                        return ServerSentEvent.<String>builder().data(value[0]).build();
                    }
                }
                return ServerSentEvent.<String>builder().build();
            }
        });
    }

}
