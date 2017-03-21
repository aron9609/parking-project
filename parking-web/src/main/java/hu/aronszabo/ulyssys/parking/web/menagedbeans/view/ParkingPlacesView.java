package hu.aronszabo.ulyssys.parking.web.menagedbeans.view;

import hu.aronszabo.ulyssys.parking.service.api.exception.NotFoundException;
import hu.aronszabo.ulyssys.parking.service.api.service.CarService;
import hu.aronszabo.ulyssys.parking.service.api.service.ParkingPlaceService;
import hu.aronszabo.ulyssys.parking.service.api.service.ParkingService;
import hu.aronszabo.ulyssys.parking.service.api.vo.CarVO;
import hu.aronszabo.ulyssys.parking.service.api.vo.ParkingPlaceVO;
import hu.aronszabo.ulyssys.parking.service.api.vo.ParkingVO;
import java.util.Collection;
import java.util.Date;
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
@ManagedBean(name = "parkingPlaceView")
public class ParkingPlacesView {

    @EJB
    private ParkingPlaceService parkingPlaceService;

    @EJB
    private ParkingService parkingService;

    @EJB
    private CarService carService;

    private CarVO car;
    private String licensePlateNumber;

    private Date begin;
    private Date end;

    @PostConstruct
    public void init() {
        car = null;
        begin = new Date();
        end = new Date();
    }

    public CarVO getCarData() {
        if (car == null) {
            try {
                car = carService.getByLicensePlateNumber(licensePlateNumber);
            } catch (NotFoundException ex) {
                log.error("car not found");
            }
        }
        return car;
    }

    public Collection<ParkingPlaceVO> getParkingData() {
        return parkingPlaceService.getAll();
    }

    public void save(final Long id) {
        if (!car.getParking()) {
            ParkingVO tmp = new ParkingVO();
            tmp.setBeginOfParking(begin);
            tmp.setEndOfParking(end);
            tmp.setLicensePlateNumber(car.getLicensePlateNumber());
            tmp.setParkingPlaceId(id);
            parkingService.save(tmp);
            car.setParking(true);
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR", "This car is already in one of the parking places");
            RequestContext.getCurrentInstance().showMessageInDialog(message);
        }
    }
}
