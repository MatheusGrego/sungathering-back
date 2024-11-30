package org.sungathering.geoapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.sungathering.geoapi.feign.RequiredQuality;
import org.sungathering.geoapi.feign.SolarGoogleApiClient;
import org.sungathering.geoapi.model.BuildingDTO;
import org.sungathering.geoapi.model.MarkersInputDTO;
import org.sungathering.geoapi.model.solar.GoogleBuildingResponse;
import org.sungathering.geoapi.util.mapper.BuildingMapper;

@Service
public class SolarService {

    private static final Logger logger = LoggerFactory.getLogger(SolarService.class);

    private final SolarGoogleApiClient solarApiClient;

    @Value("${google.api.key}")
    private String apiKey;

    public SolarService(SolarGoogleApiClient solarApiClient) {
        this.solarApiClient = solarApiClient;
    }

    public BuildingDTO findClosestBuilding(MarkersInputDTO inputDTO) {
        Double latitude = inputDTO.getCentroid().getLatitude();
        Double longitude = inputDTO.getCentroid().getLongitude();

        try {
            // Chama a API do Google para buscar a resposta do prédio
            GoogleBuildingResponse response = solarApiClient.findClosest(
                    latitude,
                    longitude,
                    RequiredQuality.LOW,
                    apiKey
            );

            // Log da resposta para depuração
            logger.info("Resposta da API do Google: {}", response);

            // Mapeia a resposta para um BuildingDTO
            BuildingDTO buildingDTO = BuildingMapper.toDTO(response);

            return buildingDTO;
        } catch (Exception e) {
            // Log do erro
            logger.error("Erro ao chamar a API do Google: {}", e.getMessage(), e);
            throw new RuntimeException("Erro ao buscar o prédio mais próximo", e);
        }
    }
}
