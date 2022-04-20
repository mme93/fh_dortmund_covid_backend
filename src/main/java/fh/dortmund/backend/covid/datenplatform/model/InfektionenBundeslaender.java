package fh.dortmund.backend.covid.datenplatform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InfektionenBundeslaender {
    private String bundesland;
    private String bundeslandID;
    private String merkmale;
    private List<DateValue> dateValueList;
}
