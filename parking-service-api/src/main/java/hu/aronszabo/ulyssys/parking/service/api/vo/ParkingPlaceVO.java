package hu.aronszabo.ulyssys.parking.service.api.vo;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ParkingPlaceVO {

    private Long id;
    private String name;
    private List<CarVO> cars;
}
