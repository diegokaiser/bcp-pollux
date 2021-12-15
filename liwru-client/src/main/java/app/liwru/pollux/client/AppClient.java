package app.liwru.pollux.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import app.liwru.pollux.client.security.JWTAuthorizationFilter;

@SpringBootApplication
public class AppClient {
    public static void main(String[] args) {
        SpringApplication.run(AppClient.class, args);
    }
}
