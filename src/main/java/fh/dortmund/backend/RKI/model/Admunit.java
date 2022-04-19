package fh.dortmund.backend.RKI.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Admunit {
    //beschreibt eine eindeutige ID eines jeden Landkreises, Bundeslandes und der BRD
    private String admUnitId;
    //Name des Bundeslandes/Landkreises
    private String name;
    private String ObjectId;
}
