package hu.aronszabo.ulyssys.parking.data.repository;

import hu.aronszabo.ulyssys.parking.data.dto.CarDTO;
import java.util.LinkedList;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
public class CarRepository {

    private static final List<CarDTO> DATA;

    static {
        DATA = new LinkedList<>();
        DATA.add(new CarDTO("KVE-228", "Suzuki", "Swift", "white"));
        DATA.add(new CarDTO("KVE-229", "Opel", "Astra", "red"));
        DATA.add(new CarDTO("KVE-230", "Kia", "Rio", "black"));
        DATA.add(new CarDTO("KVE-231", "Ford", "Fiesta", "black"));
        log.debug(DATA.toString());
    }

    public List<CarDTO> getAll() {
        return DATA;
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

    public void remove(final String licensePlateNumber) {
        for (CarDTO tmp : DATA) {
            if (tmp.getLicensePlateNumber().equals(licensePlateNumber)) {
                DATA.remove(tmp);
                break;
            }
        }
    }
}
