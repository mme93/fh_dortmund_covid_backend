package fh.dortmund.backend.RKI.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class History {
    private String admUnitId;
    private String bundeslandId;
    private String datum;
    private String anzFallNeu;
    private String anzFallVortag;
    private String anzFallErkrankung;
    private String anzFallMeldung;
    private String kumFall;
    private String objectId;
}
