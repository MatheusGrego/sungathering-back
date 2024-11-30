package org.sungathering.geoapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sungathering.geoapi.model.solar.LatLng;
import org.sungathering.geoapi.model.solar.LatLngBox;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuildingDTO {
    private String name;
    private LatLng center;
    private LatLngBox boundingBox;
    private SolarPotentialDTO solarPotential;
}
