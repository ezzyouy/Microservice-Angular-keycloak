package org.sid.customerservice;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(CustomerRepository cr,
                                               @Autowired(required = false) RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Customer.class);
            cr.saveAll(
                    List.of(
                            Customer.builder().name("aymen").email("aymen@hotmail.com").build(),
                            Customer.builder().name("yassine").email("yassin@hotmail.com").build(),
                            Customer.builder().name("said").email("said@hotmail.com").build()
                    )
            );
            cr.findAll().forEach(customer -> {
                System.out.println(customer  );
            });
        };
    }

}
