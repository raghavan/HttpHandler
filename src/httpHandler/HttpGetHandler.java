package httpHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpGetHandler {

	public static final String URL = "http://www.google.com";

	public static void main(String args[]) {
		getResponse();
	}

	public static void getResponse() {
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(URL);

		/*Use the following header to set some header spec*/
		//request.setHeader("accessKey","");
		//request.setHeader("accept", "application/json");

		HttpResponse response;
		BufferedReader rd;
		try {
			response = client.execute(request);
			rd = new BufferedReader(new InputStreamReader(response.getEntity()
					.getContent()));
			String line = new String();
			while ((line = rd.readLine()) != null) {
				System.out.println(line);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
