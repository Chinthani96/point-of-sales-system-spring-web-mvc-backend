package lk.ijse.dep.pos.web.api;

import lk.ijse.dep.pos.web.business.custom.ItemBO;
import lk.ijse.dep.pos.web.dto.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServlet;
import java.math.BigDecimal;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/items")
public class ItemController extends HttpServlet {

    @Autowired
    private ItemBO itemBO;

    @GetMapping
    public List<ItemDTO> getAllItems() throws Exception {
        return itemBO.getAllItems();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void saveItem(ItemDTO item) throws Exception {
        if (itemBO.itemExist(item.getCode())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        else{
            itemBO.saveItem(item.getCode(),item.getDescription(),item.getUnitPrice().doubleValue(),item.getQtyOnHand());
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{code}")
    public void updateItem(@PathVariable  String code, MultiValueMap<String, String> params) throws Exception {
        if (!itemBO.itemExist(code)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        else{
            itemBO.updateItem(code,params.get("description").get(0),Double.parseDouble(params.get("unitPrice").get(0)),Integer.parseInt(params.get("qtyOnHand").get(0)));
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{code}")
    public void deleteItem(@PathVariable String code) throws Exception {
        if (!itemBO.itemExist(code)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        else{
            itemBO.deleteItem(code);
        }
    }
}
