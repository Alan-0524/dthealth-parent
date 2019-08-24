package com.dthealth.simulation.controller;


import com.dthealth.simulation.service.CurrentStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.function.Function;

@RestController
@RequestMapping("/currentState")
public class SimulationController {

    @Autowired
    CurrentStateService currentStateService;

    @GetMapping(path = "/{userAccount}/{type}/{millis}")
    public Flux<ServerSentEvent<String>> loadState(@PathVariable String userAccount, @PathVariable String type, @PathVariable String millis) {
        long m = Long.parseLong(millis);
        return Flux.interval(Duration.ofMillis(m)).map(new Function<Long, ServerSentEvent<String>>() {
            String timestamp = "";

            @Override
            public ServerSentEvent<String> apply(Long aLong) {
                String data = currentStateService.getCurrentState(userAccount, type);
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
