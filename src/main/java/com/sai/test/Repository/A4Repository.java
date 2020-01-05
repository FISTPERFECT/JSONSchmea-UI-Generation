package com.sai.test.Repository;

import com.sai.test.model.A4List;
import org.springframework.data.repository.CrudRepository;

public interface A4Repository extends CrudRepository<A4List, Long> {

    A4List findByName(String name);

}