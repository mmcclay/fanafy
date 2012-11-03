package service;

import dao.user.UserDao;
import model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * User Service repository
 */
@Service(value = "userService")
public class UserService {

    @Resource
    UserDao userDao;

    public void create(User user) {
        userDao.create(user);
    }
    
    public void update(User user) {
        userDao.update(user);
    }

    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }

    public User findUserByEmail(String email) {
        return userDao.findUserByEmail(email);
    }
    
}
