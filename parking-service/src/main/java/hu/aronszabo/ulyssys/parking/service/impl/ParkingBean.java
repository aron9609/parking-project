package hu.aronszabo.ulyssys.parking.service.impl;

import hu.aronszabo.ulyssys.parking.data.repository.ParkingRepository;
import hu.aronszabo.ulyssys.parking.service.api.service.ParkingService;
import hu.aronszabo.ulyssys.parking.service.api.vo.ParkingVO;
import hu.aronszabo.ulyssys.parking.service.mappers.ParkingMapper;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless(mappedName = "ParkingService")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class ParkingBean implements ParkingService {

    private static final ParkingRepository REPOSITORY = new ParkingRepository();

    @Override
    public List<ParkingVO> getByLicensePlateNumber(final String licensePlateNumber) {
        return ParkingMapper.toVO(REPOSITORY.getByLicensePlateNumber(licensePlateNumber));
    }

    @Override
    public ParkingVO getById(final Long id) {
        return ParkingMapper.toVO(REPOSITORY.getById(id));
    }

    @Override
    public List<ParkingVO> getByParkingPlaceId(final Long parkingPlaceId) {
        return ParkingMapper.toVO(REPOSITORY.getByParkingPlaceId(parkingPlaceId));
    }

    @Override
    public void save(final ParkingVO parkingVO) {
        REPOSITORY.save(ParkingMapper.toDTO(parkingVO));
    }

    @Override
    public void remove(final Long id) {
        REPOSITORY.remove(id);
    }
}
