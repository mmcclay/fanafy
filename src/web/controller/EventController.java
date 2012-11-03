package web.controller;

import model.TicketInformation;
import model.UpgradeOption;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: mmcclay
 * Date: 6/24/12
 * Time: 8:10 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class EventController {

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


    @RequestMapping(value = "/listEvents/{latitude}/{longitude}/{dummy}", method = RequestMethod.GET)
    public ModelAndView listEvents(HttpServletRequest request,
                                 HttpServletResponse response,
                                @PathVariable Float latitude,
                                @PathVariable Float longitude,
                                @PathVariable String dummy) {
        ModelAndView modelAndView =  new ModelAndView("list.events.mobile");
        modelAndView.addObject("latitude", latitude);
        modelAndView.addObject("longitude", longitude);

        return modelAndView;
    }

    @RequestMapping(value = "/findUpgrade/{eventId}", method = RequestMethod.GET)
    public ModelAndView findUpgrade (HttpServletRequest request,
                                HttpServletResponse response,
                                @PathVariable long eventId) {
        ModelAndView modelAndView =  new ModelAndView("event.findUpgrade.mobile");
        HttpSession session = request.getSession();
        TicketInformation ticketInformation = (TicketInformation) session.getAttribute("ticketInformation");

        if (ticketInformation != null) {
            modelAndView.addObject("hasTicketInformation", true);
            modelAndView.addObject("ticketInformation", ticketInformation);
            modelAndView.addObject("upgradeOptions", upgradeIdToTicketInformation.values());

        }


        modelAndView.addObject("eventId", eventId);
        modelAndView.addObject("eventName", eventIdToNameMap.get(eventId));

        return modelAndView;
    }

    @RequestMapping(value = "/currentTicketEntry/{eventId}", method = RequestMethod.GET)
    public ModelAndView currentTicketEntry (HttpServletRequest request,
                                     HttpServletResponse response,
                                     @PathVariable long eventId) {
        ModelAndView modelAndView =  new ModelAndView("currentTicketEntry").addObject("eventId", eventId);
        return modelAndView;
    }

    @RequestMapping(value="/submitCurrentTicketInfo", method = RequestMethod.POST)
    public ModelAndView submitCurrentTicketInfo(HttpServletRequest request,
                                                @RequestParam String section,
                                                @RequestParam String row,
                                                @RequestParam String seats,
                                                @RequestParam long eventId) {
        ModelAndView modelAndView = new ModelAndView("redirect:/spring/findUpgrade/" + eventId) ;

        TicketInformation ticketInformation = new TicketInformation(0L, eventIdToNameMap.get(eventId),
                                                        section, row, seats, 75.00f);

        HttpSession session = request.getSession();
        session.setAttribute("ticketInformation", ticketInformation);

        return modelAndView;
    }
}

