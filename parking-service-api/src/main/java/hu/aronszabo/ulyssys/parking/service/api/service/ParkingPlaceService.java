package hu.aronszabo.ulyssys.parking.service.api.service;

import hu.aronszabo.ulyssys.parking.service.api.vo.ParkingPlaceVO;
import java.util.List;

public interface ParkingPlaceService {

    public List<ParkingPlaceVO> getAll();

    ParkingPlaceVO getById(Long id);

    void save(ParkingPlaceVO parkingPlaceVO);

    void remove(Long id);

}
