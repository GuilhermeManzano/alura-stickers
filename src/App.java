import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        //String url = "https://imdb-api.com/en/API/Top250Movies/k_0ojt0yvm";
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        String response = getApiResponse(url);

        Movies listMovies = new ObjectMapper().readValue(response, Movies.class);

        generateSickers(listMovies);
    }

    private static String getApiResponse(String url) throws IOException, InterruptedException {
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(URI.create(url)).GET().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    private static void generateSickers(Movies listMovies) {
        listMovies.getItems().forEach(GeradorDeFigurinha::gerarFigurinha);
    }
}
