package org.sungathering.geoapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SolarPotentialDTO {
    private Integer maxArrayPanelsCount;
    private Double panelCapacityWatts;
    private Integer panelLifetimeYears;
    private Double maxArrayAreaMeters2;
    private Double maxSunshineHoursPerYear;
    private Double carbonOffsetFactorKgPerMwh;
    private SizeAndSunshineStatsDTO wholeRoofStats;

    // Getters e setters...
}