import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class JasyptTest implements CommandLineRunner {

	@Autowired
	private StringEncryptor encryptor;

	@Override
	public void run(String... args) throws Exception {
		String username = "securityfirst";
		String password = "@securityfirst@12 7+M8fdG5rAhphAhFJMtOMhNMbYFKz6hisHnA5QE8r";

		System.out.println("Encrypted username: " + encryptor.encrypt(username));
		System.out.println("Encrypted password: " + encryptor.encrypt(password));
	}
}
