package org.sungathering.geoapi.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CentroidDTO {

    @NotNull(message = "Latitude do centroide é obrigatória.")
    private Double latitude;

    @NotNull(message = "Longitude do centroide é obrigatória.")
    private Double longitude;

}
