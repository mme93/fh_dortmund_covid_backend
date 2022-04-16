package fh.dortmund.backend.controller;

import fh.dortmund.backend.utility.HttpGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class TestController {

    @Value("${corona-datenplattform.token}")
    private String token;

    private final HttpGenerator httpGenerator;

    @Autowired
    public TestController(HttpGenerator httpGenerator) {
        this.httpGenerator = httpGenerator;
    }

    @GetMapping("/test")
    public String test() throws URISyntaxException {
        return new RestTemplate().exchange(this.httpGenerator.generateURIWithLimitAndResourceId(5, "af5ad86a-5c10-48e0-a232-1e3464ae4270"),
                HttpMethod.GET,
                new HttpEntity(this.httpGenerator.getHeaderWithToken()), String.class).getBody();
    }

}
