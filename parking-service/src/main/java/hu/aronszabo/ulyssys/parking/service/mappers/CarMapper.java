package hu.aronszabo.ulyssys.parking.service.mappers;

import hu.aronszabo.ulyssys.parking.data.dto.CarDTO;
import hu.aronszabo.ulyssys.parking.service.api.vo.CarVO;
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
}
