package hu.aronszabo.ulyssys.parking.web.menagedbeans.view;

import hu.aronszabo.ulyssys.parking.service.api.exception.DeleteParkingCarException;
import hu.aronszabo.ulyssys.parking.service.api.service.CarService;
import hu.aronszabo.ulyssys.parking.service.api.vo.CarVO;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
@ViewScoped
@ManagedBean(name = "carRegistryView")
public class CarRegistryView {

    @EJB
    private CarService carService;

    private CarVO selected;

    @PostConstruct
    public void init() {
        selected = null;
    }

    public Collection<CarVO> getCars() {
        return carService.getAll();
    }

    public void deleteSelected() {
        if (selected != null) {
            try {
                carService.remove(selected.getLicensePlateNumber());
            } catch (DeleteParkingCarException ex) {
                Logger.getLogger(CarRegistryView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        selected = null;
    }

    public Boolean isDeletable() {
        return selected != null && !selected.getParking();
    }

}
