package hu.aronszabo.ulyssys.parking.service.api.service;

import hu.aronszabo.ulyssys.parking.service.api.vo.ParkingPlaceVO;

public interface ParkingPlaceService {

    ParkingPlaceVO getById(Long id);

    void save(ParkingPlaceVO parkingPlaceVO);

    void remove(Long id);
}
