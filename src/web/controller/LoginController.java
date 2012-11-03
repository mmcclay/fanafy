package web.controller;

import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: mmcclay
 * Date: 8/7/12
 * Time: 9:43 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class LoginController {

    @Resource
    UserService userService;


    @RequestMapping(value = "/loginInPath/{eventId}/{upgradeId}", method = RequestMethod.GET)
    public ModelAndView loginInPath(HttpServletRequest request,
                                    @PathVariable long eventId,
                                    @PathVariable long upgradeId) {
        return new ModelAndView("loginInPath.mobile")
                    .addObject("eventId", eventId)
                    .addObject("upgradeId", upgradeId);
    }

    @RequestMapping(value = "/loginInPath/{eventId}/{upgradeId}", method = RequestMethod.POST)
    public ModelAndView loginInPath(HttpServletRequest request,
                                    @PathVariable long eventId,
                                    @PathVariable long upgradeId,
                                    @RequestParam String email,
                                    @RequestParam String password) {
        if (email == null || password == null) {
            String errorMessage = "Please enter your email and password";
            return new ModelAndView("loginInPath.mobile").addObject("error", errorMessage)
                        .addObject("eventId", eventId)
                        .addObject("upgradeId", upgradeId)
                        .addObject("email", email);
        }

        User user = userService.findUserByEmail(email);
        if (user == null || !password.equals(user.getPassword())) {
            String errorMessage = "We could not find that email and password, please try again";
            return new ModelAndView("loginInPath.mobile")
                            .addObject("error", errorMessage)
                            .addObject("eventId", eventId)
                            .addObject("upgradeId", upgradeId)
                            .addObject("email", email);
        }

        // if we are here the password and email matched, redirect to order controller

        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        return new ModelAndView("redirect:/spring/order/" + eventId + "/" + upgradeId);

    }
}
