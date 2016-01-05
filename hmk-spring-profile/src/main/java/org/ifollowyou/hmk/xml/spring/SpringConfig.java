package org.ifollowyou.hmk.xml.spring;

import org.ifollowyou.hmk.vo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Profile("development")
public class SpringConfig {

    @Bean
    public Person person() {
        return new Person();
    }
}
