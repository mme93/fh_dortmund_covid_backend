package fh.dortmund.backend.covid.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MassnahmenIndexMonat {

    private String id;
    private String bundeslandNr;
    private String bundesland;
    private String ags;
    private String kreis;
    private String datum;
    private String index;

}
