package fh.dortmund.backend.covid.service;

import fh.dortmund.backend.covid.model.MassnahmenIndexMonat;
import fh.dortmund.backend.covid.model.Trends;
import fh.dortmund.backend.utility.CoronaJSON;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoronaService {

    @Value("${corona-datenplattform-tabel.kr_massnahmen_index_monat}")
    private String kr_massnahmen_index_monat;

    @Value("${corona-datenplattform-tabel.trends}")
    private String trends;

    @Value("${corona-datenplattform-tabel.todesfaelle}")
    private String todesfaelle;

    @Value("${corona-datenplattform-tabel.intensivstationen}")
    private String intensivstationen;

    @Value("${corona-datenplattform-tabel.infektionen_bundeslaender}")
    private String infektionen_bundeslaender;

    @Value("${corona-datenplattform-tabel.infektionen_kreise}")
    private String infektionen_kreise;

    @Value("${corona-datenplattform-tabel.impfdaten_regional}")
    private String impfdaten_regional;

    @Value("${corona-datenplattform-tabel.hospitalisierung}")
    private String hospitalisierung;

    @Value("${corona-datenplattform-tabel.genesene}")
    private String genesene;

    @Value("${corona-datenplattform-tabel.impfdaten}")
    private String impfdaten;

    private final CoronaJSON coronaJSON;

    @Autowired
    public CoronaService(CoronaJSON coronaJSON) {
        this.coronaJSON = coronaJSON;
    }

    public void getImpfdaten(int limit) throws URISyntaxException {
        for (Object object : coronaJSON.getJSONArrayFromGetRequest(limit, impfdaten)) {

        }
    }

    public void getGenesene(int limit) throws URISyntaxException {
        for (Object object : coronaJSON.getJSONArrayFromGetRequest(limit, genesene)) {

        }
    }

    public void getHospitalisierung(int limit) throws URISyntaxException {
        for (Object object : coronaJSON.getJSONArrayFromGetRequest(limit, hospitalisierung)) {

        }
    }

    public void getImpfdatenRegional(int limit) throws URISyntaxException {
        for (Object object : coronaJSON.getJSONArrayFromGetRequest(limit, impfdaten_regional)) {

        }
    }

    public void getInfektionenKreis(int limit) throws URISyntaxException {
        for (Object object : coronaJSON.getJSONArrayFromGetRequest(limit, infektionen_kreise)) {

        }
    }

    public void getInfektionenBundeslaender(int limit) throws URISyntaxException {
        for (Object object : coronaJSON.getJSONArrayFromGetRequest(limit, infektionen_bundeslaender)) {

        }
    }

    public void getIntensivstationen(int limit) throws URISyntaxException {
        for (Object object : coronaJSON.getJSONArrayFromGetRequest(limit, intensivstationen)) {

        }
    }

    public void getTodesfaelle(int limit) throws URISyntaxException {
        for (Object object : coronaJSON.getJSONArrayFromGetRequest(limit, todesfaelle)) {

        }
    }

    public List<Trends> getTrends(int limit) throws URISyntaxException {
        List<Trends> trendsList = new ArrayList<>();
        for (Object object : coronaJSON.getJSONArrayFromGetRequest(limit, trends)) {
            trendsList.add(new Trends(
                    new JSONObject(object.toString()).get("_id").toString(),
                    new JSONObject(object.toString()).get("meldedatum").toString(),
                    new JSONObject(object.toString()).get("bundesland").toString(),
                    new JSONObject(object.toString()).get("ags2").toString(),
                    new JSONObject(object.toString()).get("kreis").toString(),
                    new JSONObject(object.toString()).get("kr_inz_rate").toString(),
                    new JSONObject(object.toString()).get("kr_trend").toString(),
                    new JSONObject(object.toString()).get("kr_trend_kl").toString()
            ));
        }
        return trendsList;
    }


    public List<MassnahmenIndexMonat> getMassnahmenIndexMonat() throws URISyntaxException {
        List<MassnahmenIndexMonat> massnahmenIndexMonatList = new ArrayList<>();
        for (Object object : coronaJSON.getJSONArrayFromGetRequest(5, kr_massnahmen_index_monat)) {
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
