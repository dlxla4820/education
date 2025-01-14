package study.education;

import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.jupiter.api.Test;

class JasyptTest {

	@Test
	void testEncryption() {
		BasicTextEncryptor encryptor = new BasicTextEncryptor();
		encryptor.setPassword("garim_best");

		String originalPassword = "testPassword";
		String encryptedPassword = encryptor.encrypt(originalPassword);
		String decryptedPassword = encryptor.decrypt(encryptedPassword);

		assert originalPassword.equals(decryptedPassword);
	}
}
