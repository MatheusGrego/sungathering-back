package org.sungathering.geoapi.service;

import org.geotools.geometry.jts.JTSFactoryFinder;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Polygon;
import org.springframework.stereotype.Service;
import org.sungathering.geoapi.model.MarkerDTO;

import java.util.Map;

@Service
public class GeoService {
    public String processMarkers(Map<String, MarkerDTO> markers) {
        GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory();

        Coordinate[] coordinates = markers.values().stream()
                .map(marker -> new Coordinate(marker.getLongitude(), marker.getLatitude()))
                .toArray(Coordinate[]::new);

        Coordinate[] closedCoordinates = new Coordinate[coordinates.length + 1];
        System.arraycopy(coordinates, 0, closedCoordinates, 0, coordinates.length);
        closedCoordinates[coordinates.length] = coordinates[0];

        // Criar o polígono
        Polygon polygon = geometryFactory.createPolygon(closedCoordinates);

        // Calcular a área
        double area = polygon.getArea();

        // Retornar informações (área e localização aproximada)
        return String.format("Área: %.2f graus². Região aproximada: %s", area, getRegion(polygon));
    }

    private String getRegion(Polygon polygon) {
        // Exemplo: lógica para determinar a região (simulada aqui)
        return "Região calculada (adapte com geocodificação reversa)";
    }
}
