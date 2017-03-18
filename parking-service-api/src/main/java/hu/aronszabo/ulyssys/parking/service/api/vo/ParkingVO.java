package hu.aronszabo.ulyssys.parking.service.api.vo;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingVO {

    private Long id;
    private Long parkingPlaceId;
    private String licensePlateNumber;
    private LocalDateTime beginOfParking;
    private LocalDateTime endOfParking;
}
