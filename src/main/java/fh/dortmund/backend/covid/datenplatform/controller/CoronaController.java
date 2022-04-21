package fh.dortmund.backend.covid.datenplatform.controller;

import fh.dortmund.backend.covid.datenplatform.model.*;
import fh.dortmund.backend.covid.datenplatform.service.CoronaDatenplatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/datenplatform")
public class CoronaController {

    private final CoronaDatenplatformService coronaDatenplatformService;

    @Autowired
    public CoronaController(CoronaDatenplatformService coronaDatenplatformService) {
        this.coronaDatenplatformService = coronaDatenplatformService;
    }

    //https://www.corona-datenplattform.de/dataset/impfdaten
    @GetMapping("/impfdaten")
    public ResponseEntity<List<Impfdaten>> getImpfdaten() {
        try {
            return new ResponseEntity<>(this.coronaDatenplatformService.getImpfdaten(5), HttpStatus.OK);
        } catch (URISyntaxException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //https://www.corona-datenplattform.de/dataset/genesene
    @GetMapping("/genesene")
    public ResponseEntity<List<Genesene>> getGenesene() {
        try {
            return new ResponseEntity<>(this.coronaDatenplatformService.getGenesene(5), HttpStatus.OK);
        } catch (URISyntaxException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //TODO: https://raw.githubusercontent.com/robert-koch-institut/COVID-19-Hospitalisierungen_in_Deutschland/master/Aktuell_Deutschland_COVID-19-Hospitalisierungen.csv
    //https://www.corona-datenplattform.de/dataset/hospitalisierung
    @GetMapping("/hospitalisierung")
    public ResponseEntity<List<?>> getHospitalisierung() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    //https://www.corona-datenplattform.de/dataset/impfdaten_regional
    @GetMapping("/impfdatenRegional")
    public ResponseEntity<List<ImpfdatenRegional>> getImpfdatenRegional() {
        try {
            return new ResponseEntity<>(this.coronaDatenplatformService.getImpfdatenRegional(5), HttpStatus.OK);
        } catch (URISyntaxException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //https://www.corona-datenplattform.de/dataset/infektionen_kreise
    @GetMapping("/infektionenKreise")
    public ResponseEntity<List<InfektionenKreise>> getInfektionenKreis() {
        try {
            return new ResponseEntity<>(this.coronaDatenplatformService.getInfektionenKreis(5), HttpStatus.OK);
        } catch (URISyntaxException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //https://www.corona-datenplattform.de/dataset/infektionen_bundeslaender
    @GetMapping("/infektionenBundeslaender")
    public ResponseEntity<List<InfektionenBundeslaender>> getInfektionenBundeslaender() {
        try {
            return new ResponseEntity<>(this.coronaDatenplatformService.getInfektionenBundeslaender(5), HttpStatus.OK);
        } catch (URISyntaxException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //https://www.corona-datenplattform.de/dataset/intensivstationen
    @GetMapping("/intensivstationen")
    public ResponseEntity<List<Intensivstationen>> getIntensivstationen() {
        try {
            return new ResponseEntity<>(this.coronaDatenplatformService.getIntensivstationen(5), HttpStatus.OK);
        } catch (URISyntaxException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //https://www.corona-datenplattform.de/dataset/todesfaelle
    @GetMapping("/todesfaelle")
    public ResponseEntity<List<Todesfaelle>> getTodesfaelle() {
        try {
            return new ResponseEntity<>(this.coronaDatenplatformService.getTodesfaelle(5), HttpStatus.OK);
        } catch (URISyntaxException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //https://www.corona-datenplattform.de/dataset/trends
    @GetMapping("/trends")
    public ResponseEntity<List<Trends>> getTrends(){
        try {
            return new ResponseEntity<>(this.coronaDatenplatformService.getTrends(5), HttpStatus.OK);
        } catch (URISyntaxException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
