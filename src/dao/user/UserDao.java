package dao.user;

import model.User;

import java.util.List;

/**
 * UserDao
 */
public interface UserDao {
    
    public void create(User user);
    
    public void update(User user);
    
    public List<User> findAllUsers();

    public User findUserByEmail(String email);
}
