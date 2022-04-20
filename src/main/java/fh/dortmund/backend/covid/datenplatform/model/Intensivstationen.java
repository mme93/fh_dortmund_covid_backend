package fh.dortmund.backend.covid.datenplatform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Intensivstationen {
    private String id;
    private String datum;
    private String kreis;
    private String bundesland;
    private String kr_its_bett_f_18;
    private String kr_its_bett_b;
    private String kr_its_inf_b;
    private String kr_its_meldeb;
    private String kr_its_inf_b_ant;
    private String kr_its_bett_f;
    private String kr_its_inf;
    private String kr_its_bett_ew;
    private String kr_its_bett;
    private String kr_its_kh;
    private String kr_its_bett_b_18;

}
