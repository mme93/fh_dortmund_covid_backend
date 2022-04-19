package fh.dortmund.backend.covid.controller;

import fh.dortmund.backend.covid.model.MassnahmenIndexMonat;
import fh.dortmund.backend.covid.service.CoronaDatenplatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.net.URISyntaxException;
import java.util.List;

@RestController
public class MassnahmenController {

    private final CoronaDatenplatformService coronaDatenplatformService;

    @Autowired
    public MassnahmenController(CoronaDatenplatformService coronaDatenplatformService) {
        this.coronaDatenplatformService = coronaDatenplatformService;
    }

    //https://www.corona-datenplattform.de/dataset/massnahmenindex_kreise_pro_monat
    @GetMapping("/massnahmenIndexMonat")
    public ResponseEntity<List<MassnahmenIndexMonat>> getMassnahmenIndexMonat() {
        try {
            return new ResponseEntity<List<MassnahmenIndexMonat>>(coronaDatenplatformService.getMassnahmenIndexMonat(), HttpStatus.OK);
        } catch (URISyntaxException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
