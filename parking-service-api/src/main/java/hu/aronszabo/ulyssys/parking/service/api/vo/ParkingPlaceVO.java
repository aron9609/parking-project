package hu.aronszabo.ulyssys.parking.service.api.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingPlaceVO {

    private Long id;
    private Boolean isFree;
}
