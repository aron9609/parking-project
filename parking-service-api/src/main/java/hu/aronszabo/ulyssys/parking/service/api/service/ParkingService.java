package hu.aronszabo.ulyssys.parking.service.api.service;

import hu.aronszabo.ulyssys.parking.service.api.vo.ParkingVO;

public interface ParkingService {

    public ParkingVO getByLicensePlateNumber(String licensePlateNumber);

    public ParkingVO getById(Long id);

    public ParkingVO getByParkingPlaceId(Long parkingPlaceId);

    public void save(final ParkingVO parkingVO);

    public void remove(Long id);
}
