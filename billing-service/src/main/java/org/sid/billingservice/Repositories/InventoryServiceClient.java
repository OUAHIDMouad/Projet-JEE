package org.sid.billingservice.Repositories;

import org.sid.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service")
public interface InventoryServiceClient {
    @GetMapping("/products/{id}?projection=fullCustomer")
    Product findCustomerById(@PathVariable("id") Long id);
    @GetMapping("/products?projection=fullCustomer")
    PagedModel<Product> findAll();
}
