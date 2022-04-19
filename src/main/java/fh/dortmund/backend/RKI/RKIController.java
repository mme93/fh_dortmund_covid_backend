package fh.dortmund.backend.RKI;

import fh.dortmund.backend.RKI.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/RKI")
public class RKIController {

    private final RKIService rkiService;

    @Autowired
    public RKIController(RKIService rkiService) {
        this.rkiService = rkiService;
    }

    @GetMapping("/tagesDaten")
    public List<TagesDaten> getTagesDaten() throws IOException {
        return rkiService.getTagesDaten();
    }
    @GetMapping("/landkreis")
    public List<Landkreis> getLandkreis() throws IOException {
        return rkiService.getLandKreis();
    }
    @GetMapping("/history")
    public List<History> getHistory() throws IOException {
        return rkiService.getHistory();
    }
    @GetMapping("/altersgruppe")
    public List<Altergruppe> getAltersgruppe() throws IOException {
        return rkiService.getAltersgruppen();
    }
    @GetMapping("/admunit")
    public List<Admunit> getAdmunit() throws IOException {
        return rkiService.getRKIAdmunit();
    }

}
