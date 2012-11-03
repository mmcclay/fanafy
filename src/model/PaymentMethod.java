package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: mmcclay
 * Date: 8/5/12
 * Time: 11:35 AM
 * To change this template use File | Settings | File Templates.
 */
/*@Entity
@Table(name = "paymentMethod")*/
public class PaymentMethod {

    long paymentMethodId;
    String firstName;
    String lastName;

    String address1;
    String address2;
    String city;
    String state;
    String zip;

    String ccType;
    String ccNumber;
    String ccExpiration;

    public PaymentMethod(String firstName,
                         String lastName,
                         String address1,
                         String address2,
                         String city,
                         String state,
                         String zip,
                         String ccType,
                         String ccNumber,
                         String ccExpiration) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.ccType = ccType;
        this.ccNumber = ccNumber;
        this.ccExpiration = ccExpiration;
    }

/*    @Id
    @GeneratedValue*/
    public long getPaymentMethodId() {
        return this.paymentMethodId;
    }

    public void setPaymentMethodId(long paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCcType() {
        return ccType;
    }

    public void setCcType(String ccType) {
        this.ccType = ccType;
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public String getCcExpiration() {
        return ccExpiration;
    }

    public void setCcExpiration(String ccExpiration) {
        this.ccExpiration = ccExpiration;
    }
}
