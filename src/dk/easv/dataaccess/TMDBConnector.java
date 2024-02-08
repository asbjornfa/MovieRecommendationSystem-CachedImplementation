package dk.easv.dataaccess;


import dk.easv.entities.TMDBMovie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

// REST connector for interacting with The Movie Database (TMDb) API
public class TMDBConnector {

    private List<TMDBMovie> apiResults;

    // Instance variable to store information about the found movie from TMDb
    private TMDBMovie moviesFound;

    // Constructor to initiate a movie search by title
    public TMDBConnector() throws JSONException, IOException, URISyntaxException, InterruptedException {
        searchMovie();
    }

    // Method to retrieve the TMDb API key from the configuration file
    public static String getApiKey() {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("config/config.api")) {
            properties.load(fileInputStream);
            return properties.getProperty("API_KEY");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Private method to search for a movie on TMDb by title
    private void searchMovie() throws IOException, URISyntaxException, InterruptedException, JSONException {

        apiResults = new ArrayList<>();

        // Create a new HttpClient for making requests
        HttpClient client = HttpClient.newHttpClient();

        // Get the TMDb API key
        String apiKey = getApiKey();

        // Encode the title for use in the URL
        String query = URLEncoder.encode("UTF-8");

        // Build the HTTP request for searching movies on TMDb
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.themoviedb.org/3/trending/movie/week?language=en-US"))
                .header("accept", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        // Send the HTTP request and get the response
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        // Parse the JSON response
        JSONObject jsonResponse = new JSONObject(response.body());
        JSONArray data = jsonResponse.getJSONArray("results");

        // Check if there are results
        for (int i = 0; i < data.length(); i++) {

            // Extract information about the first movie in the results
            JSONObject movieObject = data.getJSONObject(i);
            String jsonTitle = movieObject.getString("original_title");
            String jsonImage = movieObject.getString("poster_path");

            // Create a new TMDBMovie object with the extracted information
            moviesFound = new TMDBMovie(jsonTitle, jsonImage);

            apiResults.add(moviesFound);

        }
    }

    // Getter method to retrieve the found movies from TMDb
    public List<TMDBMovie> getMoviesFound() {
        return apiResults;
    }


    // Main method for testing the TMDBConnector class
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException, JSONException {
        // Create a TMDBConnector instance with a movie search query
        TMDBConnector tmdbConnector = new TMDBConnector();

        List<TMDBMovie> movies = tmdbConnector.getMoviesFound();
        for (TMDBMovie movie : movies) {
            // Retrieve the found movie and print its details
            System.out.println(movie.getOriginal_title());
            System.out.println(movie.getPoster_path());
            System.out.println("__________");
        }
    }
}
