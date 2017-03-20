package hu.aronszabo.ulyssys.parking.service.mappers;

import hu.aronszabo.ulyssys.parking.data.dto.CarDTO;
import hu.aronszabo.ulyssys.parking.data.dto.ParkingPlaceDTO;
import hu.aronszabo.ulyssys.parking.service.api.vo.CarVO;
import hu.aronszabo.ulyssys.parking.service.api.vo.ParkingPlaceVO;
import static hu.aronszabo.ulyssys.parking.service.mappers.CarMapper.toDTO;
import static hu.aronszabo.ulyssys.parking.service.mappers.CarMapper.toVO;
import java.util.ArrayList;
import java.util.List;
import org.dozer.DozerBeanMapper;

public final class ParkingPlaceMapper {

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

    public static List<ParkingPlaceVO> toVO(final List<ParkingPlaceDTO> dtos) {
        List<ParkingPlaceVO> tmp = new ArrayList<>();
        for (ParkingPlaceDTO dto : dtos) {
            tmp.add(toVO(dto));
        }
        return tmp;
    }

    public static List<ParkingPlaceDTO> toDTO(final List<ParkingPlaceVO> vos) {
        List<ParkingPlaceDTO> tmp = new ArrayList<>();
        for (ParkingPlaceVO vo : vos) {
            tmp.add(toDTO(vo));
        }
        return tmp;
    }
}
