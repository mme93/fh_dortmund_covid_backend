package fh.dortmund.backend.covid.RKI.service;

import fh.dortmund.backend.covid.RKI.model.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Service
public class RKIService {
    //Info für die REST-API Schnittstellen
    //https://arcgis.esri.de/nutzung-der-api-des-rki-covid-19-dashboard/

    public void getHospitalisierungen(){

    }

    public List<TagesDaten> getTagesDaten() throws IOException {
        List<TagesDaten> tagesDatenList = new ArrayList<>();
        try {
            URL url = new URL(
                    "https://services7.arcgis.com/mOBPykOjAyBO2ZKk/arcgis/rest/services/rki_key_data_v/FeatureServer/0/query?where=1%3D1&outFields=*&outSR=4326&f=json");
            JSONObject tagesDatenListJson = new JSONObject(IOUtils.toString(url, Charset.forName("UTF-8")));
            JSONArray tagesDatenJsonArray = tagesDatenListJson.names();
            for (Object obj : tagesDatenJsonArray) {
                if (obj.toString().equals("features")) {
                    JSONArray tagesDatenArray = tagesDatenListJson.getJSONArray("features");
                    for (int i = 0; i < tagesDatenArray.length(); i++) {
                        tagesDatenList.add(new TagesDaten(
                                tagesDatenArray.getJSONObject(i).getJSONObject("attributes").get("AdmUnitId").toString(),
                                tagesDatenArray.getJSONObject(i).getJSONObject("attributes").get("BundeslandId").toString(),
                                tagesDatenArray.getJSONObject(i).getJSONObject("attributes").get("AnzFall").toString(),
                                tagesDatenArray.getJSONObject(i).getJSONObject("attributes").get("AnzTodesfall").toString(),
                                tagesDatenArray.getJSONObject(i).getJSONObject("attributes").get("AnzFallNeu").toString(),
                                tagesDatenArray.getJSONObject(i).getJSONObject("attributes").get("AnzTodesfallNeu").toString(),
                                tagesDatenArray.getJSONObject(i).getJSONObject("attributes").get("AnzFall7T").toString(),
                                tagesDatenArray.getJSONObject(i).getJSONObject("attributes").get("AnzGenesen").toString(),
                                tagesDatenArray.getJSONObject(i).getJSONObject("attributes").get("AnzGenesenNeu").toString(),
                                tagesDatenArray.getJSONObject(i).getJSONObject("attributes").get("AnzAktiv").toString(),
                                tagesDatenArray.getJSONObject(i).getJSONObject("attributes").get("AnzAktivNeu").toString(),
                                tagesDatenArray.getJSONObject(i).getJSONObject("attributes").get("Inz7T").toString(),
                                tagesDatenArray.getJSONObject(i).getJSONObject("attributes").get("ObjectId").toString()));
                    }
                }
            }

        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
        return tagesDatenList;
    }

    public List<Landkreis> getLandKreis() throws IOException {
        List<Landkreis> landkreisList = new ArrayList<>();
        try {
            URL url = new URL(
                    "https://services7.arcgis.com/mOBPykOjAyBO2ZKk/arcgis/rest/services/RKI_Landkreisdaten/FeatureServer/0/query?where=1%3D1&outFields=AdmUnitId,cases7_per_100k_txt,death7_lk,cases7_lk,death7_bl,cases7_bl,cases7_bl_per_100k,EWZ_BL,recovered,cases7_per_100k,last_update,county,BL_ID,BL,cases_per_population,cases_per_100k,deaths,cases,death_rate,EWZ,BEZ,GEN&returnGeometry=false&outSR=4326&f=json");
            JSONObject landkreisListJson = new JSONObject(IOUtils.toString(url, Charset.forName("UTF-8")));
            JSONArray landkreisJsonArray = landkreisListJson.names();
            for (Object obj : landkreisJsonArray) {
                if (obj.toString().equals("features")) {
                    JSONArray landkreisArray = landkreisListJson.getJSONArray("features");
                    for (int i = 0; i < landkreisArray.length(); i++) {

                        landkreisList.add(new Landkreis(
                                landkreisArray.getJSONObject(i).getJSONObject("attributes").get("AdmUnitId").toString(),
                                landkreisArray.getJSONObject(i).getJSONObject("attributes").get("cases7_per_100k_txt").toString(),
                                landkreisArray.getJSONObject(i).getJSONObject("attributes").get("death7_lk").toString(),
                                landkreisArray.getJSONObject(i).getJSONObject("attributes").get("cases7_lk").toString(),
                                landkreisArray.getJSONObject(i).getJSONObject("attributes").get("death7_bl").toString(),
                                landkreisArray.getJSONObject(i).getJSONObject("attributes").get("cases7_bl").toString(),
                                landkreisArray.getJSONObject(i).getJSONObject("attributes").get("cases7_bl_per_100k").toString(),
                                landkreisArray.getJSONObject(i).getJSONObject("attributes").get("EWZ_BL").toString(),
                                landkreisArray.getJSONObject(i).getJSONObject("attributes").get("recovered").toString(),
                                landkreisArray.getJSONObject(i).getJSONObject("attributes").get("cases7_per_100k").toString(),
                                landkreisArray.getJSONObject(i).getJSONObject("attributes").get("last_update").toString(),
                                landkreisArray.getJSONObject(i).getJSONObject("attributes").get("county").toString(),
                                landkreisArray.getJSONObject(i).getJSONObject("attributes").get("BL_ID").toString(),
                                landkreisArray.getJSONObject(i).getJSONObject("attributes").get("BL").toString(),
                                landkreisArray.getJSONObject(i).getJSONObject("attributes").get("cases_per_population").toString(),
                                landkreisArray.getJSONObject(i).getJSONObject("attributes").get("cases_per_100k").toString(),
                                landkreisArray.getJSONObject(i).getJSONObject("attributes").get("deaths").toString(),
                                landkreisArray.getJSONObject(i).getJSONObject("attributes").get("cases").toString(),
                                landkreisArray.getJSONObject(i).getJSONObject("attributes").get("death_rate").toString(),
                                landkreisArray.getJSONObject(i).getJSONObject("attributes").get("EWZ").toString(),
                                landkreisArray.getJSONObject(i).getJSONObject("attributes").get("BEZ").toString(),
                                landkreisArray.getJSONObject(i).getJSONObject("attributes").get("GEN").toString()));
                    }
                }
            }

        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
        return landkreisList;
    }

    public List<History> getHistory() {
        List<History> historyList = new ArrayList<>();
        try {
            URL url = new URL(
                    "https://services7.arcgis.com/mOBPykOjAyBO2ZKk/arcgis/rest/services/rki_history_hubv/FeatureServer/0/query?where=1%3D1&outFields=*&outSR=4326&f=json");
            JSONObject historyListJson = new JSONObject(IOUtils.toString(url, Charset.forName("UTF-8")));
            JSONArray historyJsonArray = historyListJson.names();
            for (Object obj : historyJsonArray) {
                if (obj.toString().equals("features")) {
                    JSONArray historyArray = historyListJson.getJSONArray("features");
                    for (int i = 0; i < historyArray.length(); i++) {

                        historyList.add(new History(
                                historyArray.getJSONObject(i).getJSONObject("attributes").get("AdmUnitId").toString(),
                                historyArray.getJSONObject(i).getJSONObject("attributes").get("BundeslandId").toString(),
                                historyArray.getJSONObject(i).getJSONObject("attributes").get("Datum").toString(),
                                historyArray.getJSONObject(i).getJSONObject("attributes").get("AnzFallNeu").toString(),
                                historyArray.getJSONObject(i).getJSONObject("attributes").get("AnzFallVortag").toString(),
                                historyArray.getJSONObject(i).getJSONObject("attributes").get("AnzFallErkrankung").toString(),
                                historyArray.getJSONObject(i).getJSONObject("attributes").get("AnzFallMeldung").toString(),
                                historyArray.getJSONObject(i).getJSONObject("attributes").get("KumFall").toString(),
                                historyArray.getJSONObject(i).getJSONObject("attributes").get("ObjectId").toString()));
                    }
                }
            }

        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
        return historyList;
    }

    public List<Altergruppe> getAltersgruppen() {
        List<Altergruppe> altergruppeList = new ArrayList<>();
        try {
            URL url = new URL(
                    "https://services7.arcgis.com/mOBPykOjAyBO2ZKk/arcgis/rest/services/rki_altersgruppen_hubv/FeatureServer/0/query?where=1%3D1&outFields=*&outSR=4326&f=json");
            JSONObject altersGruppeListJson = new JSONObject(IOUtils.toString(url, Charset.forName("UTF-8")));
            JSONArray altersGruppeJsonArray = altersGruppeListJson.names();
            for (Object obj : altersGruppeJsonArray) {
                if (obj.toString().equals("features")) {
                    JSONArray altersGruppeArray = altersGruppeListJson.getJSONArray("features");
                    for (int i = 0; i < altersGruppeArray.length(); i++) {
                        altergruppeList.add(new Altergruppe(
                                altersGruppeArray.getJSONObject(i).getJSONObject("attributes").get("AdmUnitId").toString(),
                                altersGruppeArray.getJSONObject(i).getJSONObject("attributes").get("BundeslandId").toString(),
                                altersGruppeArray.getJSONObject(i).getJSONObject("attributes").get("Altersgruppe").toString(),
                                altersGruppeArray.getJSONObject(i).getJSONObject("attributes").get("AnzFallM").toString(),
                                altersGruppeArray.getJSONObject(i).getJSONObject("attributes").get("AnzFallW").toString(),
                                altersGruppeArray.getJSONObject(i).getJSONObject("attributes").get("AnzTodesfallM").toString(),
                                altersGruppeArray.getJSONObject(i).getJSONObject("attributes").get("AnzTodesfallW").toString(),
                                altersGruppeArray.getJSONObject(i).getJSONObject("attributes").get("AnzFall100kM").toString(),
                                altersGruppeArray.getJSONObject(i).getJSONObject("attributes").get("AnzFall100kW").toString(),
                                altersGruppeArray.getJSONObject(i).getJSONObject("attributes").get("AnzTodesfall100kM").toString(),
                                altersGruppeArray.getJSONObject(i).getJSONObject("attributes").get("AnzTodesfall100kW").toString(),
                                altersGruppeArray.getJSONObject(i).getJSONObject("attributes").get("ObjectId").toString()));
                    }
                }
            }

        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
        return altergruppeList;
    }

    public List<Admunit> getRKIAdmunit() {
        List<Admunit> admunitList = new ArrayList<>();
        try {
            URL url = new URL(
                    "https://services7.arcgis.com/mOBPykOjAyBO2ZKk/arcgis/rest/services/rki_admunit_v/FeatureServer/0/query?where=1%3D1&outFields=*&outSR=4326&f=json");
            JSONObject admunitListJson = new JSONObject(IOUtils.toString(url, Charset.forName("UTF-8")));
            JSONArray admunitJsonArray = admunitListJson.names();
            for (Object obj : admunitJsonArray) {
                if (obj.toString().equals("features")) {
                    JSONArray admunitArray = admunitListJson.getJSONArray("features");
                    for (int i = 0; i < admunitArray.length(); i++) {
                        admunitList.add(new Admunit(
                                admunitArray.getJSONObject(i).getJSONObject("attributes").get("AdmUnitId").toString(),
                                admunitArray.getJSONObject(i).getJSONObject("attributes").get("Name").toString(),
                                admunitArray.getJSONObject(i).getJSONObject("attributes").get("ObjectId").toString()));
                    }
                }
            }

        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
        return admunitList;
    }

}
