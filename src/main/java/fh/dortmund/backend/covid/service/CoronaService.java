package fh.dortmund.backend.covid.service;

import fh.dortmund.backend.utility.HttpGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;

@Service
public class CoronaService {

    @Value("${corona-datenplattform-tabel.kr_massnahmen_index_monat}")
    private String kr_massnahmen_index_monat;

    private final HttpGenerator httpGenerator;

    @Autowired
    public CoronaService(HttpGenerator httpGenerator) {
        this.httpGenerator = httpGenerator;
    }

    public String getMassnahmenIndexMonat() throws URISyntaxException {
         return new RestTemplate().exchange(this.httpGenerator.generateURIWithLimitAndResourceId(32000, kr_massnahmen_index_monat),
                HttpMethod.GET,
                new HttpEntity(this.httpGenerator.getHeaderWithToken()), String.class).getBody();
    }
}
