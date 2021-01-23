package org.task;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

import java.io.IOException;

public class Parser {
    JSONArray array = new JSONArray();
    JSONObject obj = new JSONObject();
    public Parser(){
    }
    public JSONArray parse() throws IOException {
        String url = "https://epicentrk.ua/ua/shop/krupy-i-makaronnye-izdeliya/fs/vid-krupa-grechnevaya/";
        Document document = Jsoup.connect(url).get();
        Elements paragraphs = document.select("div.");
        for (Element paragraph : paragraphs) {
            obj.put("name",paragraph.text());
            System.out.println(obj);
            array.add(obj);

        }

        return array;
    }

}
