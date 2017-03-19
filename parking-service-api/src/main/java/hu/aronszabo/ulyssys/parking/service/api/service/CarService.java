package hu.aronszabo.ulyssys.parking.service.api.service;

import hu.aronszabo.ulyssys.parking.service.api.vo.CarVO;
import java.util.List;

public interface CarService {

    CarVO getByLicensePlateNumber(String licensePlateNumber);

    List<CarVO> getAll();

    void save(CarVO carVO);

    void remove(String licensePlateNumber);

}
