package fh.dortmund.backend.covid.datenplatform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Trends {

    private String id;
    private String meldedatum;
    private String bundesland;
    private String ags;
    private String kreis;
    private String kr_inz_rate;
    private String kr_trend;
    private String kr_trend_kl;

}
