package web;

import model.PaymentMethod;
import model.User;
import org.apache.tiles.TilesApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.tiles2.SpringTilesApplicationContextFactory;
import service.UserService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Mike
 * Date: 12/18/11
 * Time: 6:57 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class HomeController {
    
    @Resource
    UserService userService;

    @RequestMapping(value = "/")
    public ModelAndView home() {

        List<User> allUsers = userService.findAllUsers();





        return new ModelAndView("homepage.mobile");
    }

}
