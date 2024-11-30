package org.sungathering.geoapi.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MarkerDTO {
    @NotNull(message = "Latitude é obrigatória")
    private Double latitude;

    @NotNull(message = "Longitude é obrigatória")
    private Double longitude;

}
