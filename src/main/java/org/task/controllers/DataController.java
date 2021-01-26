package org.task.controllers;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.springframework.web.bind.annotation.*;
import org.task.Grechka;
import org.task.Parser;

import java.io.IOException;
import java.util.ArrayList;

@RestController
public class DataController {
    Parser parser = new Parser();
    JSONArray array = new JSONArray();
    JSONObject obj = new JSONObject();
    Grechka grechka;
    ArrayList<Grechka> list = new ArrayList<>();

    @RequestMapping("/parse.json")
    @ResponseBody
    public String getParse() throws JSONException, IOException {
        list.clear();
        if (array.isEmpty())array = parser.parse();
        array.remove(array.size()-1);

        /*
        for (int i=0;i<array.size();i++){
            list.add(new Grechka((JSONObject) array.get(i)));
        }*/
        //Creating the ObjectMapper object


        return array.toJSONString();
    }
    @RequestMapping("/search.json")
    @ResponseBody
    public ArrayList<Grechka> searchJson(@RequestParam(defaultValue="Ukraine") String country,
                                         @RequestParam(required = false) int min,
                                         @RequestParam(required = false) int max) throws JSONException, IOException {
        list.clear();
        if (array.isEmpty())array = parser.parse();
        array = parser.paramSearch(country,min,max);
        for (int i=0;i<array.size();i++){
            list.add(new Grechka((JSONObject) array.get(i)));
        }

        return list;
    }
    @RequestMapping("/sort.json")
    @ResponseBody
    public ArrayList<Grechka> sortJson(@RequestParam(required = false) int kom) throws JSONException, IOException {
        list.clear();
        if (array.isEmpty())array = parser.sort(kom, parser.parse());
        grechka = new Grechka(obj);
        for (int i=0;i<array.size();i++){
            list.add(new Grechka((JSONObject) array.get(i)));
        }

        return list;
    }
}
