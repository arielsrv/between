package com.between.repositories;

import com.between.entities.Price;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public interface IPriceRepository extends CrudRepository<Price, Long> {

	@Query(nativeQuery = true, value =
		"select * from prices price " +
			"where price.product_id = :productId " +
			"and price.brand_id = :brandId " +
			"and price.start_date < :applicationDate and price.end_date > :applicationDate " +
			"order by price.priority desc limit 1"
	)
	Optional<Price> getPriceByApplicationDate(long productId, long brandId, LocalDateTime applicationDate);
}

