/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springscrath.core.schedules;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author adiel
 */
@Component
public class Schedules1 {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Scheduled(cron = "30 * * * * *")
    public void alerta1() {
        logger.info("Alerta 1 -> The time is now {}", dateFormat.format(new Date()));
    }

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(initialDelay = 5000, fixedRate = 15000)
    public void alerta2() {
        logger.info("Alerta 2 -> The time is now {}", dateFormat.format(new Date()));

    }
}
