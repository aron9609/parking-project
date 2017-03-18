package hu.aronszabo.ulyssys.parking.service.mappers;

import hu.aronszabo.ulyssys.parking.data.dto.ParkingDTO;
import hu.aronszabo.ulyssys.parking.data.dto.ParkingPlaceDTO;
import hu.aronszabo.ulyssys.parking.service.api.vo.ParkingPlaceVO;
import hu.aronszabo.ulyssys.parking.service.api.vo.ParkingVO;
import org.dozer.DozerBeanMapper;

public class ParkingPlaceMapper {

    private static DozerBeanMapper mapper = new DozerBeanMapper();

    private ParkingPlaceMapper() {
    }

    public static ParkingPlaceVO toVO(final ParkingPlaceDTO dto) {
        if (dto == null) {
            return null;
        }
        return mapper.map(dto, ParkingPlaceVO.class);
    }

    public static ParkingPlaceDTO toDTO(final ParkingPlaceVO vo) {
        if (vo == null) {
            return null;
        }
        return mapper.map(vo, ParkingPlaceDTO.class);
    }
}
