package lk.ijse.dep.pos.web;

import lk.ijse.dep.pos.web.JPAConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan("lk.ijse.dep.pos.web.api")
@Configuration
@EnableWebMvc
public class WebAppConfig {
}
