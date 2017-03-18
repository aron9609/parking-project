package hu.aronszabo.ulyssys.parking.data.repository;

import hu.aronszabo.ulyssys.parking.data.dto.ParkingDTO;
import java.util.LinkedList;
import java.util.List;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ParkingRepository {

    private static final List<ParkingDTO> DATA;

    static {
        DATA = new LinkedList<>();
    }

    public ParkingDTO getByLicensePlateNumber(final String licensePlateNumber) {
        ParkingDTO result = null;
        for (ParkingDTO tmp : DATA) {
            if (tmp.getLicensePlateNumber().equals(licensePlateNumber)) {
                result = tmp;
                break;
            }
        }
        return result;
    }

    public ParkingDTO getById(final Long id) {
        ParkingDTO result = null;
        for (ParkingDTO tmp : DATA) {
            if (tmp.getId().equals(id)) {
                result = tmp;
                break;
            }
        }
        return result;
    }

    public ParkingDTO getByParkingPlaceId(final Long parkingPlaceId) {
        ParkingDTO result = null;
        for (ParkingDTO tmp : DATA) {
            if (tmp.getParkingPlaceId().equals(parkingPlaceId)) {
                result = tmp;
                break;
            }
        }
        return result;
    }

    public void save(final ParkingDTO parkingDTO) {
        DATA.add(parkingDTO);
    }

    public void remove(final Long id) {
        for (ParkingDTO tmp : DATA) {
            if (tmp.getId().equals(id)) {
                DATA.remove(tmp);
                break;
            }
        }
    }

}
