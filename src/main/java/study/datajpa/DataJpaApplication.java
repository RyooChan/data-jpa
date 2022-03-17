package study.datajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;
import java.util.UUID;

@EnableJpaAuditing		// Auditing을 위함(createDate, updateDate)
@SpringBootApplication
public class DataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataJpaApplication.class, args);
	}

	@Bean
	public AuditorAware<String> auditorProvider(){
		// 해당 내용은 랜덤아이디를 생성하고, 실무에서는 security 등에서 꺼내온 userid를 넣어주면 된다.
		return () -> Optional.of(UUID.randomUUID().toString());
	}
}
