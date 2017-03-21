package hu.aronszabo.ulyssys.parking.web.menagedbeans.view;

import hu.aronszabo.ulyssys.parking.service.api.exception.CarAlreadyExistsException;
import hu.aronszabo.ulyssys.parking.service.api.service.CarService;
import hu.aronszabo.ulyssys.parking.service.api.vo.CarVO;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.primefaces.context.RequestContext;

@Slf4j
@Data
@NoArgsConstructor
@ViewScoped
@ManagedBean(name = "carSaverView")
public class CarSaverView {

    @EJB
    private CarService carService;

    private CarVO car;

    @PostConstruct
    public void init() {
        car = new CarVO();
    }

    public void save() {
        try {
            carService.save(car);
            car = new CarVO();
            RequestContext.getCurrentInstance().update("new_car_modal");
            RequestContext.getCurrentInstance().update("car_form");
        } catch (CarAlreadyExistsException ex) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Invalid data", "This car is already in the database");
            RequestContext.getCurrentInstance().showMessageInDialog(message);
        }

    }
}
