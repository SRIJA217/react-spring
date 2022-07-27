package service;

import java.util.List;

import Model.Role;
import Model.User;

public interface IUserService {

	List<User> findAllUsers();

	User saveUser(User user);

	User findByUsername(String b);

	User deleteUser(Long userId);

	User changeRole(Role newRole, String username);



	



}
