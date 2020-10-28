package lk.ijse.dep.pos.web.api;

import lk.ijse.dep.pos.web.business.custom.CustomerBO;
import lk.ijse.dep.pos.web.business.custom.OrderBO;
import lk.ijse.dep.pos.web.dto.CustomerDTO;
import lk.ijse.dep.pos.web.dto.OrderDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/orders")
public class OrderController extends HttpServlet {

    @Autowired
    private OrderBO orderBO;
    @Autowired
    private CustomerBO customerBO;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveOrder(String id, MultiValueMap<String, String> params){

    }

}
