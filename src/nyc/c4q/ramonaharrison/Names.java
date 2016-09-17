package nyc.c4q.ramonaharrison;

/**
 * Created by nesadakoca on 9/17/16.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Random;


public class Names {
    public String randomName (String input) throws Exception {
        String urlInserted = "";
        String wordToCheck = "";
        if (input.equals("m")) {
            urlInserted = "http://deron.meranda.us/data/census-dist-male-first.txt";
        }else if (input.equals("f")){
            urlInserted = "http://deron.meranda.us/data/census-dist-female-first.txt";
        }
        stringToURL(urlInserted);


        URL oracle = new URL(urlInserted);
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine = "";

        ArrayList<String> allNames = new ArrayList<>();

        while ((inputLine = in.readLine()) != null) {
            //  System.out.println(inputLine);  //this print the whole text page line by line

            String arr[] = inputLine.split(" ", 2);
            inputLine = arr[0]; //get the first word of the String
            allNames.add(inputLine);

        }

        in.close();
        String[] threeRandomNames = new String[3];


        Random random = new Random();
        String  randomElement = allNames.get(random.nextInt(allNames.size()));
        threeRandomNames[0] = randomElement;
        randomElement = allNames.get(random.nextInt(allNames.size()));
        threeRandomNames[1] = randomElement;
        randomElement = allNames.get(random.nextInt(allNames.size()));
        threeRandomNames[2] = randomElement;

        String all = threeRandomNames[0] + "\n" +threeRandomNames[1] + "\n" +threeRandomNames[2];
        return all;
    }

    //Interprets a string as a URL.  If the string isn't a valid URL, prints an error message and returns null.
    public static URL stringToURL(String string) {
        try {
            return new URL(string);
        } catch (MalformedURLException exception) {
            System.err.println("invalid URL: " + string + ": " + exception);
            System.exit(0);
            return null;
        }
    }
}
