package com.between.repositories;

import com.between.entities.Price;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public interface IPriceRepository extends CrudRepository<Price, Long> {

    Optional<Price> findTopByAndProductIdAndBrandIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
            long productId,
            long brandId,
            LocalDateTime applicationDate1,
            LocalDateTime applicationDate2);
}

