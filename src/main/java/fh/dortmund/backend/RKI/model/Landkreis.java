package fh.dortmund.backend.RKI.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Landkreis {
    private String AdmUnitId;
    //Fälle der letzten 7 Tage/100000 EW (Text)
    private String cases7_per_100k_txt;
    //Todesfälle der letzten 7 Tage pro Landkreis
    private String death7_lk;
    //Fälle der letzten 7 Tage pro Landkreis
    private String cases7_lk;
    //Todesfälle der letzten 7 Tage pro Bundesland
    private String death7_bl;
    //Fälle der letzten 7 Tage pro Bundesland
    private String cases7_bl;
    //Bundeslandweite Fälle de…tzten 7 Tage/100.000 EW
    private String cases7_bl_per_100k;
    //Einwohnerzahl Bundesland
    private String EWZ_BL;
    //Genesene
    private String recovered;
    //Fälle letzte 7 Tage/100.000 EW
    private String cases7_per_100k;
    //Letzte Aktualisierung
    private String last_update;
    //Landkreis
    private String county;
    //Bundesland ID
    private String BL_ID;
    //Bundesland
    private String BL;
    //Betroffenenrate %
    private String cases_per_population;
    //Fälle/100.000 EW
    private String cases_per_100k;
    //Todesfälle
    private String deaths;
    //Fälle
    private String cases;
    //Sterberate
    private String death_rate;
    //Einwohnerzahl
    private String EWZ;
    //Bezeichnung %
    private String BEZ;
    //Stadt-Name
    private String GEN;

}
