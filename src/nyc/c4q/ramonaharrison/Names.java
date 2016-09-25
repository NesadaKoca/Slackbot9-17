package nyc.c4q.ramonaharrison;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Random;


public class Names {

    public int numNames = 3;

    public String randomName (String input) throws Exception {
        String urlInserted = "";
        String wordToCheck = "";
        if (input.equals("m")) { // check if the parameter input is equal with the String "m"
            urlInserted = "http://deron.meranda.us/data/census-dist-male-first.txt";
        }else if (input.equals("f")){ // check if the parameter input is equal with the String "m"
            urlInserted = "http://deron.meranda.us/data/census-dist-female-first.txt";
        }
        stringToURL(urlInserted); // this method check if urlInserted is a real URL, if not is gonna show us an error


        URL oracle = new URL(urlInserted);
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine = "";

        ArrayList<String> allNames = new ArrayList<>();

        while ((inputLine = in.readLine()) != null) {
            //  System.out.println(inputLine);  //this print the whole text page line by line

            String arr[] = inputLine.split(" ", 2); // take the first line from the url, and save the fisrt word in the arr[0], and the rest in the arr[1]
            inputLine = arr[0]; //get the first element of the arr[]
            allNames.add(inputLine); // add all the names that are in the url one by one to our arraylist allNames until the While statement finish

        }

        in.close();

        String[] threeRandomNames = new String[numNames];
        String all = "";

        Random random = new Random();

        for (int i = 0; i<numNames; i++) {


            String randomElement = allNames.get(random.nextInt(allNames.size()));
            threeRandomNames[i] = randomElement;

            all = all + threeRandomNames[i] + "\n";
        }
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