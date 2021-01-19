package ae.task.ecomperceappbe.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ae.task.ecomperceappbe.daos.UserRepository;
import ae.task.ecomperceappbe.models.User;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User save(User user) {
		
        return userRepository.save(user);
    }
	@Override
	public Optional<User> findByUserId(Long id) {
		return userRepository.findById(id);
	}
}
