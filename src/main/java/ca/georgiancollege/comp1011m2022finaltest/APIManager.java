package ca.georgiancollege.comp1011m2022finaltest;

import com.google.gson.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class APIManager
{
    /********************* SINGLETON SECTION *****************************/
    // Step 1. private static instance member variable
    private static APIManager m_instance = null;
    // Step 2. make the default constructor private
    private APIManager() {}
    // Step 3. create a public static entry point / instance method
    public static APIManager Instance()
    {
        // Step 4. Check if the private instance member variable is null
        if(m_instance == null)
        {
            // Step 5. Instantiate a new APIManager instance
            m_instance = new APIManager();
        }
        return m_instance;
    }
    /*********************************************************************/

    /* TODO -- Fill in with useful methods to read Customer information */

    public ArrayList<Customer> parseJsonFile(){
        ArrayList<Customer> customers = new ArrayList<>();
        try (Reader reader = new InputStreamReader(this.getClass()
                .getResourceAsStream("customers.json"))) {
            JsonParser parser = new JsonParser();
            JsonObject rootObj = parser.parse(reader).getAsJsonObject();
            JsonArray customersArray = rootObj.getAsJsonArray("Customers");
            for(JsonElement customer: customersArray){
                Customer result = new Gson().fromJson(customer.getAsJsonObject(), Customer.class);
                customers.add(result);
                //System.out.println(result.getFirstName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;

    }
}
