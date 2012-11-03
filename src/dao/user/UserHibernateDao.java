package dao.user;

import model.User;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;
import service.UserService;

import javax.annotation.Resource;
import java.util.List;


/**
 * User DAO implemented with Hibernate
 */
/*@Service(value = "userDao")*/
public class UserHibernateDao implements UserDao  {

    @Resource
    UserService userService;

    /*@Resource (name="hibernateTemplate")*/
    HibernateTemplate hibernateTemplate;

    @Override
    public void create(User user) {
        hibernateTemplate.save(user);
    }

    @Override
    public void update(User user) {
        hibernateTemplate.update(user);
    }

    @SuppressWarnings("unchecked")
    public List<User> findAllUsers() {
        return hibernateTemplate.find("from User");
    }

    public User findUserByEmail(String email) {
        List<User> userList =  hibernateTemplate.find("from User where email = ?", email);
        if (userList != null && userList.size() > 0) {
            return userList.get(0);
        }
        return null;
    }
}
