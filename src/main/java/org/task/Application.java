package org.task;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;


@SpringBootApplication
public class Application {
    public static void main(String args[]) throws IOException, JSONException {
        SpringApplication.run(Application.class, args);
        Parser parser = new Parser();
        System.out.println(parser.sort(1,parser.parse()).toString());
    }
}
