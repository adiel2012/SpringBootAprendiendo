/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springscrath.services;

import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author adiel
 */
@Component
public class CounterService {

    private AtomicInteger counter = new AtomicInteger(0);

    @Autowired
    CounterHandler counterHandler;

    @Scheduled(fixedDelay = 1000)
    public void sendCounterUpdate() {
        counterHandler.counterIncrementedCallback(counter.incrementAndGet());
    }

}
