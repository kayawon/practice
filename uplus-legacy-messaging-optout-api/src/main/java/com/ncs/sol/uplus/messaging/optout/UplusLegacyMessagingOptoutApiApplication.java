package com.ncs.sol.uplus.messaging.optout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ncs.sol.uplus.messaging")
public class UplusLegacyMessagingOptoutApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(UplusLegacyMessagingOptoutApiApplication.class, args);
    }

}
