package lk.ijse.dep.pos.web.api;


import lk.ijse.dep.pos.web.business.custom.CustomerBO;
import lk.ijse.dep.pos.web.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServlet;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/customers")
public class CustomerController extends HttpServlet {

    //TODO: Validations using Bean Validator

    @Autowired
    private CustomerBO customerBO;

    @GetMapping
    public List<CustomerDTO> getAllCustomers() throws Exception {
        return customerBO.getAllCustomers();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void saveCustomer(CustomerDTO customer) throws Exception {
        if (customerBO.customerExist(customer.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else {

            customerBO.saveCustomer(customer.getId(), customer.getName(), customer.getAddress());
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value = "/{id}")
    public void updateCustomer(@RequestBody MultiValueMap<String, String> params, @PathVariable String id) throws Exception {
        if (!customerBO.customerExist(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else {
            customerBO.updateCustomer(params.get("name").get(0),params.get("address").get(0),id);
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}")
    public void deleteCustomer(@PathVariable String id) throws Exception {
        if (!customerBO.customerExist(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        customerBO.deleteCustomer(id);
    }
}
