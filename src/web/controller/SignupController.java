package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: mmcclay
 * Date: 8/5/12
 * Time: 11:38 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class SignupController {

    @Resource
    UserService userService;

//    @RequestMapping(value="/signup/email", method = RequestMethod.GET)
//    public ModelAndView signupEmail(HttpServletRequest request) {
//        ModelAndView modelAndView = new ModelAndView("signup.email");
//    }
//
//    @RequestMapping(value="/signup/verifyEmail", method = RequestMethod.POST)
//    public ModelAndView verifyEmail(HttpServletRequest request,
//                                    @RequestParam String email,
//                                    @RequestParam String password) {
//    }





}
