package study.education.service;

import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.education.entity.User;
import study.education.repository.UserRepository;

import java.util.UUID;

@Service
public class LoginService {

	@Autowired
	private UserRepository userRepository;

	private final BasicTextEncryptor encryptor = new BasicTextEncryptor();

	public LoginService() {
		encryptor.setPassword("garim_best");
	}

	public User register(User user) {
		user.setUuid(UUID.randomUUID().toString());
		user.setPassword(encryptor.encrypt(user.getPassword()));
		return userRepository.save(user);
	}

	public User login(String email, String password) {
		return userRepository.findByEmail(email)
				.filter(user -> encryptor.decrypt(user.getPassword()).equals(password))
				.orElse(null);
	}
}
