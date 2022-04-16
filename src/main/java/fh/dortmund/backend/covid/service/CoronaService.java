package fh.dortmund.backend.covid.service;

import fh.dortmund.backend.utility.HttpGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;

@Service
public class CoronaService {

    private final HttpGenerator httpGenerator;

    @Autowired
    public CoronaService(HttpGenerator httpGenerator) {
        this.httpGenerator = httpGenerator;
    }

    public String getMassnahmenIndexMonat() throws URISyntaxException {
         return new RestTemplate().exchange(this.httpGenerator.generateURIWithLimitAndResourceId(32000, "23e25743-85c5-4dc8-8639-8bb11c339b19"),
                HttpMethod.GET,
                new HttpEntity(this.httpGenerator.getHeaderWithToken()), String.class).getBody();
    }
}
