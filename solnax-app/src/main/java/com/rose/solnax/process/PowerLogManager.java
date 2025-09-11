package com.rose.solnax.process;


import com.rose.solnax.model.entity.PowerLog;
import com.rose.solnax.model.repository.PowerLogRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PowerLogManager {



    public final PowerLogRepository powerLogRepository;

    @Transactional
    public PowerLog save(PowerLog powerLog) {
        return powerLogRepository.save(powerLog);
    }

}
