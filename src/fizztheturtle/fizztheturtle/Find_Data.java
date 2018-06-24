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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
