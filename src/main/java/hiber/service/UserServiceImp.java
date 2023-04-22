package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   private UserDao userDao;
   @Autowired
   public void setUserDao(UserDao userDao) {
      this.userDao = userDao;
   }

   @Override
   @Transactional
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }
   @Override
   @Transactional
   public User get(Long id) {
      return userDao.get(id);
   }

   @Override
   @Transactional
   public User getByCar(String model, int series) {
      return userDao.getByCar(model,series);
   }
}
