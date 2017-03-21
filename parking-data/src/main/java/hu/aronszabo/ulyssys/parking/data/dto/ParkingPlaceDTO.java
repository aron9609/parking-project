package hu.aronszabo.ulyssys.parking.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class implement the records of the ParkingPlace mocked database table
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingPlaceDTO {

    private Long id;
    private String name;
}
