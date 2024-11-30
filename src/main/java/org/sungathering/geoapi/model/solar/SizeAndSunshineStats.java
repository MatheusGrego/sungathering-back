package org.sungathering.geoapi.model.solar;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SizeAndSunshineStats {
    private Double areaMeters2;
    private List<Double> sunshineQuantiles;
    private Double groundAreaMeters2;

}