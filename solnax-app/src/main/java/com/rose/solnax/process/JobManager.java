package com.rose.solnax.process;

import com.rose.solnax.model.entity.PowerLog;
import com.rose.solnax.model.repository.PowerLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@Slf4j
@RequiredArgsConstructor
public class JobManager {

    private final PowerLogManager powerLogManager;

    private final Random random = new Random();


    @Scheduled(cron = "0 */5 * * * *")
    void logPower(){
        LocalDateTime now = LocalDateTime.now();
        int hour = now.getHour();
        double solarIn;

        if (hour >= 6 && hour <= 18) {
            int base = Math.max(0, (12 - Math.abs(12 - hour)) * 10);
            solarIn = base * (0.8 + (0.4 * random.nextDouble()));
        } else {
            solarIn = 0;
        }


        PowerLog powerLog = PowerLog.builder()
                .time(LocalDateTime.now())
                .solarIn(solarIn)
                .houseOut(1.0 + (random.nextDouble()))
                .chargerOut(0.2 +  (random.nextDouble() * 9))
                .heatOut(1.0 + (random.nextDouble() * 2))
                .build();
        powerLogManager.save(powerLog);
        log.info("Logged power log: {}", powerLog);
    }
}
