/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.exit;

public class App {

    public static void main(String[] args) {
        System.out.println(getQuoteFromAPI());
    }

    // this function makes an API request for a quote
    public static Quote getQuoteFromAPI(){
        try{
            URL url = new URL("https://ron-swanson-quotes.herokuapp.com/v2/quotes");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            // this line of code actually goes to the internet!
            BufferedReader reader = new BufferedReader(new InputStreamReader((con.getInputStream())));
            // get json data in response
            // use Gson to parse json string
            Gson gson = new Gson();
            String[] text = gson.fromJson(reader, String[].class);
            // Create Quote object
            Quote quote = new Quote(null, "Ron Swanson", null, text[0]);
            addQuoteToFile(quote);
            return quote;
        } catch(IOException e) {
            // This is where we check cached.
            return getQuoteFromFile();
        }
    }

    public static boolean addQuoteToFile(Quote quote){
        try{
            Quote[] quotes = readFromJson("src/main/resources/swansonquotes.json");
            // Add quote to array
            List<Quote> quoteList = new ArrayList<>();
            if(quotes != null) quoteList = new ArrayList<Quote>(Arrays.asList(quotes));
            quoteList.add(quote);
            Quote[] tempQuotes = quoteList.toArray(new Quote[quoteList.size()]);
            // Write quotes to file
            writeToJson(tempQuotes, "src/main/resources/swansonquotes.json");
            return true;
        }catch(IOException e){
            System.out.println("There was an error writing this to the file");
            return false;
        }
    }

    public static Quote getQuoteFromFile(){
        Quote[] quotes = null;
        try {
            quotes = readFromJson("src/main/resources/swansonquotes.json");
        } catch (IOException e) {
            System.out.println("This is unforunate, the API is down and we don't have quotes cached yet =(");
            exit(0);
        }
        return quotes[(int)(Math.random() * quotes.length )];
    }

    // This function writes an array of quotes to a file
    public static boolean writeToJson(Quote[] quotes, String filename) throws IOException {
        Gson write = new Gson();
        OutputStream outStream = new FileOutputStream(filename);
        BufferedWriter buffer = new BufferedWriter(new OutputStreamWriter(outStream));
        write.toJson(quotes, buffer);
        buffer.close();
        return true;
    }

    // This function reads from the json and returns an array of quotes
    public static Quote[] readFromJson(String filename) throws IOException {
        File file = new File(filename);
        file.createNewFile();
        Gson read = new Gson();
        InputStream inStream = new FileInputStream(filename);
        BufferedReader buffer = new BufferedReader(new InputStreamReader(inStream));
        Quote[] quotes = read.fromJson(buffer, Quote[].class);
        buffer.close();
        return quotes;
    }
}
