package org.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TestTaskApplication {
    public static void main(String args[]){SpringApplication.run(TestTaskApplication.class, args); }
}
