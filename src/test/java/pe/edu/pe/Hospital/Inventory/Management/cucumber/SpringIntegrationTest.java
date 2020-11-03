package pe.edu.pe.Hospital.Inventory.Management.cucumber;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import pe.edu.pe.Hospital.Inventory.Management.HospitalInventoryManagementServiceApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = HospitalInventoryManagementServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SpringIntegrationTest {
    static ResResults latestResponse = null;

    @Autowired
    protected RestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8091/";

    void executeGet(String url) throws IOException {
        final Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        final HeaderCallbackSettings requestCallback = new HeaderCallbackSettings(headers);
        final ResponseResultErrorHandler errorHandler = new ResponseResultErrorHandler();

        restTemplate.setErrorHandler(errorHandler);
        latestResponse = restTemplate.execute(BASE_URL + url, HttpMethod.GET, requestCallback, response -> {
            if (errorHandler.hadError) {
                return (errorHandler.getResults());
            } else {
                return (new ResResults(response));
            }
        });
    }

    void executePost(String url, String body) throws IOException {
        final Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        final HeaderCallbackSettings requestCallback = new HeaderCallbackSettings(headers);
        requestCallback.setBody(body);
        final ResponseResultErrorHandler errorHandler = new ResponseResultErrorHandler();
        if (restTemplate == null) {
            restTemplate = new RestTemplate();
        }

        restTemplate.setErrorHandler(errorHandler);
        latestResponse = restTemplate
                .execute( BASE_URL + url, HttpMethod.POST, requestCallback, response -> {
                    if (errorHandler.hadError) {
                        return (errorHandler.getResults());
                    } else {
                        return (new ResResults(response));
                    }
                });
    }

    private static class ResponseResultErrorHandler implements ResponseErrorHandler {
        private ResResults results = null;
        private Boolean hadError = false;

        private ResResults getResults() {
            return results;
        }

        @Override
        public boolean hasError(ClientHttpResponse response) throws IOException {
            hadError = response.getRawStatusCode() >= 400;
            return hadError;
        }

        @Override
        public void handleError(ClientHttpResponse response) throws IOException {
            results = new ResResults(response);
        }
    }

}
