package hu.aronszabo.ulyssys.parking.service.api.service;

import hu.aronszabo.ulyssys.parking.service.api.vo.ParkingPlaceVO;

public interface ParkingPlaceService {

    public ParkingPlaceVO getById(final Long id);

    public void save(ParkingPlaceVO parkingPlaceVO);

    public void remove(Long id);
}
