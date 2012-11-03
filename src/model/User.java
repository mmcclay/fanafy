package model;

import javax.persistence.*;
import java.util.Date;

/**
 * User model
 */
/*
@Entity
@Table
*/
public class User {
    
    private long id;
    private String email;
    private String password;

    private PaymentMethod paymentMethod;
    
    private Date createDate;
    private Date lastLoginDate;

/*
    @Id
    @GeneratedValue
*/
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

/*
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paymentId")
*/
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }
}
