package hu.aronszabo.ulyssys.parking.service.impl;

import hu.aronszabo.ulyssys.parking.data.repository.ParkingPlaceRepository;
import hu.aronszabo.ulyssys.parking.service.api.service.ParkingPlaceService;
import hu.aronszabo.ulyssys.parking.service.api.vo.ParkingPlaceVO;
import hu.aronszabo.ulyssys.parking.service.mappers.ParkingPlaceMapper;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless(mappedName = "ParkingPlaceService")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class ParkingPlaceBean implements ParkingPlaceService {

    private static final ParkingPlaceRepository REPOSITORY = new ParkingPlaceRepository();

    @Override
    public ParkingPlaceVO getById(final Long id) {
        return ParkingPlaceMapper.toVO(REPOSITORY.getById(id));
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
