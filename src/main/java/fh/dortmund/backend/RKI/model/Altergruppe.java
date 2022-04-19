package fh.dortmund.backend.RKI.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Altergruppe {
    // Info Link https://npgeo-corona-npgeo-de.hub.arcgis.com/datasets/23b1ccb051f543a5b526021275c1c6e5_0/about
    private String admUnitId;
    private String bundeslandId;
    private String altersgruppe;
    private String anzFallM;
    private String anzFallW;
    private String anzTodesfallM;
    private String anzTodesfallW;
    private String anzFall100kM;
    private String anzFall100kW;
    private String anzTodesfall100kM;
    private String anzTodesfall100kW;
    private String objectId;
}
