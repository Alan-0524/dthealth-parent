package com.dthealth.simulation.service;

import org.springframework.http.codec.ServerSentEvent;
import reactor.core.publisher.Flux;

public interface CurrentStateService {
    ServerSentEvent<String> loadingCurrentState(String userAccount);
}
