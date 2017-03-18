package hu.aronszabo.ulyssys.parking.service.api.service;

import hu.aronszabo.ulyssys.parking.service.api.vo.CarVO;

public interface CarService {

    CarVO getByLicensePlateNumber(String licensePlateNumber);

    void save(CarVO carVO);

    void remove(Long id);
}
