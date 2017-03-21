package hu.aronszabo.ulyssys.parking.service.impl;

import hu.aronszabo.ulyssys.parking.data.repository.ParkingPlaceRepository;
import hu.aronszabo.ulyssys.parking.service.api.exception.NotFoundException;
import hu.aronszabo.ulyssys.parking.service.api.service.CarService;
import hu.aronszabo.ulyssys.parking.service.api.service.ParkingPlaceService;
import hu.aronszabo.ulyssys.parking.service.api.service.ParkingService;
import hu.aronszabo.ulyssys.parking.service.api.vo.CarVO;
import hu.aronszabo.ulyssys.parking.service.api.vo.ParkingPlaceVO;
import hu.aronszabo.ulyssys.parking.service.api.vo.ParkingVO;
import hu.aronszabo.ulyssys.parking.service.mappers.ParkingPlaceMapper;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import lombok.extern.slf4j.Slf4j;

/**
 * @see ParkingPlaceService
 */
@Slf4j
@Stateless(mappedName = "ParkingPlaceService")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class ParkingPlaceBean implements ParkingPlaceService {

    private static final ParkingPlaceRepository REPOSITORY = new ParkingPlaceRepository();

    @EJB
    private ParkingService parkingService;
    @EJB
    private CarService carService;

    @Override
    public List<ParkingPlaceVO> getAll() {
        List<ParkingPlaceVO> result = ParkingPlaceMapper.toVO(REPOSITORY.getAll());
        for (ParkingPlaceVO tmp : result) {
            List<ParkingVO> parkings = parkingService.getByParkingPlaceId(tmp.getId());
            List<CarVO> tmpCars = new ArrayList<>();
            for (ParkingVO vo : parkings) {
                try {
                    tmpCars.add(carService.getByLicensePlateNumber(vo.getLicensePlateNumber()));
                } catch (NotFoundException ex) {
                    log.error("car not found");
                }
            }
            tmp.setCars(tmpCars);
        }
        return result;
    }

    @Override
    public ParkingPlaceVO getById(final Long id) {
        ParkingPlaceVO result = ParkingPlaceMapper.toVO(REPOSITORY.getById(id));
        List<CarVO> cars = new ArrayList<>();
        for (ParkingVO vo : parkingService.getByParkingPlaceId(id)) {
            try {
                cars.add(carService.getByLicensePlateNumber(vo.getLicensePlateNumber()));
            } catch (NotFoundException ex) {
                log.error("car not found");
            }
        }
        result.setCars(cars);
        return result;
    }

}
