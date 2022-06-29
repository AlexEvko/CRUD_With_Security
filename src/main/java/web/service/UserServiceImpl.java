//package web.service;
//
//import org.springframework.transaction.annotation.Transactional;
//import web.dao.UserDao;
//import web.model.User;
//
//import java.util.List;
//
//public class UserServiceImpl implements UserService{
//    private final UserDao userDao;
//
//    public UserServiceImpl(UserDao userDao) {
//        this.userDao = userDao;
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public User getUserByName(String name) {
//        return userDao.getUserByName(name);
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public List<User> getAll() {
//        return userDao.getAll();
//    }
//
//    @Override
//    @Transactional
//    public void saveUser(User user) {
//        userDao.saveUser(user);
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public User getById(Long id) {
//        return userDao.getById(id);
//    }
//
//    @Override
//    @Transactional
//    public void deleteById(Long id) {
//        userDao.deleteById(id);
//    }
//
//    @Override
//    public void update(User user) {
//        userDao.update(user);
//    }
//}
//
