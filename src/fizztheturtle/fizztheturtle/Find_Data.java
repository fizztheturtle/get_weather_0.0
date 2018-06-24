package fizztheturtle;
//"Contains public sector information licensed under the Open Government Licence"
// add a 10 counter per minute for requests
// add a 100000 per day counter
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

import static java.nio.file.Paths.*;


public class Find_Data {

    public static void main(String[] args) throws Exception {
        // write your code here
        URL url =  Find_Data.class.getResource("API_Key.txt");
        String API_Key=Paths.get(url.toURI()).toFile().toString();

        String contents =new String(Files.readAllBytes(Paths.get(API_Key)));

        System.out.println(contents);

//        String link ="C:/AndroidApplications/Weather_0.1/MetOfficeList/weather_3hours.json";
//
//        URL url_temp =  Find_Data.class.getResource("weather_3hours.json");
//        String link =Paths.get(url.toURI()).toFile().toString();

        JSONParser jsonParser = new JSONParser();
        Object object ;
        object = jsonParser.parse(new FileReader("MetOfficeList/weather_3days.json"));

        JSONObject jsonObject = (JSONObject) object;

        JSONObject SiteRep = (JSONObject) jsonObject.get("SiteRep");
        System.out.println("SiteRep: " + SiteRep);
        JSONObject dv = (JSONObject) SiteRep.get("DV");
        System.out.println("DV: " + dv);

        JSONObject location = (JSONObject) dv.get("Location");
        System.out.println("location: " + location);


        JSONArray Period = (JSONArray) location.get("Period");



        for(Object periodObj: Period.toArray()){
            JSONObject period_2 = (JSONObject)periodObj;
            JSONArray Rep = (JSONArray) period_2.get("Rep");
            System.out.println("\tPeriod: " + periodObj);
            for(Object repObj: Rep.toArray()){
                JSONObject rep_2 = (JSONObject) repObj;
                System.out.println("\t\t rep: " + rep_2);
                String weather_type = (String) rep_2.get("W");
                System.out.println("\t\t\t weather_type: " + weather_type);
                String $_temp = (String) rep_2.get("$");
                int $= Integer.parseInt($_temp);
                String myTime = "00:00";
                SimpleDateFormat df = new SimpleDateFormat("HH:mm");
                Date d = df.parse(myTime);
                Calendar cal = Calendar.getInstance();
                cal.setTime(d);
                cal.add(Calendar.MINUTE, $);
                String newTime = df.format(cal.getTime());
                System.out.println("\t\t\t $_temp: " + newTime);
                //do something with the issue
            }

        }
    }




}
