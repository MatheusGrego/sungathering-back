package org.sungathering.geoapi.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sungathering.geoapi.model.MarkersInputDTO;
import org.sungathering.geoapi.service.GeoService;

@RestController
@RequestMapping("/api/geo")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET}, allowedHeaders = "*")
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