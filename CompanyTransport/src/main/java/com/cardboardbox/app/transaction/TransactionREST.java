package com.cardboardbox.app.transaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.cardboardbox.app.model.Responsetrans;
import com.cardboardbox.app.model.Transportadora;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TransactionREST {
	public static Transportadora[] getDataFromRest() {
		try {

			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet getRequest = new HttpGet("http://localhost:8080/service/transportadora");
			getRequest.addHeader("accept", "application/json");

			HttpResponse response = httpClient.execute(getRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

			String output;
			StringBuilder sb = new StringBuilder();
			while ((output = br.readLine()) != null) {
				sb.append(output);
			}
			httpClient.getConnectionManager().shutdown();
			ObjectMapper mapper = new ObjectMapper();
			Transportadora[]  obj = mapper.readValue(sb.toString(), Transportadora[].class);
			return obj;
		} catch (ClientProtocolException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;
	}
}
