package hu.aronszabo.ulyssys.parking.data.repository;

import hu.aronszabo.ulyssys.parking.data.dto.ParkingPlaceDTO;
import java.util.LinkedList;
import java.util.List;
import lombok.NoArgsConstructor;

/**
 * This class mock the the database connection to the ParkingPlace table
 */
@NoArgsConstructor
public class ParkingPlaceRepository {

    private static final List<ParkingPlaceDTO> DATA;

    //CHECKSTYLE:OFF
    static {
        DATA = new LinkedList<>();
        DATA.add(new ParkingPlaceDTO(1L, "Parking Place 1"));
        DATA.add(new ParkingPlaceDTO(2L, "Parking Place 2"));
        DATA.add(new ParkingPlaceDTO(3L, "Parking Place 3"));
    }

    public List<ParkingPlaceDTO> getAll() {
        return DATA;
    }

    /**
     * This method can search a parking place by id.
     *
     * @param id The id of the parking place.
     */
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
}
