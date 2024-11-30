package org.sungathering.geoapi.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.sungathering.geoapi.model.solar.GoogleBuildingResponse;

@FeignClient(name = "solarGoogleApiClient", url = "https://solar.googleapis.com/v1")
public interface SolarGoogleApiClient {

    @GetMapping("/buildingInsights:findClosest")
    GoogleBuildingResponse findClosest(
            @RequestParam("location.latitude") Double latitude,
            @RequestParam("location.longitude") Double longitude,
            @RequestParam("requiredQuality") RequiredQuality requiredQuality,
            @RequestParam("key") String apiKey
    );
}
