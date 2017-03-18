package hu.aronszabo.ulyssys.parking.service.mappers;

import hu.aronszabo.ulyssys.parking.data.dto.ParkingDTO;
import hu.aronszabo.ulyssys.parking.service.api.vo.ParkingVO;
import org.dozer.DozerBeanMapper;

public class ParkingMapper {

    private static DozerBeanMapper mapper = new DozerBeanMapper();

    private ParkingMapper() {
    }

    public static ParkingVO toVO(final ParkingDTO dto) {
        if (dto == null) {
            return null;
        }
        return mapper.map(dto, ParkingVO.class);
    }

    public static ParkingDTO toDTO(final ParkingVO vo) {
        if (vo == null) {
            return null;
        }
        return mapper.map(vo, ParkingDTO.class);
    }
}
