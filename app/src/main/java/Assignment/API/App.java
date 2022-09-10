package Assignment.API;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class App {

    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.adviceslip.com/advice")).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject responseObj = new JSONObject(response.body());
            String advice = (String)responseObj.getJSONObject("slip").get("advice");
            
            System.out.println("-----------------------------------------------");
            System.out.println("This program gives random advice. Here's yours:");
            System.out.println(advice);
        } catch (IOException | InterruptedException ex) {
            System.out.println("An error has occured: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

}
