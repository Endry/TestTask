package org.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;


@SpringBootApplication
public class TestTaskApplication {
    public static void main(String args[]) throws IOException {
        SpringApplication.run(TestTaskApplication.class, args);
        /*Parser parser = new Parser();
        parser.parse();*/
    }
}
