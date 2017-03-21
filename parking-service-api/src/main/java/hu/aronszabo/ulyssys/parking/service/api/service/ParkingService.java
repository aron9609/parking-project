package hu.aronszabo.ulyssys.parking.service.api.service;

import hu.aronszabo.ulyssys.parking.service.api.vo.ParkingVO;
import java.util.List;

/**
 * Defines the business logic of the service which can handle parkings.
 */
public interface ParkingService {

    /**
     * This method can get a parking specified by license plate number from the
     * data layar.
     *
     * @param licensePlateNumber The specified license plate number of the
     * parking.
     * @return the specified parking
     */
    ParkingVO getByLicensePlateNumber(String licensePlateNumber);

    /**
     * This method can get parkings specified by parking place id from the data
     * layar.
     *
     * @param parkingPlaceId The parking place id of the parkings to return.
     * @return the specified parkings
     */
    List<ParkingVO> getByParkingPlaceId(Long parkingPlaceId);

    /**
     * This method can save a new parking to the data layer
     *
     * @param parkingVO The new parking to save.
     */
    void save(ParkingVO parkingVO);

    /**
     * This method can remove a parking from the data layer
     *
     * @param id The id of the parking to remove.
     */
    void remove(Long id);
}
