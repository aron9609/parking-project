package hu.aronszabo.ulyssys.parking.service.api.service;

import hu.aronszabo.ulyssys.parking.service.api.vo.ParkingPlaceVO;
import java.util.List;

/**
 * Defines the business logic of the service which can handle parking places.
 */
public interface ParkingPlaceService {

    /**
     * This method can get all parking places from the data layar.
     *
     * @return All parking places from the data layer.
     */
    List<ParkingPlaceVO> getAll();

    /**
     * This method can get a parking place specified by id from the data layar.
     *
     * @param id The id of the specified parking place.
     * @return All parking places from the data layer.
     */
    ParkingPlaceVO getById(Long id);

}
