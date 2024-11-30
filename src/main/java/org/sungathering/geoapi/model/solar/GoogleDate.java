package org.sungathering.geoapi.model.solar;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GoogleDate {
    private int year;
    private int month;
    private int day;
}
