package hu.aronszabo.ulyssys.parking.web.menagedbeans;

import hu.aronszabo.ulyssys.parking.service.api.service.CarService;
import hu.aronszabo.ulyssys.parking.service.api.vo.CarVO;
import javax.ejb.EJB;
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
    CarService carService;

    private String brand;
    private String type;
    private String color;
    private String licensePlateNumber;

    public void save() {
        CarVO tmp = new CarVO();
        tmp.setBrand(brand);
        tmp.setType(type);
        tmp.setColor(color);
        tmp.setLicensePlateNumber(licensePlateNumber);
        if (carService.getByLicensePlateNumber(licensePlateNumber) == null) {
            carService.save(tmp);
        } else {
            RequestContext.getCurrentInstance().execute("PF('error_dialog').show();");
        }
    }
}
