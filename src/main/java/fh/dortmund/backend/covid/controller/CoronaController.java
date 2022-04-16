package fh.dortmund.backend.covid.controller;

import fh.dortmund.backend.covid.service.CoronaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/corona")
public class CoronaController {

    private final CoronaService coronaService;

    @Autowired
    public CoronaController(CoronaService coronaService) {
        this.coronaService = coronaService;
    }
}
