package hu.aronszabo.ulyssys.parking.service.mappers;

import hu.aronszabo.ulyssys.parking.data.dto.CarDTO;
import hu.aronszabo.ulyssys.parking.service.api.vo.CarVO;
import java.util.ArrayList;
import java.util.List;
import org.dozer.DozerBeanMapper;

public final class CarMapper {

    private static DozerBeanMapper mapper = new DozerBeanMapper();

    private CarMapper() {
    }

    public static CarVO toVO(final CarDTO dto) {
        if (dto == null) {
            return null;
        }
        return mapper.map(dto, CarVO.class);
    }

    public static CarDTO toDTO(final CarVO vo) {
        if (vo == null) {
            return null;
        }
        return mapper.map(vo, CarDTO.class);
    }

    public static List<CarVO> toVO(final List<CarDTO> dtos) {
        List<CarVO> tmp = new ArrayList<>();
        for (CarDTO dto : dtos) {
            tmp.add(toVO(dto));
        }
        return tmp;
    }

    public static List<CarDTO> toDTO(final List<CarVO> vos) {
        List<CarDTO> tmp = new ArrayList<>();
        for (CarVO vo : vos) {
            tmp.add(toDTO(vo));
        }
        return tmp;
    }

}
