package com.meditrack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
//public class MediTrackApplication {
//    public static void main(String[] args) {
//        SpringApplication.run(MediTrackApplication.class, args);
//    }
//}
@SpringBootApplication
public class MediTrackApplication {
    public static void main(String[] args) {
        SpringApplication.run(MediTrackApplication.class, args);

        new Thread(() -> {
            int counter = 1;
            while (true) {
                System.out.println(counter++);
                try {
                    Thread.sleep(1000); // Pause for 1 second
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }).start();
    }
}