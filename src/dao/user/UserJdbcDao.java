package dao.user;

import model.PaymentMethod;
import model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mmcclay
 * Date: 8/7/12
 * Time: 10:57 PM
 * To change this template use File | Settings | File Templates.
 */
@Service(value = "userDao")
public class UserJdbcDao implements UserDao {

    private static User staticUser = null;

    static {
        User user = new User();

        user.setEmail("mmcclay@gmail.com");
        user.setPassword("Password");

        PaymentMethod pm = new PaymentMethod("Mike", "McClay", "1 Toledo", "Apt 1",
                "San Francisco", "CA", "94123",
                "Visa", "4111 1111 1111 1111", "03/13");

        user.setPaymentMethod(pm);
        user.setCreateDate(new Date(System.currentTimeMillis()));
        user.setLastLoginDate(new Date(System.currentTimeMillis()));
        staticUser = user;
    }


    public void create(User user) {

    }

    public void update(User user) {

    }

    public List<User> findAllUsers() {
        List list = new ArrayList();
        list.add(staticUser);
        return list;
    }

    public User findUserByEmail(String email) {
        if (staticUser.getEmail().equals(email)) {
            return staticUser;
        }

        return null;
    }
}
