package hu.aronszabo.ulyssys.parking.data.repository;

import hu.aronszabo.ulyssys.parking.data.dto.ParkingDTO;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ParkingRepository {

    private static final List<ParkingDTO> DATA;

    static {
        DATA = new LinkedList<>();
        DATA.add(new ParkingDTO(1L, 2L, "KVE-229", new Date(117, 1, 3, 12, 19, 0), new Date(117, 1, 3, 13, 31, 0)));
        DATA.add(new ParkingDTO(2L, 1L, "KVE-231", new Date(117, 1, 3, 14, 28, 0), new Date(117, 1, 3, 19, 15, 0)));
        DATA.add(new ParkingDTO(3L, 3L, "KVE-228", new Date(117, 1, 3, 9, 1, 0), new Date(117, 1, 3, 11, 55, 0)));
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
