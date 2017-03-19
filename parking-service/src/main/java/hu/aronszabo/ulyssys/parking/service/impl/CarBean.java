package hu.aronszabo.ulyssys.parking.service.impl;

import hu.aronszabo.ulyssys.parking.data.repository.CarRepository;
import hu.aronszabo.ulyssys.parking.service.api.service.CarService;
import hu.aronszabo.ulyssys.parking.service.api.vo.CarVO;
import hu.aronszabo.ulyssys.parking.service.mappers.CarMapper;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless(mappedName = "CarService")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class CarBean implements CarService {

    private static final CarRepository REPOSITORY = new CarRepository();

    @Override
    public CarVO getByLicensePlateNumber(final String licensePlateNumber) {
        return CarMapper.toVO(REPOSITORY.getByLicensePlateNumber(licensePlateNumber));
    }

    @Override
    public void save(final CarVO carVO) {
        REPOSITORY.save(CarMapper.toDTO(carVO));
    }

    @Override
    public void remove(final Long id) {
        REPOSITORY.remove(id);
    }

    @Override
    public List<CarVO> getAll() {
        return CarMapper.toVO(REPOSITORY.getAll());
    }
}
