package com.between.repositories;

import com.between.entities.Brand;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public interface IBrandRepository extends CrudRepository<Brand, Long> {

}
