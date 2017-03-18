package hu.aronszabo.ulyssys.parking.data.dto;

import java.time.LocalDateTime;
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
    private LocalDateTime beginOfParking;
    private LocalDateTime endOfParking;
}
