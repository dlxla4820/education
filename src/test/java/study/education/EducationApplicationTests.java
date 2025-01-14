package study.education;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import study.education.service.LoginService;

class EducationApplicationTests {

	@Mock
	private LoginService loginService;

	@InjectMocks
	private EducationApplicationTests applicationTests;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void contextLoads() {
		// Test logic goes here (if needed)
	}
}
