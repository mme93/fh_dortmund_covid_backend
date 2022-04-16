package fh.dortmund.backend.covid.service;

import fh.dortmund.backend.covid.model.MassnahmenIndexMonat;
import fh.dortmund.backend.utility.HttpGenerator;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoronaService {

    @Value("${corona-datenplattform-tabel.kr_massnahmen_index_monat}")
    private String kr_massnahmen_index_monat;

    private final HttpGenerator httpGenerator;

    @Autowired
    public CoronaService(HttpGenerator httpGenerator) {
        this.httpGenerator = httpGenerator;
    }

    public List<MassnahmenIndexMonat> getMassnahmenIndexMonat() throws URISyntaxException {
        List<MassnahmenIndexMonat> massnahmenIndexMonatList = new ArrayList<>();
        String json = new RestTemplate().exchange(this.httpGenerator.generateURIWithLimitAndResourceId(5, kr_massnahmen_index_monat),
                HttpMethod.GET,
                new HttpEntity(this.httpGenerator.getHeaderWithToken()), String.class).getBody();
        JSONObject jsonObject = new JSONObject(json);
        jsonObject = jsonObject.getJSONObject("result");
        for (Object object : jsonObject.getJSONArray("records")) {
            massnahmenIndexMonatList.add(new MassnahmenIndexMonat(
                    new JSONObject(object.toString()).get("_id").toString(),
                    new JSONObject(object.toString()).get("ags2").toString(),
                    new JSONObject(object.toString()).get("bundesland").toString(),
                    new JSONObject(object.toString()).get("ags5").toString(),
                    new JSONObject(object.toString()).get("kreis").toString(),
                    new JSONObject(object.toString()).get("datum").toString(),
                    new JSONObject(object.toString()).get("kr_mn_idx_m").toString()));
        }
        return massnahmenIndexMonatList;
    }
}
