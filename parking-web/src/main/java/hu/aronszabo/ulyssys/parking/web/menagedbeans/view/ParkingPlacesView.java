package hu.aronszabo.ulyssys.parking.web.menagedbeans.view;

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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.primefaces.event.TabChangeEvent;

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
    private ParkingPlaceVO place;
    private String licensePlateNumber;

    private Date begin;
    private Date end;

    @PostConstruct
    public void init() {
        car = null;
    }

    public CarVO getCarData() {
        if (car == null) {
            car = carService.getByLicensePlateNumber(licensePlateNumber);
        }
        return car;
    }

    public Collection<ParkingPlaceVO> getParkingData() {
        return parkingPlaceService.getAll();
    }

    public void onTabChange(TabChangeEvent event) {
        place = (ParkingPlaceVO) event.getData();
    }

    public void save(Long id) {
        ParkingVO tmp = new ParkingVO();
        tmp.setBeginOfParking(begin);
        tmp.setEndOfParking(end);
        tmp.setLicensePlateNumber(car.getLicensePlateNumber());
        tmp.setParkingPlaceId(id);
        parkingService.save(tmp);
    }
}
