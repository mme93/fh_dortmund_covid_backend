package fh.dortmund.backend.RKI.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TagesDaten {
    private String AdmUnitId;
    private String BundeslandId;
    //Beschreibt die Gesamtzahl der COVID-19-Fälle je AdminUnit. Im RKI COVID-19-Dashboard bezieht sich diese Kenngröße auf den Indikator "COVID-19-Fälle Gesamt".
    private String AnzFall;
    //Beschreibt die Gesamtzahl der COVID-19-Todesfälle je AdminUnit. Im RKI COVID-19-Dashboard bezieht sich diese Kenngröße auf den Indikator "COVID-19-Todesfälle Gesamt".
    private String AnzTodesfall;
    //Beschreibt die neu gemeldeten COVID-19-Fälle im Vergleich zum Vortag je AdminUnit. Im RKI COVID-19-Dashboard bezieht sich diese Kenngröße auf den Indikator "COVID-19-Fälle".
    private String AnzFallNeu;
    //Beschreibt die neu gemeldeten COVID-19-Todesfälle im Vergleich zum Vortag je AdminUnit. Im RKI COVID-19-Dashboard bezieht sich diese Kenngröße auf den Indikator "COVID-19-Todesfälle".
    private String AnzTodesfallNeu;
    //Beschreibt die 7-Tage-Summe der COVID-19-Fälle je AdminUnit. Im RKI COVID-19-Dashboard bezieht sich diese Kenngröße auf den Indikator "7-Tage-Fallzahl".
    private String AnzFall7T;
    //Beschreibt die geschätzte Gesamtzahl der genesenen COVID-19-Fälle je Bundesland bzw. auf BRD-Sicht. Im RKI COVID-19-Bundesland-Dashboard bezieht sich diese Kenngröße auf den Indikator "COVID-19-Genesene Gesamt". Die Genesenen-Zahlen sind auf 100 Personen gerundete Schätzwerte, da dem RKI nicht die Genesung einer jeden zuvor infizierten Person übermittelt wird.
    private String AnzGenesen;
    // Beschreibt die geschätzten neuen genesenen COVID-19-Fälle im Vergleich zum Vortag je Bundesland bzw. auf BRD-Sicht. Im RKI COVID-19-Bundesland-Dashboard bezieht sich diese Kenngröße auf den Indikator "COVID-19-Genesene". Die Genesenen-Zahlen sind auf 100 Personen gerundete Schätzwerte, da dem RKI nicht die Genesung einer jeden zuvor infizierten Person übermittelt wird.*
    private String AnzGenesenNeu;
    //Beschreibt die geschätzte Gesamtzahl der aktiven COVID-19-Fälle je Bundesland bzw. auf BRD-Sicht. Im RKI COVID-19-Bundesland-Dashboard bezieht sich diese Kenngröße auf den Indikator "Aktive COVID-19-Fälle Gesamt". Die Aktiven-Zahlen sind auf 100 Personen gerundete Schätzwerte, da dem RKI nicht die Genesung einer jeden zuvor infizierten Person übermittelt wird.
    private String AnzAktiv;
    // Beschreibt die geschätzten neuen aktiven COVID-19-Fälle im Vergleich zum Vortag je Bundesland bzw. auf BRD-Sicht. Im RKI COVID-19-Bundesland-Dashboard bezieht sich diese Kenngröße auf den Indikator "Aktive COVID-19-Fälle". Die Aktiven-Zahlen sind auf 100 Personen gerundete Schätzwerte, da dem RKI nicht die Genesung einer jeden zuvor infizierten Person übermittelt wird
    private String AnzAktivNeu;
    //Beschreibt die 7-Tage-Inzidenz (7-Tage-Fallzahl pro 100.000 Einwohner) der COVID-19-Fälle je AdminUnit. Im RKI COVID-19-Dashboard bezieht sich diese Kenngröße auf den Indikator "7-Tage-Inzidenz
    private String Inz7T;
    private String ObjectId;
}
