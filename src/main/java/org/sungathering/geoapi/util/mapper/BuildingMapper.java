package org.sungathering.geoapi.util.mapper;

import org.springframework.beans.BeanUtils;
import org.sungathering.geoapi.model.BuildingDTO;
import org.sungathering.geoapi.model.SizeAndSunshineStatsDTO;
import org.sungathering.geoapi.model.SolarPotentialDTO;
import org.sungathering.geoapi.model.solar.GoogleBuildingResponse;
import org.sungathering.geoapi.model.solar.LatLng;
import org.sungathering.geoapi.model.solar.LatLngBox;

public class BuildingMapper {

    public static BuildingDTO toDTO(GoogleBuildingResponse response) {
        BuildingDTO dto = new BuildingDTO();
        BeanUtils.copyProperties(response, dto);

        // Mapear SolarPotential separadamente
        if (response.getSolarPotential() != null) {
            SolarPotentialDTO solarDTO = new SolarPotentialDTO();
            BeanUtils.copyProperties(response.getSolarPotential(), solarDTO);

            // Mapear SizeAndSunshineStats separadamente
            if (response.getSolarPotential().getWholeRoofStats() != null) {
                SizeAndSunshineStatsDTO statsDTO = new SizeAndSunshineStatsDTO();
                BeanUtils.copyProperties(response.getSolarPotential().getWholeRoofStats(), statsDTO);
                solarDTO.setWholeRoofStats(statsDTO);
            }

            dto.setSolarPotential(solarDTO);
        }

        // Mapear LatLngBox (Bounding Box)
        if (response.getBoundingBox() != null) {
            LatLng northEast = new LatLng(response.getBoundingBox().getNe().getLatitude(), response.getBoundingBox().getNe().getLongitude());
            LatLng southWest = new LatLng(response.getBoundingBox().getSw().getLatitude(), response.getBoundingBox().getSw().getLongitude());
            LatLngBox boundingBox = new LatLngBox(northEast, southWest);
            dto.setBoundingBox(boundingBox);
        }

        // Mapear o centro do prédio (LatLng)
        if (response.getCenter() != null) {
            LatLng center = new LatLng(response.getCenter().getLatitude(), response.getCenter().getLongitude());
            dto.setCenter(center);
        }

        return dto;
    }
}
