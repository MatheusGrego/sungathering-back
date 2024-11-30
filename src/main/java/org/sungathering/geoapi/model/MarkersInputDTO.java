package org.sungathering.geoapi.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Map;

@Data
public class MarkersInputDTO {

    @Size(min = 3, max = 4, message = "O número de marcadores deve ser entre 3 e 4.")
    private Map<String, MarkerDTO> markers;

    @NotNull(message = "O centroide é obrigatório.")
    private CentroidDTO centroid;

    @NotNull(message = "O sistema de referência é obrigatório.")
    private String referenceSystem;

    @NotNull(message = "A zona UTM é obrigatória.")
    private String utmZone;  // Novo campo UTM Zone
}

