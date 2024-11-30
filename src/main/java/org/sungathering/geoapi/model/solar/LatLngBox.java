package org.sungathering.geoapi.model.solar;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LatLngBox {
    private LatLng ne;  // Canto nordeste
    private LatLng sw;
}
