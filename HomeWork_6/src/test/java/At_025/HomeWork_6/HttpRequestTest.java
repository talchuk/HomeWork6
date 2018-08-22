package At_025.HomeWork_6;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpRequestTest {

	private OkHttpClient client;

	@BeforeMethod(alwaysRun = true)
	public void setupHttpClient() {
		client = new OkHttpClient();
	}

	@Test (priority = 0)
	public void HttpHtmlTest() throws IOException {
		Request request = new Request.Builder().url("https://rozetka.com.ua/").build();
		Response response = client.newCall(request).execute();

		Assert.assertEquals(response.code(), 200, "Status code was not 200");
		Assert.assertTrue(response.header("Content-Type").contains("text/html"),
				"text/html content type was not detected");
		String responseBody = response.body().string();
		System.out.println(responseBody);

		Assert.assertTrue(responseBody.contains("btn-link-i"), " element was not found");

	}

}
