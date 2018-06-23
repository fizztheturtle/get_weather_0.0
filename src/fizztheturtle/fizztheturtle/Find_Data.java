package fizztheturtle;
//"Contains public sector information licensed under the Open Government Licence"
// add a 10 counter per minute for requests
// add a 100000 per day counter
import org.json.simple.parser.*;
import org.json.simple.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;


public class Find_Data {

    public static void main(String[] args) throws Exception {
        // write your code here
        Find_Data obj;
        obj = new Find_Data();
//        System.out.println(obj.getFile("fizztheturtle/API_Key.txt"));

        String link ="C:/AndroidApplications/Weather_0.1/MetOfficeList/weather_3hours.json";
//        Windows link
//        URL url = new URL(link);

//        Mac link
//        URL url =
// new URL("file:///Users/Fizztheturtle/Desktop/PersonalProjects/get_weather_0.0/MetOfficeList/weather_3hours.json");
//        InputStreamReader reader = new InputStreamReader(url.openStream());



        JSONParser jsonParser = new JSONParser();
        Object object ;
        object = jsonParser.parse(new FileReader("MetOfficeList/weather_3days.json"));

        JSONObject jsonObject = (JSONObject) object;
        JSONObject dv = (JSONObject) jsonObject.get("DV");
        System.out.println("DV: " + dv);

        JSONObject location = (JSONObject) dv.get("Location");
        System.out.println("location: " + location);


        JSONArray Period = (JSONArray) location.get("Period");
        System.out.println("\tPeriod: " + Period);

        Iterator itr = Period.iterator();

        while (itr.hasNext()) {

            Object slide = itr.next();
            JSONObject jsonObject2 = (JSONObject) slide;
            JSONObject Rep = (JSONObject) jsonObject2.get("Rep");

            String date_of_birth = (String) Rep.get("date_of_birth");
            String name_id = (String) Rep.get("name_id");

            System.out.println("\t\tDate of Birth: " + date_of_birth);
            System.out.println("\t\tName Id: " + name_id);
        }
    }



    private String getFile(String fileName) {

        StringBuilder result = new StringBuilder();

        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();

    }

}
