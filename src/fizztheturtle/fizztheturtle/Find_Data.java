package fizztheturtle;


//"Contains public sector information licensed under the Open Government Licence"
// add a 250 counter per minute for requests
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;

public class Find_Data {

    public static void main(String[] args) throws Exception {
	// write your code here
        Find_Data obj;
        obj = new Find_Data();
        System.out.println(obj.getFile("fizztheturtle/API_Key.txt"));

        URL url = new URL("https://httpbin.org/get?color=red&shape=oval");
        InputStreamReader reader = new InputStreamReader(url.openStream());

        MyDto dto = new Gson().fromJson(reader, MyDto.class);

        // using the de-serialised object
        System.out.println(dto.headers);
        System.out.println(dto.args);
        System.out.println(dto.origin);
        System.out.println(dto.url);
    }

    private class MyDto {

        Map<String, String> headers;
        Map<String, String> args;
        String origin;
        String url;
    }

    private String getFile(String fileName) {

        StringBuilder result = new StringBuilder("");

        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

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
