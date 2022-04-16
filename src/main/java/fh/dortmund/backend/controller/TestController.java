package fh.dortmund.backend.controller;

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

    @GetMapping("/")
    public String getTest() throws URISyntaxException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE2NDk5NDkxNTcsImp0aSI6ImFMVGJudGlzQ1MtSHVGWi15R2IyWGZTZ082VUptWldZVG9ZbFZJc2RMNFEifQ.fNtAZJVhB1UZAF7ecY8E_1s15zWU19HXkHHHTD2l5Sg" );
        RestTemplate restTemplate = new RestTemplate();
        URI url= new URI("https://www.corona-datenplattform.de/api/3/action/datastore_search?limit=5&resource_id=af5ad86a-5c10-48e0-a232-1e3464ae4270&");

        ResponseEntity response = restTemplate.exchange(url,
                HttpMethod.GET,
                new HttpEntity(headers) ,String.class);

        System.out.println(response.getBody());


        //http://localhost/showck.php

        return "test";
    }
}
