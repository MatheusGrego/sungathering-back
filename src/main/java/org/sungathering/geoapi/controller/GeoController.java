package org.sungathering.geoapi.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sungathering.geoapi.model.MarkersInputDTO;
import org.sungathering.geoapi.service.SolarService;
import org.sungathering.geoapi.model.BuildingDTO;  // Importe BuildingDTO

@RestController
@RequestMapping("/api/geo")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.POST)
public class GeoController {

    private final SolarService solarService;

    @PostMapping("/calculate-area")
    public ResponseEntity<BuildingDTO> calculateArea(@Valid @RequestBody MarkersInputDTO inputDTO) {
        // Obtém o BuildingDTO após buscar as informações do prédio mais próximo
        BuildingDTO buildingDTO = solarService.findClosestBuilding(inputDTO);

        // Retorna o BuildingDTO em formato JSON
        return ResponseEntity.ok(buildingDTO);
    }
}
