package ru.gb.ex01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.ex01.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
