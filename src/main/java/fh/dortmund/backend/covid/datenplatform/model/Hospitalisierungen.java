package fh.dortmund.backend.covid.datenplatform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hospitalisierungen {
    private String datum;
    private String bundesland;
    private String bundesland_Id;
    private String altersgruppe;
    private String siebenTage_Hospitalisierung_Faelle;
    private String siebenTage_Hospitalisierung_Inzidenz;
}
