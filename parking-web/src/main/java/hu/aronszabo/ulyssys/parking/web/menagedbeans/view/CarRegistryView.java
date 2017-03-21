package hu.aronszabo.ulyssys.parking.web.menagedbeans.view;

import hu.aronszabo.ulyssys.parking.service.api.service.CarService;
import hu.aronszabo.ulyssys.parking.service.api.vo.CarVO;
import java.util.Collection;
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
            carService.remove(selected.getLicensePlateNumber());
        }
        selected = null;
    }

    public Boolean isDeletable() {
        return selected != null && !selected.getParking();
    }

}
