package hu.aronszabo.ulyssys.parking.data.repository;

import hu.aronszabo.ulyssys.parking.data.dto.CarDTO;
import java.util.LinkedList;
import java.util.List;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CarRepository {

    private static final List<CarDTO> DATA;

    static {
        DATA = new LinkedList<>();
    }

    public CarDTO getByLicensePlateNumber(final String licensePlateNumber) {
        CarDTO result = null;
        for (CarDTO tmp : DATA) {
            if (tmp.getLicensePlateNumber().equals(licensePlateNumber)) {
                result = tmp;
                break;
            }
        }
        return result;
    }

    public void save(final CarDTO carDTO) {
        DATA.add(carDTO);
    }

    public void remove(final Long id) {
        for (CarDTO tmp : DATA) {
            if (tmp.getLicensePlateNumber().equals(id)) {
                DATA.remove(tmp);
                break;
            }
        }
    }
}
