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
        /*JSONObject obj;
        Parser parser = new Parser();
        parser.parse();
        JSONArray array;
        array =  parser.sort();
        for (int i = 0;i<array.size();i++){
            obj = (JSONObject) array.get(i);
            System.out.println(obj.get("price"));
        }*/
    }
}
