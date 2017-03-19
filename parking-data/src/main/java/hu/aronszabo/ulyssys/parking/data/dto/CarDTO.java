package hu.aronszabo.ulyssys.parking.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CarDTO {

    private String licensePlateNumber;
    private String brand;
    private String type;
    private String color;
}
