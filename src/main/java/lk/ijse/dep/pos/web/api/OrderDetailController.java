package lk.ijse.dep.pos.web.api;

import lk.ijse.dep.pos.web.business.custom.OrderBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/order-details")
public class OrderDetailController extends HttpServlet {

    @Autowired
    protected OrderBO orderBO;

}
