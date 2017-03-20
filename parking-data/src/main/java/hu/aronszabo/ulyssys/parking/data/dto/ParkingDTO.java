package hu.aronszabo.ulyssys.parking.data.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingDTO {

    private Long id;
    private Long parkingPlaceId;
    private String licensePlateNumber;
    private Date beginOfParking;
    private Date endOfParking;
}
