package hu.aronszabo.ulyssys.parking.service.api.service;

import hu.aronszabo.ulyssys.parking.service.api.exception.CarAlreadyExistsException;
import hu.aronszabo.ulyssys.parking.service.api.exception.DeleteParkingCarException;
import hu.aronszabo.ulyssys.parking.service.api.exception.NotFoundException;
import hu.aronszabo.ulyssys.parking.service.api.vo.CarVO;
import java.util.List;

/**
 * Defines the business logic of the service which can handle cars.
 */
public interface CarService {

    /**
     * This method can get a car specified by license plate number from the data
     * layar.
     *
     * @param licensePlateNumber The specified license plate number of the car.
     * @return the specified car
     */
    CarVO getByLicensePlateNumber(String licensePlateNumber) throws NotFoundException;

    /**
     * This method can get all cars from the data layar.
     *
     * @return All cars from the data layer.
     */
    List<CarVO> getAll();

    /**
     * This method can save a new car to the data layar.
     *
     * @param carVO The specified car to save.
     */
    void save(CarVO carVO) throws CarAlreadyExistsException;

    /**
     * This method can remove a car from the data layar.
     *
     * @param licensePlateNumber The license plate number of the car to remove.
     */
    void remove(String licensePlateNumber) throws DeleteParkingCarException;

}
