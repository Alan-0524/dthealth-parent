package com.dthealth.mq.entities;

public class Main {
    public static void main(String[] args) {
        new Thread(new Thread_heartbeat("5d53b73492f6e331bc118715")).start();
//        new Thread(new Thread_heartbeat("5d65f95d0edf105074cd77fc")).start();
//        new Thread(new Thread_heartbeat("5d65fc270edf10518cd98e80")).start();
//        new Thread(new Thread_heartbeat("5d65fc7e0edf104b0436ab02")).start();
//        new Thread(new Thread_heartbeat("5d65fce90edf1043d4c64455")).start();

        new Thread(new Thread_otherIndex("5d53b73492f6e331bc118715")).start();
//        new Thread(new Thread_otherIndex("5d65f95d0edf105074cd77fc")).start();
//        new Thread(new Thread_otherIndex("5d65fc270edf10518cd98e80")).start();
//        new Thread(new Thread_otherIndex("5d65fc7e0edf104b0436ab02")).start();
//        new Thread(new Thread_otherIndex("5d65fce90edf1043d4c64455")).start();
    }
}
