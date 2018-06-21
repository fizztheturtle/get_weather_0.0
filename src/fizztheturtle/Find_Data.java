package fizztheturtle;


//"Contains public sector information licensed under the Open Government Licence"

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Find_Data {

    public static void main(String[] args) throws Exception {
	// write your code here
        Find_Data obj;
        obj = new Find_Data();
        System.out.println(obj.getFile("fizztheturtle/API_Key.txt"));
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
