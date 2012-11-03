package web.controller;

import model.Order;
import model.TicketInformation;
import model.UpgradeOption;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: mmcclay
 * Date: 8/4/12
 * Time: 10:04 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class OrderController {


    private static Map<Long, String> eventIdToNameMap = new HashMap<Long, String>();
    private static Map<Long, TicketInformation> upgradeIdToTicketInformation = new HashMap<Long, TicketInformation>();

    static {
        eventIdToNameMap.put(1L, "San Francisco Giants");
        eventIdToNameMap.put(2L, "San Jose Sharks");
        eventIdToNameMap.put(3L, "Golden State Warriors");
        eventIdToNameMap.put(4L, "Los Angeles Kings");
        eventIdToNameMap.put(5L, "New York Yankees");
        eventIdToNameMap.put(6L, "Foothill Knights");

        upgradeIdToTicketInformation.put(1L, new TicketInformation(1L, null, "1", "3", "3", 80));
        upgradeIdToTicketInformation.put(2L, new TicketInformation(2L, null, "5", "3", "7", 75));
        upgradeIdToTicketInformation.put(3L, new TicketInformation(3L, null, "15", "18", "13", 55));
        upgradeIdToTicketInformation.put(4L, new TicketInformation(4L, null, "22", "24", "7", 45));
        upgradeIdToTicketInformation.put(5L, new TicketInformation(5L, null, "8", "32", "6", 35));
        upgradeIdToTicketInformation.put(6L, new TicketInformation(6L, null, "26", "4", "10", 25));
    }

    @RequestMapping(value="/order/{eventId}/{upgradeId}", method = RequestMethod.GET)
    public ModelAndView order(HttpServletRequest request,
                                 @PathVariable long eventId,
                                 @PathVariable long upgradeId) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            ModelAndView mav = new ModelAndView("redirect:/spring/loginInPath/" + eventId + "/" + upgradeId);
            return mav;
        }

        ModelAndView modelAndView = new ModelAndView("order.mobile") ;

        TicketInformation ticketInformation = (TicketInformation) session.getAttribute("ticketInformation");
        TicketInformation upgradeTicketInformation = upgradeIdToTicketInformation.get(upgradeId);


        modelAndView.addObject("eventId", eventId);
        modelAndView.addObject("eventName", eventIdToNameMap.get(eventId));
        modelAndView.addObject("currentTicketInformation", ticketInformation);
        modelAndView.addObject("upgradeId", upgradeId);
        modelAndView.addObject("upgradeTicketInformation", upgradeTicketInformation);

        return modelAndView;
    }

    @RequestMapping(value="/order/confirmDialog/{eventId}/{upgradeId}", method = RequestMethod.GET)
    public ModelAndView confirmDialog(HttpServletRequest request,
                              @PathVariable long eventId,
                              @PathVariable long upgradeId) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            ModelAndView mav = new ModelAndView("redirect:/spring/loginInPath/" + eventId + "/" + upgradeId);
            return mav;
        }

        ModelAndView modelAndView = new ModelAndView("order.confirmDialog") ;

        TicketInformation ticketInformation = (TicketInformation) session.getAttribute("ticketInformation");
        TicketInformation upgradeTicketInformation = upgradeIdToTicketInformation.get(upgradeId);


        modelAndView.addObject("eventId", eventId);
        modelAndView.addObject("eventName", eventIdToNameMap.get(eventId));
        modelAndView.addObject("currentTicketInformation", ticketInformation);
        modelAndView.addObject("upgradeId", upgradeId);
        modelAndView.addObject("upgradeTicketInformation", upgradeTicketInformation);

        return modelAndView;
    }

    @RequestMapping(value="/order/execute/{eventId}/{upgradeId}", method = RequestMethod.GET)
    public ModelAndView orderExecute(HttpServletRequest request,
                                      @PathVariable long eventId,
                                      @PathVariable long upgradeId) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            ModelAndView mav = new ModelAndView("redirect:/spring/loginInPath/" + eventId + "/" + upgradeId);
            return mav;
        }

        // charge card

        Order order = new Order(1L,
                                user,
                                (TicketInformation) session.getAttribute("ticketInformation"),
                                upgradeIdToTicketInformation.get(upgradeId));

        ModelAndView modelAndView = new ModelAndView("redirect:/spring/confirm/" + order.getId()) ;

        session.setAttribute("order", order);

        return modelAndView;
    }

    @RequestMapping(value="/confirm/{orderId}", method = RequestMethod.GET)
    public ModelAndView viewConfirmation(HttpServletRequest request,
                                         @PathVariable long orderId) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Order order = (Order) session.getAttribute("order");


        ModelAndView modelAndView = new ModelAndView("confirm");
        modelAndView.addObject("originalTicketInformation", order.getOriginalTicketInformation());
        modelAndView.addObject("upgradeTicketInformation", order.getUpgradeTicketInformation());

        return modelAndView;

    }

}
