

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;





public class Febreze {

	

public void changeColor(int color) throws IOException{
	OkHttpClient client = new OkHttpClient();

    MediaType mediaType = MediaType.parse((String) "application/json");
	RequestBody body = RequestBody.create(mediaType, "[{\"DeviceAction\": \"led_mode=1\" }, {\"DeviceAction\": \"led_color=0," + Integer.toString(color)
			+ ",4,4,4\" }]");
	Request request = new Request.Builder()
	  .url("https://na-hackathon-api.arrayent.io:443/v3/devices/50331660")
	  .put(body)
	  .addHeader("authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGllbnRfaWQiOiI4MzcyNjVlMC0wMWNmLTExZTctYWU0Ni01ZmMyNDA0MmE4NTMiLCJlbnZpcm9ubWVudF9pZCI6Ijk0OGUyY2YwLWZkNTItMTFlNi1hZTQ2LTVmYzI0MDQyYTg1MyIsInVzZXJfaWQiOiI5MDAwMDg5Iiwic2NvcGVzIjoie30iLCJncmFudF90eXBlIjoiYXV0aG9yaXphdGlvbl9jb2RlIiwiaWF0IjoxNDg4NzM3Njc3LCJleHAiOjE0ODk5NDcyNzd9.cI5zBuHSVS-Xngr4U0c8OZDKz85er4ZcZ3xSh1fhQYedRW7RNzS6_0FhcjJ0WoBxuDhlNAEdTTvbLVejM4DRug")
	  .addHeader("content-type", "application/json")
	  .addHeader("cache-control", "no-cache")
	  .addHeader("postman-token", "0a3a4902-1792-03de-853c-52b62ae79e7f")
	  .build();

	Response response = client.newCall(request).execute();
	
	
	

}
}
