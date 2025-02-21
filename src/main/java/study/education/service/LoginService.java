package study.education.service;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import study.education.dto.SignUpRequestDto;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.education.entity.User;
import study.education.repository.UserRepository;

import java.util.UUID;

@Service
public class LoginService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public LoginService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public void registerUser(SignUpRequestDto signUpRequestDto) {

//		User user = User.builder()
//				.(signUpRequestDto.getUsername())
//				.password(passwordEncoder.encode(signUpRequestDto.getPassword()))
//				.build();
//		userRepository.save(user);
	}



}