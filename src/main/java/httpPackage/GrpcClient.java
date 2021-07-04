package httpPackage;
import java.io.IOException;
import java.net.URI;
import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

public class GrpcClient {
	public static void main(String[] args)
	{
		try {
			// Create a HttpClient
			HttpClient httpClient
				= HttpClient.newHttpClient();

			// create a HttpRequest object with the URL
			HttpRequest httpRequest
				= HttpRequest
					.newBuilder()
					.uri(new URI("http://localhost:8080/v1/grpc/{ping}"))
					.GET()
					.build();
			// Synchronous send() method
			// to process the HTTP request.
			// HttpResponse.BodyHandler.asString() handles
			// the body of the response as a String.
			HttpResponse<String> httpResponse
				= httpClient.send(
					httpRequest,
					HttpResponse.BodyHandler.asString());

			// statusCode() returns the status code
			// for this response.
			System.out.println(
				"Status of operation performed:"
				+ httpResponse.statusCode());
		}
		catch (Exception e) {
			System.out.println("Exception" + e);
		}
	}
}
