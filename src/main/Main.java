package src.main;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
// import java.nio.file.Files;
// import java.nio.file.Path;

class Main {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://pokeapi.co/api/v2/pokemon/greninja"))
            .GET()
            .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            // Files.writeString(Path.of("pokemon.json"), response.body());
            // System.out.println("Saved response to pokemon.json");
        } catch (IOException e) {
            System.err.println("Request or file write failed: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Request was interrupted");
        }
        
        Gson gson = new Gson();

    }
}