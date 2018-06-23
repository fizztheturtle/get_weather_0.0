package fizztheturtle;


//"Contains public sector information licensed under the Open Government Licence"
// add a 10 counter per minute for requests
// add a 100000 per day counter
import com.google.gson.Gson;
import org.json.simple.parser.*;
import org.json.simple.*;

import java.io.File;
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

//        Windows link
//        URL url = new URL("file:///C:/AndroidApplications/Weather_0.1/MetOfficeList/weather_3hours.json");

//        Mac link
        URL url = new URL("file:///Users/Fizztheturtle/Desktop/PersonalProjects/get_weather_0.0/MetOfficeList/weather_3hours.json");
        InputStreamReader reader = new InputStreamReader(url.openStream());

        MyDto dto = new Gson().fromJson(reader, MyDto.class);

        // using the de-serialised object
        //System.out.println(dto.headers);
        Map<String, String> headers = dto.D;
        for (Map.Entry<String, String> entry : headers.entrySet())
        {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println(dto.args);
        System.out.println(dto.origin);
        System.out.println(dto.url);

        JSONParser jsonParser = new JSONParser();
        Object object;
        object = jsonParser.parse("file:///Users/Fizztheturtle/Desktop/PersonalProjects/get_weather_0.0/MetOfficeList/weather_3hours.json");
        JSONObject jsonObject = (JSONObject) object;
        JSONObject compose = (JSONObject) jsonObject.get("compose");
        System.out.println("compose: " + compose);

        JSONArray soundex = (JSONArray) compose.get("soundex");
        System.out.println("\tsoundex: " + soundex);

        Object composeObj = jsonObject.get("compose");
        JSONObject jsonObject1 = (JSONObject) composeObj;
        Iterator itr = soundex.iterator();

        while (itr.hasNext()) {

            Object slide = itr.next();
            JSONObject jsonObject2 = (JSONObject) slide;
            JSONObject info = (JSONObject) jsonObject2.get("info");

            String date_of_birth = (String) info.get("date_of_birth");
            String name_id = (String) info.get("name_id");

            System.out.println("\t\tDate of Birth: " + date_of_birth);
            System.out.println("\t\tName Id: " + name_id);
        }
    }

    private class MyDto {

        Map<String, String> D;
        Map<String, String> args;
        String origin;
        String url;
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
