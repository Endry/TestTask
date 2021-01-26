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
    static JSONArray array = new JSONArray();
    int kom =1;

    @RequestMapping(value = "/parse.json", method=RequestMethod.GET)
    public @ResponseBody String getParse() throws JSONException, IOException {
        array.clear();
        array = parser.parse();

        return array.toString();
    }

    @RequestMapping(value = "/search.json", method=RequestMethod.GET)
    public @ResponseBody String searchJson(@RequestParam(defaultValue="Ukraine") String country,
                                           @RequestParam(required = false) int min,
                                           @RequestParam(required = false) int max) throws JSONException, IOException {
        array.clear();
        array = parser.paramSearch(country,min,max);

        if (array.isEmpty()) return "Результатів не знайдено!";

        return array.toString();
    }


    @RequestMapping(value = "/sort.json", method=RequestMethod.GET)
    public @ResponseBody String sortJson() throws JSONException, IOException {
        array.clear();
        if (kom==1) {
            array = parser.sort(kom, parser.parse());
            kom++;
        }else {
            array = parser.sort(kom, parser.parse());
            kom=1;
        }

        return array.toString();
    }
}
