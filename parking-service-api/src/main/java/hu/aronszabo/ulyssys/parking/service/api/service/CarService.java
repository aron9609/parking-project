package hu.aronszabo.ulyssys.parking.service.api.service;

import hu.aronszabo.ulyssys.parking.service.api.vo.CarVO;

public interface CarService {

    public CarVO getByLicensePlateNumber(String licensePlateNumber);

    public void save(CarVO carVO);

    public void remove(Long id);
}
