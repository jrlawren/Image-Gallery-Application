package edu.cmu.iccb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

//import java.security.Principal;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableOAuth2Sso
@RestController
public class Application extends WebSecurityConfigurerAdapter {

	/*
	@RequestMapping("/user")
	public Principal user(Principal principal) {
		return principal;
	}
	*/
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/**")
			.authorizeRequests()
			.antMatchers("/", "/login**", "/webjars/**","/github/success**","/css**", "/js**", "/fonts**")
			.permitAll()
			.anyRequest()
			.authenticated();
		
		http.csrf().disable();
	}
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /*
    @Bean
    CommandLineRunner init() {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {}
	    };
    }
    */
}

