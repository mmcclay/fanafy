package model;

/**
 * Created with IntelliJ IDEA.
 * User: mmcclay
 * Date: 8/4/12
 * Time: 10:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class TicketInformation {

    private long id;
    private String eventName;
    private String section;
    private String row;
    private String seats;
    private float value;

    public TicketInformation(long id, String eventName, String section, String row, String seats, float value) {
        this.id = id;
        this.eventName = eventName;
        this.section = section;
        this.row = row;
        this.seats = seats;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public String getSection() {
        return section;
    }

    public String getRow() {
        return row;
    }

    public String getSeats() {
        return seats;
    }

    public float getValue() {
        return value;
    }
}
