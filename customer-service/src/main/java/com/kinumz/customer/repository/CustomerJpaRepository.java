package com.kinumz.customer.repository;

import com.kinumz.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event.ID;

public interface CustomerJpaRepository extends JpaRepository<Customer, ID> {

}
