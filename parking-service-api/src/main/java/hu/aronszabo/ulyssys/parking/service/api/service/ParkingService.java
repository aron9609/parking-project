package hu.aronszabo.ulyssys.parking.service.api.service;

import hu.aronszabo.ulyssys.parking.service.api.vo.ParkingVO;
import java.util.List;

public interface ParkingService {

    List<ParkingVO> getByLicensePlateNumber(String licensePlateNumber);

    ParkingVO getById(Long id);

    List<ParkingVO> getByParkingPlaceId(Long parkingPlaceId);

    void save(ParkingVO parkingVO);

    void remove(Long id);
}
