package hu.aronszabo.ulyssys.parking.service.api.service;

import hu.aronszabo.ulyssys.parking.service.api.vo.ParkingVO;

public interface ParkingService {

    ParkingVO getByLicensePlateNumber(String licensePlateNumber);

    ParkingVO getById(Long id);

    ParkingVO getByParkingPlaceId(Long parkingPlaceId);

    void save(ParkingVO parkingVO);

    void remove(Long id);
}
