package hu.aronszabo.ulyssys.parking.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {

    private String licensePlateNumber;
    private String brand;
    private String type;
    private String color;
}
