package com.skillassure.wastebox.repository.ewaste.products;

/**
 * @author Raghavendra
 *
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillassure.wastebox.model.ewaste.product.Product;


/**
 * ProductRepository for fetching all product details.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
