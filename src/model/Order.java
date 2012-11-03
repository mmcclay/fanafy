package model;

/**
 * Created with IntelliJ IDEA.
 * User: mmcclay
 * Date: 8/8/12
 * Time: 8:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class Order {

    long id;

    User user;

    TicketInformation originalTicketInformation;

    TicketInformation upgradeTicketInformation;

    public Order(long id,
                 User user,
                 TicketInformation originalTicketInformation,
                 TicketInformation upgradeTicketInformation) {
        this.id = id;
        this.user = user;
        this.originalTicketInformation = originalTicketInformation;
        this.upgradeTicketInformation = upgradeTicketInformation;
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public TicketInformation getOriginalTicketInformation() {
        return originalTicketInformation;
    }

    public TicketInformation getUpgradeTicketInformation() {
        return upgradeTicketInformation;
    }
}
