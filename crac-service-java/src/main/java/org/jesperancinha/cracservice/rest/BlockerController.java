package org.jesperancinha.cracservice.rest;

import org.crac.CheckpointException;
import org.crac.Core;
import org.crac.RestoreException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
class BlockerController {

    private AtomicInteger level = new AtomicInteger(10);

    @GetMapping
    Integer blockingStatus() {
        return level.get();
    }


    @GetMapping("/restore")
    void restorePoint() throws RestoreException, CheckpointException {
        Core.checkpointRestore();
    }


    @Scheduled(fixedRate = 5000)
    void scheduleFixedRateTask() {
        level.decrementAndGet();
        System.out.println(LocalDateTime.now());
        System.out.println(level);
    }
}