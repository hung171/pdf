package com.example.btl;

import com.example.btl.model.SendMailJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Timer;

@SpringBootApplication
public class BtlApplication implements CommandLineRunner {
    @Autowired
    private SendMailJob sendMailJob;

    public static void main(String[] args) {
        SpringApplication.run(BtlApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Timer timer = new Timer();
        timer.schedule(sendMailJob, 4000*60);
    }
}
