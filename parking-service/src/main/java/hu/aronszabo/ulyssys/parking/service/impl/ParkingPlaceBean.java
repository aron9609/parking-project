package hu.aronszabo.ulyssys.parking.service.impl;

import hu.aronszabo.ulyssys.parking.data.repository.ParkingPlaceRepository;
import hu.aronszabo.ulyssys.parking.service.api.service.CarService;
import hu.aronszabo.ulyssys.parking.service.api.service.ParkingPlaceService;
import hu.aronszabo.ulyssys.parking.service.api.service.ParkingService;
import hu.aronszabo.ulyssys.parking.service.api.vo.CarVO;
import hu.aronszabo.ulyssys.parking.service.api.vo.ParkingPlaceVO;
import hu.aronszabo.ulyssys.parking.service.api.vo.ParkingVO;
import hu.aronszabo.ulyssys.parking.service.mappers.CarMapper;
import hu.aronszabo.ulyssys.parking.service.mappers.ParkingPlaceMapper;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

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
                tmpCars.add(carService.getByLicensePlateNumber(vo.getLicensePlateNumber()));
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
            cars.add(carService.getByLicensePlateNumber(vo.getLicensePlateNumber()));
        }
        result.setCars(cars);
        return result;
    }

    @Override
    public void save(final ParkingPlaceVO parkingPlaceVO) {
        REPOSITORY.save(ParkingPlaceMapper.toDTO(parkingPlaceVO));
    }

    @Override
    public void remove(final Long id) {
        REPOSITORY.remove(id);
    }

}
