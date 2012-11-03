package model;

/**
 * Created with IntelliJ IDEA.
 * User: mmcclay
 * Date: 8/4/12
 * Time: 9:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class UpgradeOption {

    long id;
    String name;
    float cost;

    public UpgradeOption(long id, String name, float cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getCost() {
        return cost;
    }
}
