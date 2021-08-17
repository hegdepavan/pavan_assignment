package com.pavan.steps;

import com.qmetry.qaf.automation.ws.rest.RestTestBase;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;

public class API_SampleTest {
	private static RestTestBase base = new RestTestBase();

	public static void main(String[] args) {

		String url = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByDistrict?district_id=512&date=31-07-2021";
		WebResource wr = base.getClient().resource(url);
		Builder reqBuilder = wr.type("application/json").header("content-type", "application/json");
		reqBuilder.get(ClientResponse.class);
		System.out.println(base.getResponse().getStatus().getStatusCode());
		System.out.println(base.getResponse().getResponseDate());
		System.out.println(base.getResponse().getMessageBody());
	}

}
