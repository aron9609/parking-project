package hu.aronszabo.ulyssys.parking.service.api.vo;

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ParkingVO {

    private Long id;
    private Long parkingPlaceId;
    private String licensePlateNumber;
    private Date beginOfParking;
    private Date endOfParking;
}
