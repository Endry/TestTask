package org.task.controllers;

import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.task.Parser;

import java.io.IOException;

@RestController
public class DataController {
    Parser parser = new Parser();
    JSONArray array = new JSONArray();
    @GetMapping("/service")
    public String getSortedData() throws IOException {
        /*parser.parse();
        array =  parser.sort();
        for (int i = 0;i<array.size();i++){
            System.out.println(array.get(i));
        }*/
        return "маєш тобі контроллер";
    }
}
