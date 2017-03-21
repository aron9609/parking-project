package hu.aronszabo.ulyssys.parking.service.mappers;

import hu.aronszabo.ulyssys.parking.data.dto.ParkingDTO;
import hu.aronszabo.ulyssys.parking.service.api.vo.ParkingVO;
import java.util.ArrayList;
import java.util.List;
import org.dozer.DozerBeanMapper;

public final class ParkingMapper {

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

    public static List<ParkingVO> toVO(final List<ParkingDTO> dtos) {
        List<ParkingVO> tmp = new ArrayList<>();
        for (ParkingDTO dto : dtos) {
            tmp.add(toVO(dto));
        }
        return tmp;
    }

    public static List<ParkingDTO> toDTO(final List<ParkingVO> vos) {
        List<ParkingDTO> tmp = new ArrayList<>();
        for (ParkingVO vo : vos) {
            tmp.add(toDTO(vo));
        }
        return tmp;
    }
}
