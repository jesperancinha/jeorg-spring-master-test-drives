package org.jesperancinha.smtd;

import org.crac.*;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class CracRunner implements Resource, AutoCloseable {

    public CracRunner() {
        Core.getGlobalContext().register(this);
    }

    @Override
    public void beforeCheckpoint(Context<? extends Resource> context) throws Exception {
        System.out.println("Before Checkpoint!");
    }

    @Override
    public void afterRestore(Context<? extends Resource> context) throws Exception {
        System.out.println("After Restore!");
    }

    static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws IOException {
        System.out.println(Runtime.version());

        count.addAndGet(1);
        if (count.get() == 1) {
            try (CracRunner cracRunner = new CracRunner()) {
                try {
                    System.out.println("Process will shutdown with PID: " + ProcessHandle.current().pid());
                    Core.checkpointRestore();
                } catch (CheckpointException | RestoreException ex) {
                    throw new RuntimeException("Failed Checkpoint / Restore!", ex);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Process will continue with PID: " + ProcessHandle.current().pid());
            System.out.println("Counter is at: " + count);
        }
    }

    @Override
    public void close() {
        System.out.println("This is resource is now closed!");
    }
}