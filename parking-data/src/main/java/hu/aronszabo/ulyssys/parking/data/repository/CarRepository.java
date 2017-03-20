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
        DATA.add(new CarDTO("KVE-232", "Suzuki", "SX4", "green"));
        DATA.add(new CarDTO("KVE-233", "Skoda", "Fabia", "red"));
        DATA.add(new CarDTO("KVE-234", "BMW", "320d", "black"));
        DATA.add(new CarDTO("KVE-235", "Skoda", "Octavia", "black"));
        DATA.add(new CarDTO("KVE-236", "Renault", "Clio", "white"));
        DATA.add(new CarDTO("KVE-237", "Opel", "Corsa", "red"));
        DATA.add(new CarDTO("KVE-238", "Volvo", "S40", "black"));
        DATA.add(new CarDTO("KVE-239", "Ford", "Fiesta", "black"));
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
