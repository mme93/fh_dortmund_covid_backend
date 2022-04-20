package fh.dortmund.backend.covid.datenplatform.service;

import fh.dortmund.backend.covid.datenplatform.model.*;
import fh.dortmund.backend.covid.datenplatform.utility.CoronaJSON;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CoronaDatenplatformService {

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
    public CoronaDatenplatformService(CoronaJSON coronaJSON) {
        this.coronaJSON = coronaJSON;
    }

    public List<Impfdaten> getImpfdaten(int limit) throws URISyntaxException {
        for (Object object : coronaJSON.getJSONArrayFromGetRequest(limit, impfdaten)) {
            System.err.println(object);
        }
        return null;
    }

    public List<Hospitalisierung> getHospitalisierung(int limit) throws URISyntaxException {
        for (Object object : coronaJSON.getJSONArrayFromGetRequest(limit, hospitalisierung)) {
            System.err.println(object);
        }
        return null;
    }

    public List<ImpfdatenRegional> getImpfdatenRegional(int limit) throws URISyntaxException {
        List<ImpfdatenRegional> impfdatenRegionalList = new ArrayList<>();
        for (Object object : coronaJSON.getJSONArrayFromGetRequest(limit, impfdaten_regional)) {
            impfdatenRegionalList.add(new ImpfdatenRegional(
                    new JSONObject(object.toString()).get("_id").toString(),
                    new JSONObject(object.toString()).get("datum").toString(),
                    new JSONObject(object.toString()).get("bundesland").toString(),
                    new JSONObject(object.toString()).get("kreis").toString(),
                    new JSONObject(object.toString()).get("kr_zweitimpf").toString(),
                    new JSONObject(object.toString()).get("kr_drittimpf_18u60").toString(),
                    new JSONObject(object.toString()).get("kr_drittimpf_12u18").toString(),
                    new JSONObject(object.toString()).get("kr_zweitimpf_ab60").toString(),
                    new JSONObject(object.toString()).get("kr_erstimpf_12u18").toString(),
                    new JSONObject(object.toString()).get("kr_zweitimpf_12u18").toString(),
                    new JSONObject(object.toString()).get("kr_drittimpf").toString(),
                    new JSONObject(object.toString()).get("kr_erstimpf_ab60").toString(),
                    new JSONObject(object.toString()).get("kr_zweitimpf_18u60").toString(),
                    new JSONObject(object.toString()).get("kr_erstimpf_18u60").toString(),
                    new JSONObject(object.toString()).get("kr_erstimpf").toString(),
                    new JSONObject(object.toString()).get("kr_drittimpf_ab60").toString()
            ));
        }
        return impfdatenRegionalList;
    }

    public List<Intensivstationen> getIntensivstationen(int limit) throws URISyntaxException {
        List<Intensivstationen> intensivstationenList = new ArrayList<>();
        for (Object object : coronaJSON.getJSONArrayFromGetRequest(limit, intensivstationen)) {
            intensivstationenList.add(new Intensivstationen(
                    new JSONObject(object.toString()).get("_id").toString(),
                    new JSONObject(object.toString()).get("datum").toString(),
                    new JSONObject(object.toString()).get("kreis").toString(),
                    new JSONObject(object.toString()).get("bundesland").toString(),
                    new JSONObject(object.toString()).get("kr_its_bett_f_18").toString(),
                    new JSONObject(object.toString()).get("kr_its_bett_b").toString(),
                    new JSONObject(object.toString()).get("kr_its_inf_b").toString(),
                    new JSONObject(object.toString()).get("kr_its_meldeb").toString(),
                    new JSONObject(object.toString()).get("kr_its_inf_b_ant").toString(),
                    new JSONObject(object.toString()).get("kr_its_bett_f").toString(),
                    new JSONObject(object.toString()).get("kr_its_inf").toString(),
                    new JSONObject(object.toString()).get("kr_its_bett_ew").toString(),
                    new JSONObject(object.toString()).get("kr_its_bett").toString(),
                    new JSONObject(object.toString()).get("kr_its_kh").toString(),
                    new JSONObject(object.toString()).get("kr_its_bett_b_18").toString()
            ));
        }
        return intensivstationenList;
    }
    public List<InfektionenKreise> getInfektionenKreis(int limit) throws URISyntaxException {
        List<InfektionenKreise> infektionskreisListe = new ArrayList<>();
        JSONArray infektionskreisJSONArray = coronaJSON.getJSONArrayFromGetRequest(limit, genesene);
        for (int i=0;i<infektionskreisJSONArray.length();i++) {
            JSONObject infektionskreisJSON = infektionskreisJSONArray.getJSONObject(i);
            infektionskreisListe.add(new InfektionenKreise(
                    infektionskreisJSON.get("bundesland").toString(),
                    infektionskreisJSON.get("ags2").toString(),
                    infektionskreisJSON.get("kreis").toString(),
                    infektionskreisJSON.get("variable").toString(),
                    getDateValueListFromJSON(infektionskreisJSON.names(), infektionskreisJSON)
            ));
        }
        return infektionskreisListe;
    }

    public List<InfektionenBundeslaender> getInfektionenBundeslaender(int limit) throws URISyntaxException {
        List<InfektionenBundeslaender> infektionenBundeslaenderListe = new ArrayList<>();
        JSONArray infektionenBundeslaenderJSONArray = coronaJSON.getJSONArrayFromGetRequest(limit, genesene);
        for (int i=0;i<infektionenBundeslaenderJSONArray.length();i++) {
            JSONObject infektionenBundeslaenderJSON = infektionenBundeslaenderJSONArray.getJSONObject(i);
            infektionenBundeslaenderListe.add(new InfektionenBundeslaender(
                    infektionenBundeslaenderJSON.get("bundesland").toString(),
                    infektionenBundeslaenderJSON.get("ags2").toString(),
                    infektionenBundeslaenderJSON.get("variable").toString(),
                    getDateValueListFromJSON(infektionenBundeslaenderJSON.names(), infektionenBundeslaenderJSON)
            ));
        }
        return infektionenBundeslaenderListe;
    }
    public List<Genesene> getGenesene(int limit) throws URISyntaxException {
        List<Genesene> geneseneListe = new ArrayList<>();
        JSONArray genesenJSONArray = coronaJSON.getJSONArrayFromGetRequest(limit, genesene);
        for (int i=0;i<genesenJSONArray.length();i++) {
            JSONObject genesenJSON = genesenJSONArray.getJSONObject(i);
            geneseneListe.add(new Genesene(
                    genesenJSON.get("bundesland").toString(),
                    genesenJSON.get("ags2").toString(),
                    genesenJSON.get("kreis").toString(),
                    genesenJSON.get("variable").toString(),
                    getDateValueListFromJSON(genesenJSON.names(), genesenJSON)
            ));
        }
        return geneseneListe;
    }
    public List<Todesfaelle> getTodesfaelle(int limit) throws URISyntaxException {
        List<Todesfaelle> todesfaelleList = new ArrayList<>();
        JSONArray todesfaelleJSONArray = coronaJSON.getJSONArrayFromGetRequest(limit, todesfaelle);
        for (int i = 0; i < todesfaelleJSONArray.length(); i++) {
            JSONObject todesfallJSON = todesfaelleJSONArray.getJSONObject(i);
            todesfaelleList.add(new Todesfaelle(
                    todesfallJSON.get("bundesland").toString(),
                    todesfallJSON.get("ags2").toString(),
                    todesfallJSON.get("kreis").toString(),
                    todesfallJSON.get("variable").toString(),
                    getDateValueListFromJSON(todesfallJSON.names(), todesfallJSON)
            ));
        }
        return todesfaelleList;
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

    //Utility Method for Date Converting
    public List<DateValue> getDateValueListFromJSON(JSONArray dateArrayJSON, JSONObject dateValuesJSON) {
        List<DateValue> dateValueList = new ArrayList<>();
        for (Object jsonKey : dateArrayJSON) {
            String date = jsonKey.toString();
            if (date.startsWith("d")) {
                dateValueList.add(new DateValue(date.substring(1), dateValuesJSON.get(date).toString()));
            }
        }
        dateValueList = sortDate(dateValueList);
        for (DateValue dateValue : dateValueList) {
            String date = dateValue.getDate();
            dateValue.setDate(date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6));
        }
        return dateValueList;
    }

    public List<DateValue> sortDate(List<DateValue> dateValueList) {
        List<DateValue> newDateValueList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        for (DateValue dateValue : dateValueList) {
            try {
                integerList.add(Integer.parseInt(dateValue.getDate()));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        Collections.sort(integerList);
        for (Integer date : integerList) {
            for(DateValue dateValue : dateValueList){
                if(Integer.parseInt(dateValue.getDate())==date){
                    newDateValueList.add(dateValue);
                }
            }

        }
        return newDateValueList;
    }
}
