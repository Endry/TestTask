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
    ArrayList<String> namesArray = new ArrayList<>();
    ArrayList<String> pricesArray = new ArrayList<>();
    ArrayList<String> linksArray = new ArrayList<>();
    ArrayList<String> imgsArray = new ArrayList<>();
    ArrayList<String> countrysArray = new ArrayList<>();
    ArrayList<String> weightsArray = new ArrayList<>();

    int kol = 1;
    public Parser(){}

    public JSONArray parse() throws IOException {
        array.clear();
        String url = "https://epicentrk.ua/ua/shop/krupy-i-makaronnye-izdeliya/fs/vid-krupa-grechnevaya/";
        Document document = Jsoup.connect(url).get();
        Elements paragraphs = document.select("b.nc");
        Elements links = document.select("div.card__info > a.card__photo");
        Elements imgs = document.select("a.card__photo > img[src$=.jpeg]");
        Elements chs = document.select("ul.card__characteristics > li");
        Elements prices = document.select("span.card__price-sum");
        Elements countrys;
        int kol=9;
        for (Element paragraph : paragraphs) {
            namesArray.add( paragraph.text());
            kol--;
            if (kol==0)break;
        }
        kol=9;
        for (Element price : prices) {
            pricesArray.add(price.text());
            kol--;
            if (kol==0)break;
        }
        char c ='\\';
        kol=9;
        int kol2=9;
        for (Element link : links) {
            linksArray.add(link.attr("abs:href"));
            countrysArray.add("Україна");
            kol--;
            if (kol==0)break;
        }
        kol = 9;
        for (Element img : imgs) {
            imgsArray.add(img.attr("src"));
            kol--;
            if (kol==0)break;
        }
        kol2 =9;
        kol=1;
        for (Element ch : chs) {
            if(kol==1) {
                kol=2;
            }
            else if (kol==2) {
                kol=3;
            }
            else if (kol==3) {
                /*
                int check = 1;
                check = ch.text().substring(ch.text().length()-3,ch.text().length()-1).contains("кг")?1000:1;
                try {
                    weightsArray.add(Integer.parseInt(ch.text().substring(5, ch.text().substring(ch.text().length() - 3, ch.text().length() - 1).contains("кг") ? ch.text().length() - 2 : ch.text().length() - 2)) * check);
                }catch (Exception e){
                    namesArray.remove(namesArray.size()-1);
                    pricesArray.remove(pricesArray.size()-1);
                    countrysArray.remove(countrysArray.size()-1);
                    imgsArray.remove(imgsArray.size()-1);
                    linksArray.remove(linksArray.size()-1);
                }*/
                weightsArray.add(ch.text());
                kol=1;
                kol2--;
                if (kol2==0)break;
            }

        }



        url = "https://fozzyshop.ua/300143-krupa-grechnevaya";
        document = Jsoup.connect(url).get();
        paragraphs = document.select("div.h3.product-title > a");
        imgs = document.select("img.img-fluid.product-thumbnail-first");
        chs = document.select("div.product-reference.text-muted > a");
        prices = document.select("span.product-price");
        kol2 = 9;
        int kol3 = 9;
        for (Element paragraph : paragraphs) {
            if (paragraph.text().contains("Крупа")){
            namesArray.add(paragraph.text());
            linksArray.add(paragraph.attr("abs:href"));
            countrysArray.add("Україна");

            kol2--;
            if (kol2==0)break;
            }
        }
        kol = 9;
        for (Element img : imgs) {
            imgsArray.add(img.attr("src"));
            kol--;
            if (kol==0)break;
        }

        kol = 9;
        for (Element price : prices) {
            pricesArray.add(price.text());
            kol--;
            if (kol==0)break;
        }
        kol = 9;
        kol2=1;
        for (Element weight : chs){
            if(kol2==1) {
                /*
                int check = 1;
                check = weight.text().substring(weight.text().length()-3,weight.text().length()-1).contains("кг")?1000:1;
                try {
                    weightsArray.add(Integer.parseInt(weight.text().substring(8, weight.text().substring(weight.text().length() - 3, weight.text().length() - 1).contains("кг") ? weight.text().length() - 2 : weight.text().length() - 2)) * check);
                }catch (Exception e){
                    namesArray.remove(namesArray.size()-1);
                    pricesArray.remove(pricesArray.size()-1);
                    countrysArray.remove(countrysArray.size()-1);
                    imgsArray.remove(imgsArray.size()-1);
                    linksArray.remove(linksArray.size()-1);
                }*/
                weightsArray.add(weight.text());
                kol--;
                if (kol == 0) break;
                kol2++;
            }else kol2=1;
        }

        url = "https://metro.zakaz.ua/uk/categories/buckwheat-metro/gclid=CjwKCAiA9bmABhBbEiwASb35VyjDKQrhdLqzgEmiAiFPQziRwl-jSh-_PS8pDnM2Xe4KPu7OLR7rQxoCgqMQAvD_BwE/?gclsrc=aw.ds";
        document = Jsoup.connect(url).get();
        links = document.select("a.jsx-725860710.product-tile");
        Elements names = document.select("span.goods-tile__title");
        imgs = document.select("img.jsx-725860710.product-tile__image-i");
        prices = document.select("span.jsx-3642073353.Price__value_caption");
        chs = document.select("div.jsx-725860710.product-tile__weight");
        kol = 9;
        kol2 = 9;
        for (Element link : links){
            linksArray.add(link.attr("abs:href"));
            namesArray.add(link.attr("title"));
            countrysArray.add("Україна");
            kol--;
            if (kol==0)break;
        }
        kol = 9;
        for (Element img : imgs){
            imgsArray.add(img.attr("src"));
            kol--;
            if (kol==0)break;
        }
        kol = 9;
        for (Element price : prices){
            pricesArray.add(price.text());
            kol--;
            if (kol==0)break;
        }

        kol = 9;
        for (Element weight : chs){
            /*
            int check = 1;
            check = weight.text().substring(weight.text().length()-3,weight.text().length()-1).contains("кг")?1000:1;
            try {
                weightsArray.add(new Integer(Integer.parseInt(weight.text().substring(0,weight.text().substring(weight.text().length()-3,weight.text().length()-1).contains("кг")?weight.text().length()-2:weight.text().length()-2))*check));
            }catch (Exception e){
                namesArray.remove(namesArray.size()-1);
                pricesArray.remove(pricesArray.size()-1);
                countrysArray.remove(countrysArray.size()-1);
                imgsArray.remove(imgsArray.size()-1);
                linksArray.remove(linksArray.size()-1);
            }*/
            weightsArray.add(weight.text());
            kol--;
            if (kol==0)break;
        }

        for (int i=0;i<linksArray.size()-1;i++){
            JSONObject obj = new JSONObject();
            obj.remove("name");
            obj.put("name",namesArray.get(i));
            obj.remove("price");
            obj.put("price",pricesArray.get(i));
            obj.remove("link");
            obj.put("link",linksArray.get(i));
            obj.remove("img");
            obj.put("img",imgsArray.get(i));
            obj.remove("country");
            obj.put("country",countrysArray.get(i));
            obj.remove("weight");
            obj.put("weight",weightsArray.get(i));

            array.add(obj);
        }

        return array;
    }

    public JSONArray sort(int kom,JSONArray array) {
        JSONArray sortedJsonArray = new JSONArray();
        JSONArray stmp = array;
        List<JSONObject> jsonValues = new ArrayList<JSONObject>();
        for (int i = 0; i < array.size(); i++) {
            jsonValues.add((JSONObject) stmp.get(i));
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
                if (kom==1) {
                    return valA.compareTo(valB);
                }else if (kom==2)return -valA.compareTo(valB);
                else return valA.compareTo(valB);
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
    public JSONArray paramSearch(String c, int wmin, int wmax ) throws IOException {
        JSONArray tmp;
        tmp = parse();
        for (int i = 0; i < array.size(); i++) {
            JSONObject obj = new JSONObject();
            obj = (JSONObject) tmp.get(i);
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
