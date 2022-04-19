package fh.dortmund.backend.covid.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImpfdatenRegional {
    private String id;
    private String datum;
    private String bundesland;
    private String kreis;
    private String kr_zweitimpf;
    private String kr_drittimpf_18u60;
    private String kr_drittimpf_12u18;
    private String kr_zweitimpf_ab60;
    private String kr_erstimpf_12u18;
    private String kr_zweitimpf_12u18;
    private String kr_drittimpf;
    private String kr_erstimpf_ab60;
    private String kr_zweitimpf_18u60;
    private String kr_erstimpf_18u60;
    private String kr_erstimpf;
    private String kr_drittimpf_ab60;
}
