package app.web.pavelk.note2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Note2 {

	public static void main(String[] args) {
		SpringApplication.run(Note2.class, args);
	}

}
