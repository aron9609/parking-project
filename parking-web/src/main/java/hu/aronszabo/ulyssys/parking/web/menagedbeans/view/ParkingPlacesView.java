package hu.aronszabo.ulyssys.parking.web.menagedbeans.view;

import hu.aronszabo.ulyssys.parking.service.api.service.CarService;
import hu.aronszabo.ulyssys.parking.service.api.vo.CarVO;
import java.util.Date;
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
@ManagedBean(name = "parkingPlaceView")
public class ParkingPlacesView {

    @EJB
    private CarService carService;

    private CarVO car;
    private String licensePlateNumber;

    private Date begin;
    private Date end;

    @PostConstruct
    public void init() {
        car = null;
    }

    public CarVO getCarData() {
        if (car == null) {
            log.info(licensePlateNumber);
            return carService.getByLicensePlateNumber(licensePlateNumber);
        }
        return car;
    }
}
