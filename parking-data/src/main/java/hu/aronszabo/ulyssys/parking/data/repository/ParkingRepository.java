package hu.aronszabo.ulyssys.parking.data.repository;

import hu.aronszabo.ulyssys.parking.data.dto.ParkingDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import lombok.NoArgsConstructor;

/**
 * This class mock the the database connection to the Parking table
 */
@NoArgsConstructor
public class ParkingRepository {

    private static final List<ParkingDTO> DATA;

    //CHECKSTYLE:OFF
    static {
        DATA = new LinkedList<>();
        DATA.add(new ParkingDTO(1L, 2L, "KVE-229", new Date(117, 1, 3, 12, 19, 0), new Date(117, 1, 3, 13, 31, 0)));
        DATA.add(new ParkingDTO(2L, 1L, "KVE-231", new Date(117, 1, 3, 14, 28, 0), new Date(117, 1, 3, 19, 15, 0)));
        DATA.add(new ParkingDTO(3L, 3L, "KVE-228", new Date(117, 1, 3, 9, 1, 0), new Date(117, 1, 3, 11, 55, 0)));
    }

    /**
     * This method serch a parking record by license plate number in the mocked
     * Parking table
     *
     * @param licensePlateNumber the specified license plate number
     * @return the parging record with the specified license plate number
     */
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

    /**
     * This method serch a parking record by parking place in the mocked Parking
     * table
     *
     * @param parkingPlaceId the specified parking placeId
     * @return the parging record with the parking place id
     */
    public List<ParkingDTO> getByParkingPlaceId(final Long parkingPlaceId) {
        List<ParkingDTO> result = new ArrayList<>();
        for (ParkingDTO tmp : DATA) {
            if (tmp.getParkingPlaceId().equals(parkingPlaceId)) {
                result.add(tmp);
            }
        }
        return result;
    }

    /**
     * This method is able to save a new Parking record to the mocked database
     *
     * @param parkingDTO the new record to save
     * @return the id of the new record
     */
    public Long save(final ParkingDTO parkingDTO) {
        parkingDTO.setId(new Long(DATA.size()));
        DATA.add(parkingDTO);
        return parkingDTO.getId();
    }

    /**
     * This method is able to remove a record from the mocked database
     *
     * @param id the id of the record to remove
     */
    public void remove(final Long id) {
        for (ParkingDTO tmp : DATA) {
            if (tmp.getId().equals(id)) {
                DATA.remove(tmp);
                break;
            }
        }
    }

}
