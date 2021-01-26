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

    @RequestMapping(value = "/parse.json", method=RequestMethod.GET)
    public @ResponseBody String getParse() throws JSONException, IOException {
        array = parser.parse();

        return array.toString();
    }

    @RequestMapping(value = "/search.json", method=RequestMethod.GET)
    public @ResponseBody String searchJson(@RequestParam(defaultValue="Ukraine") String country,
                                           @RequestParam(required = false) int min,
                                           @RequestParam(required = false) int max) throws JSONException, IOException {

        array = parser.paramSearch(country,min,max);

        if (array.isEmpty()) return "Результатів не знайдено!";

        return array.toString();
    }


    @RequestMapping(value = "/sort.json", method=RequestMethod.GET)
    public @ResponseBody String sortJson(@RequestParam(required = false) int kom) throws JSONException, IOException {
        array = parser.sort(kom, parser.parse());

        return array.toString();
    }
}
