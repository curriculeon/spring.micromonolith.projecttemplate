package com.github.curriculeon;

import com.github.curriculeon.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

/**
 * Created by leon on 1/30/2020.
 */
@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean(name = "default-person")
    public Person defaultPersonToBeCreatedWhenApplicaitonStarts() {
        return new Person();
    }
}
