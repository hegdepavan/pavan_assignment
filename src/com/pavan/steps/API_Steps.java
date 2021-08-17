package com.pavan.steps;

import org.hamcrest.Matchers;

import com.pavan.pages.Base_Template;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import com.qmetry.qaf.automation.ws.rest.RestTestBase;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;

public class API_Steps extends Base_Template {

	private static RestTestBase base = new RestTestBase();
	private static String endPt = "";
	private static String baseUri = ConfigurationManager.getBundle().getPropertyValue("api.base.url");
	private static String URL = "";

	@QAFTestStep(description = "user have {0} API url with data {1}")
	public void userHaveAPIUrlWithData(String endPoint, String param) {
		if (endPoint.equalsIgnoreCase("appointment")) {
			endPt = ConfigurationManager.getBundle().getPropertyValue(param);
		}
		URL = baseUri + endPt;
		Reporter.log("API URL ---> " + URL);
	}

	@QAFTestStep(description = "user send {0} request")
	public void userSendRequest(String reqMethod) {
		WebResource wr;
		Builder reqBuilder;
		wr = base.getClient().resource(URL);

		switch (reqMethod) {
		case "GET":
			reqBuilder = wr.type("application/json").header("content-type", "application/json");
			reqBuilder.get(ClientResponse.class);
			Reporter.log("Sent GET request.....");
			Reporter.log(base.getResponse().getResponseDate().toString());
			break;

		default:
			break;
		}

	}

	@QAFTestStep(description = "response status code should be {0}")
	public void responseStatusCodeShouldBe(String expectedStatusCode) {
		Validator.verifyThat("Status code ", base.getResponse().getStatus().getStatusCode(),
				Matchers.equalTo(expectedStatusCode));

	}

	@QAFTestStep(description = "print the response body in console")
	public void printTheResponseBodyInConsole() {
		Reporter.log("Response body ===== > " + base.getResponse().getMessageBody());
		System.out.println(base.getResponse().getMessageBody());
	}

}
