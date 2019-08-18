package com.dthealth.simulation.service;

import org.springframework.http.codec.ServerSentEvent;

public interface CurrentStateService {
    ServerSentEvent<String> loadingCurrentState(String userAccount);
}
