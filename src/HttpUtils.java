import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpUtils {

    public static HttpResponse<String> sendGet(String url) throws IOException, InterruptedException {
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

}
