package fh.dortmund.backend.covid.controller;

import fh.dortmund.backend.covid.model.Trends;
import fh.dortmund.backend.covid.service.CoronaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/corona")
public class CoronaController {

    private final CoronaService coronaService;

    @Autowired
    public CoronaController(CoronaService coronaService) {
        this.coronaService = coronaService;
    }

    //https://www.corona-datenplattform.de/dataset/impfdaten
    @GetMapping("/impfdaten")
    public ResponseEntity<List<?>> getImpfdaten() {
        try {
            return new ResponseEntity<>(this.coronaService.getImpfdaten(5), HttpStatus.OK);
        } catch (URISyntaxException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //https://www.corona-datenplattform.de/dataset/genesene
    @GetMapping("/genesene")
    public ResponseEntity<List<?>> getGenesene() {
        try {
            return new ResponseEntity<>(this.coronaService.getGenesene(5), HttpStatus.OK);
        } catch (URISyntaxException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //https://www.corona-datenplattform.de/dataset/hospitalisierung
    @GetMapping("/hospitalisierung")
    public ResponseEntity<List<?>> getHospitalisierung() {
        try {
            return new ResponseEntity<>(this.coronaService.getHospitalisierung(5), HttpStatus.OK);
        } catch (URISyntaxException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //https://www.corona-datenplattform.de/dataset/impfdaten_regional
    @GetMapping("/impfdatenRegional")
    public ResponseEntity<List<?>> getImpfdatenRegional() {
        try {
            return new ResponseEntity<>(this.coronaService.getImpfdatenRegional(5), HttpStatus.OK);
        } catch (URISyntaxException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //https://www.corona-datenplattform.de/dataset/infektionen_kreise
    @GetMapping("/infektionenKreise")
    public ResponseEntity<List<?>> getInfektionenKreis() {
        try {
            return new ResponseEntity<>(this.coronaService.getInfektionenKreis(5), HttpStatus.OK);
        } catch (URISyntaxException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //https://www.corona-datenplattform.de/dataset/infektionen_bundeslaender
    @GetMapping("/infektionenBundeslaender")
    public ResponseEntity<List<?>> getInfektionenBundeslaender() {
        try {
            return new ResponseEntity<>(this.coronaService.getInfektionenBundeslaender(5), HttpStatus.OK);
        } catch (URISyntaxException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //https://www.corona-datenplattform.de/dataset/intensivstationen
    @GetMapping("/intensivstationen")
    public ResponseEntity<List<?>> getIntensivstationen() {
        try {
            return new ResponseEntity<>(this.coronaService.getIntensivstationen(5), HttpStatus.OK);
        } catch (URISyntaxException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //https://www.corona-datenplattform.de/dataset/todesfaelle
    @GetMapping("/todesfaelle")
    public ResponseEntity<List<?>> getTodesfaelle() {
        try {
            return new ResponseEntity<>(this.coronaService.getTodesfaelle(5), HttpStatus.OK);
        } catch (URISyntaxException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //https://www.corona-datenplattform.de/dataset/trends
    @GetMapping("/trends")
    public ResponseEntity<List<Trends>> getTrends(){
        try {
            return new ResponseEntity<>(this.coronaService.getTrends(5), HttpStatus.OK);
        } catch (URISyntaxException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
