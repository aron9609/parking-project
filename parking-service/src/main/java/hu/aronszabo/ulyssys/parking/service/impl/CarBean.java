package hu.aronszabo.ulyssys.parking.service.impl;

import hu.aronszabo.ulyssys.parking.data.repository.CarRepository;
import hu.aronszabo.ulyssys.parking.service.api.exception.CarAlreadyExistsException;
import hu.aronszabo.ulyssys.parking.service.api.exception.DeleteParkingCarException;
import hu.aronszabo.ulyssys.parking.service.api.exception.NotFoundException;
import hu.aronszabo.ulyssys.parking.service.api.service.CarService;
import hu.aronszabo.ulyssys.parking.service.api.service.ParkingService;
import hu.aronszabo.ulyssys.parking.service.api.vo.CarVO;
import hu.aronszabo.ulyssys.parking.service.mappers.CarMapper;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 * @see CarService
 */
@Stateless(mappedName = "CarService")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class CarBean implements CarService {

    @EJB
    private ParkingService parkingService;

    private static final CarRepository REPOSITORY = new CarRepository();

    @Override
    public CarVO getByLicensePlateNumber(final String licensePlateNumber) throws NotFoundException {
        CarVO tmp = null;
        tmp = CarMapper.toVO(REPOSITORY.getByLicensePlateNumber(licensePlateNumber));
        if (tmp != null) {
            if (parkingService.getByLicensePlateNumber(licensePlateNumber) == null) {
                tmp.setParking(false);
            } else {
                tmp.setParking(true);
            }
            return tmp;
        } else {
            throw new NotFoundException("There is no car with the specified license plate number");
        }
    }

    @Override
    public void save(final CarVO carVO) throws CarAlreadyExistsException {
        if (REPOSITORY.getByLicensePlateNumber(carVO.getLicensePlateNumber()) == null) {
            REPOSITORY.save(CarMapper.toDTO(carVO));
        } else {
            throw new CarAlreadyExistsException("This car is already in the database");
        }
    }

    @Override
    public void remove(final String licensePlateNumber) throws DeleteParkingCarException {
        try {
            if (!getByLicensePlateNumber(licensePlateNumber).getParking()) {
                REPOSITORY.remove(licensePlateNumber);
            } else {
                throw new DeleteParkingCarException("This car is in a parking place");
            }
        } catch (NotFoundException ex) {
            Logger.getLogger(CarBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<CarVO> getAll() {
        List<CarVO> cars = CarMapper.toVO(REPOSITORY.getAll());
        for (CarVO car : cars) {
            if (parkingService.getByLicensePlateNumber(car.getLicensePlateNumber()) == null) {
                car.setParking(false);
            } else {
                car.setParking(true);
            }
        }
        return cars;
    }
}
