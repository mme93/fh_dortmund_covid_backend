package fh.dortmund.backend.covid.service;

import fh.dortmund.backend.covid.model.MassnahmenIndexMonat;
import fh.dortmund.backend.utility.CoronaJSON;
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

    @Value("${corona-datenplattform-tabel.trends}")
    private String trends;

    private final CoronaJSON coronaJSON;

    @Autowired
    public CoronaService(CoronaJSON coronaJSON) {
        this.coronaJSON = coronaJSON;
    }

    public void getTrends() throws URISyntaxException {
        for (Object object : coronaJSON.getJSONArrayFromGetRequest(5,trends)) {
            System.err.println(object);
        }
    }


    public List<MassnahmenIndexMonat> getMassnahmenIndexMonat() throws URISyntaxException {
        List<MassnahmenIndexMonat> massnahmenIndexMonatList = new ArrayList<>();
        for (Object object : coronaJSON.getJSONArrayFromGetRequest(5,kr_massnahmen_index_monat)) {
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
