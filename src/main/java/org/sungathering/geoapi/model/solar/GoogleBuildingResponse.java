package org.sungathering.geoapi.model.solar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sungathering.geoapi.feign.RequiredQuality;

import java.util.Date;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleBuildingResponse {
    private String name;
    private LatLng center;
    private LatLngBox boundingBox;
    private GoogleDate imageryDate;
    private GoogleDate imageryProcessedDate;
    private String postalCode;
    private String administrativeArea;
    private String statisticalArea;
    private String regionCode;
    private SolarPotential solarPotential;
    private RequiredQuality imageryQuality;
}
