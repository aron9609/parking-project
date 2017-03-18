package hu.aronszabo.ulyssys.parking.service.api.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CarVO {

    private String licensePlateNumber;
    private String brand;
    private String type;
    private String color;
}
