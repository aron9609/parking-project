package hu.aronszabo.ulyssys.parking.data.repository;

import hu.aronszabo.ulyssys.parking.data.dto.ParkingPlaceDTO;
import java.util.LinkedList;
import java.util.List;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ParkingPlaceRepository {

    private static final List<ParkingPlaceDTO> DATA;

    static {
        DATA = new LinkedList<>();
        DATA.add(new ParkingPlaceDTO(1L, "Parking Place 1"));
        DATA.add(new ParkingPlaceDTO(2L, "Parking Place 3"));
        DATA.add(new ParkingPlaceDTO(3L, "Parking Place 3"));
    }

    public ParkingPlaceDTO getById(final Long id) {
        ParkingPlaceDTO result = null;
        for (ParkingPlaceDTO tmp : DATA) {
            if (tmp.getId().equals(id)) {
                result = tmp;
                break;
            }
        }
        return result;
    }

    public void save(final ParkingPlaceDTO parkingPlaceDTO) {
        DATA.add(parkingPlaceDTO);
    }

    public void remove(final Long id) {
        for (ParkingPlaceDTO tmp : DATA) {
            if (tmp.getId().equals(id)) {
                DATA.remove(tmp);
                break;
            }
        }
    }
}
