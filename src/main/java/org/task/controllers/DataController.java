package org.task.controllers;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.task.Grechka;
import org.task.Parser;

import java.io.IOException;

@RestController
public class DataController {
    Parser parser = new Parser();
    JSONArray array = new JSONArray();
    JSONObject obj = new JSONObject();
    Grechka grechka;
    @RequestMapping("/")
    public void getSortedData() throws IOException {
        array = parser.parse();
        /*
        array =  parser.sort();
        for (int i = 0;i<array.size();i++){
            System.out.println(array.get(i));
        }*/
    }
    @RequestMapping("/parse.json")
    @ResponseBody
    public Grechka getParse() throws JSONException {

        grechka = new Grechka(obj);

        return grechka;
    }
    @RequestMapping("/search.json")
    @ResponseBody
    public JSONObject searchJson() throws JSONException {
        obj.put("name","Andrii");

        return obj;
    }

}
