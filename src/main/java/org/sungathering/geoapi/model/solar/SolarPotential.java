package org.sungathering.geoapi.model.solar;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SolarPotential {
    private Integer maxArrayPanelsCount;
    private Double panelCapacityWatts;
    private Double panelHeightMeters;
    private Double panelWidthMeters;
    private Integer panelLifetimeYears;
    private Double maxArrayAreaMeters2;
    private Double maxSunshineHoursPerYear;
    private Double carbonOffsetFactorKgPerMwh;
    private SizeAndSunshineStats wholeRoofStats;

}