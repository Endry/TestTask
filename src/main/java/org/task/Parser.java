package org.task;

import org.json.JSONException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Parser {
    JSONArray array = new JSONArray();
    JSONObject obj = new JSONObject();
    ArrayList<String> namesArray = new ArrayList<>();
    ArrayList<String> pricesArray = new ArrayList<>();
    ArrayList<String> linksArray = new ArrayList<>();
    ArrayList<String> imgsArray = new ArrayList<>();
    ArrayList<String> countrysArray = new ArrayList<>();
    ArrayList<String> weightsArray = new ArrayList<>();

    int kol = 1;
    public Parser(){
    }
    public JSONArray parse() throws IOException {
        String url = "https://epicentrk.ua/ua/shop/krupy-i-makaronnye-izdeliya/fs/vid-krupa-grechnevaya/";
        Document document = Jsoup.connect(url).get();
        Elements paragraphs = document.select("b.nc");
        Elements links = document.select("div.card__info > a.card__photo");
        Elements imgs = document.select("a.card__photo > img[src$=.jpeg]");
        Elements chs = document.select("ul.card__characteristics > li");
        Elements prices = document.select("span.card__price-sum");
        Elements countrys;
        int kol=10;
        for (Element paragraph : paragraphs) {
            namesArray.add( paragraph.text());
            kol--;
            if (kol==0)break;
        }
        kol=10;
        for (Element price : prices) {
            pricesArray.add(price.text());
            kol--;
            if (kol==0)break;
        }
        char c ='\\';
        kol=10;
        int kol2=10;
        for (Element link : links) {
            linksArray.add(link.attr("abs:href"));

            url = link.attr("abs:href");
            url = url.replace(c,' ');

            document = Jsoup.connect(url).get();
            countrys = document.select("span.p-char__value > span");

            for (Element country : countrys) {
                if (country.text().equals("Україна")) {
                    countrysArray.add(country.text());
                    System.out.println(country.text());
                }
                else if (country.text().equals("Росія")){
                    countrysArray.add(country.text());
                    System.out.println(country.text());
                }else if (country.text().equals("Німеччина")){
                    countrysArray.add(country.text());
                    System.out.println(country.text());
                }else if (country.text().equals(null)){
                    countrysArray.add("Україна");
                    System.out.println("Україна");
                }
                kol2--;
                if (kol2==0)break;
            }
            kol--;
            if (kol==0)break;
        }
        kol = 10;
        for (Element img : imgs) {
            imgsArray.add(img.attr("src"));
            kol--;
            if (kol==0)break;
        }
        kol =10;
        for (Element ch : chs) {
            if(kol==1) {
                kol=2;
            }
            else if (kol==2) {
                kol=3;
            }
            else if (kol==3) {
                weightsArray.add(ch.text());
                System.out.println(ch.text());
                kol=1;
            }
            kol--;
            if (kol==0)break;
        }



        url = "https://prom.ua/ua/Krupa-grechnevaya.html?sort=-score";
        document = Jsoup.connect(url).get();
        paragraphs = document.select("a.productTile__tileLink--204An");
        imgs = document.select("img.lazyImage__image--APkHl");
        chs = document.select("ul.card__characteristics > li");

        kol2 = 10;
        int kol3 = 10;
        for (Element paragraph : paragraphs) {
            namesArray.add(paragraph.attr("title"));
            linksArray.add(paragraph.attr("abs:href"));
            countrysArray.add("Україна");
            url = paragraph.attr("abs:href");
            url = url.replace(c,' ');
            document = Jsoup.connect(url).get();
            prices = document.select("span.ek-text_weight_bold");
            chs = document.select("div > span");

            kol = 1;
            for (Element element : chs) {
                if (element.text().equals("Вага")) {
                    kol++;
                } else if (kol % 2 == 0) {
                    weightsArray.add(element.text());
                    kol++;
                }
                kol3--;
                if (kol3==0)break;
            }

            kol = 1;
            kol3=10;
            for (Element price : prices) {
                if (kol==2)break;
                else if (price.text().contains("грн")) {
                    pricesArray.add(price.text());
                    System.out.println(price.text() );
                    kol++;
                }
                kol3--;
                if (kol3==0)break;
            }

            kol2--;
            if (kol2==0)break;
        }
        kol = 10;
        for (Element img : imgs) {
            imgsArray.add(img.attr("src"));
            kol--;
            if (kol==0)break;
        }

        url = "https://rozetka.com.ua/ua/krupy/c4628397/vid-225787=grechka/";
        document = Jsoup.connect(url).get();
        links = document.select("a.goods-tile__heading");
        Elements names = document.select("span.goods-tile__title");

        prices = document.select("span.goods-tile__price-value");

        kol = 10;
        kol2 = 10;

        for (Element link : links){
            linksArray.add(link.attr("abs:href"));
            System.out.println(link.text());            namesArray.add(link.text());
            System.out.println(namesArray.get(namesArray.size()-1));

            url = link.attr("abs:href");
            url = url.replace(c,' ');

            document = Jsoup.connect(url).get();
            imgs = document.select("img.product-photo__picture");
            for (Element img : imgs){
                imgsArray.add(imgs.attr("src"));
                kol2--;
                if (kol2==0)break;
            }
            weightsArray.add("");
            countrysArray.add("Україна");
            kol--;
            if (kol==0)break;
        }
        kol = 10;
        System.out.println("zzz");
        for (Element img : imgs){
            imgsArray.add(img.attr("src"));
            kol--;
            if (kol==0)break;
        }
        System.out.println("zzz");
        kol = 10;
        for (Element price : prices){
            System.out.println(price.text());
            pricesArray.add(price.text());
            System.out.println(pricesArray.get(pricesArray.size()-1));
            kol--;
            if (kol==0)break;
        }
        System.out.println("zzz");

        while (weightsArray.size()!=linksArray.size()){
            weightsArray.add("");
        }
        System.out.println(imgs.isEmpty());
        System.out.println(namesArray.get(namesArray.size()-1));

        for (int i=0;i<linksArray.size()-1;i++){
            obj.remove("name");
            obj.put("name",namesArray.get(i));
            System.out.println(obj.get("name"));
            System.out.println("1");
            obj.remove("price");
            obj.put("price",pricesArray.get(i));
            System.out.println(obj.get("price"));
            System.out.println("2");
            obj.remove("link");
            obj.put("link",linksArray.get(i));
            System.out.println(obj.get("link"));
            System.out.println("3");
            obj.remove("img");
            obj.put("img",imgsArray.get(i));
            System.out.println(obj.get("img"));
            System.out.println("4");
            obj.remove("country");
            obj.put("country",countrysArray.get(i));
            System.out.println(obj.get("country"));
            System.out.println("5");
            obj.remove("weight");
            obj.put("weight",weightsArray.get(i));
            System.out.println(obj.get("weight"));
            System.out.println("6");

            array.add(obj);
        }

        return array;
    }

    public JSONArray sort() {
        JSONArray sortedJsonArray = new JSONArray();

        List<JSONObject> jsonValues = new ArrayList<JSONObject>();
        for (int i = 0; i < array.size(); i++) {
            jsonValues.add((JSONObject) array.get(i));
        }
        Collections.sort(jsonValues, new Comparator<JSONObject>() {
            //You can change "Name" with "ID" if you want to sort by ID
            private static final String KEY_NAME = "price";

            @Override
            public int compare(JSONObject a, JSONObject b) {
                String valA = new String();
                String valB = new String();

                valA = (String) a.get(KEY_NAME);
                valB = (String) b.get(KEY_NAME);

                return valA.compareTo(valB);
                //if you want to change the sort order, simply use the following:
                //return -valA.compareTo(valB);
            }
        });

        for (int i = 0; i < array.size(); i++) {
            sortedJsonArray.add((jsonValues.get(i)));
        }

        return sortedJsonArray;
    }
    JSONArray paramArray = new JSONArray();
    public JSONArray paramSearch(String c, int wmin, int wmax ) {

        for (int i = 0; i < array.size(); i++) {
            obj = (JSONObject) array.get(i);
            int weight = (int) obj.get("weight");
            if ((weight < wmax) && (weight > wmin)) {

                if (obj.get("country").equals(c)) {
                    paramArray.add(array.get(i));

                }
            }
        }

        return paramArray;
    }



}
