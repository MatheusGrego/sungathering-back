package org.sungathering.geoapi.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sungathering.geoapi.model.MarkersInputDTO;
import org.sungathering.geoapi.service.GeoService;

@RestController
@RequestMapping("/api/geo")
public class GeoController {

    private final GeoService geoService;

    public GeoController(GeoService geoService) {
        this.geoService = geoService;
    }

    @PostMapping("/calculate-area")
    public ResponseEntity<String> calculateArea(@RequestBody @Valid MarkersInputDTO input) {
        String result = geoService.processMarkers(input.getMarkers());
        return ResponseEntity.ok(result);
    }
}