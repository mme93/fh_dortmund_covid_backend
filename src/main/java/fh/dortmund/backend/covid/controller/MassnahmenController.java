package fh.dortmund.backend.covid.controller;

import fh.dortmund.backend.covid.model.MassnahmenIndexMonat;
import fh.dortmund.backend.covid.service.CoronaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.net.URISyntaxException;
import java.util.List;

@RestController
public class MassnahmenController {

    private final CoronaService coronaService;

    @Autowired
    public MassnahmenController(CoronaService coronaService) {
        this.coronaService = coronaService;
    }

    @GetMapping("/massnahmenIndexMonat")
    public List<MassnahmenIndexMonat> getMassnahmenIndexMonat() throws URISyntaxException {
        return coronaService.getMassnahmenIndexMonat();
    }

}
