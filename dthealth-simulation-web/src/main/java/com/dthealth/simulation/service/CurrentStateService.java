package com.dthealth.simulation.service;


public interface CurrentStateService {
    void loadingMessage();
    String getCurrentState(String userAccount,String type);
}
