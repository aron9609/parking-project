package hu.aronszabo.ulyssys.parking.service.api.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarVO {

    private String licensePlateNumber;
    private String brand;
    private String type;
    private String color;
}
