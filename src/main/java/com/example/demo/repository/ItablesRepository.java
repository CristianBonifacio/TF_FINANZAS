package com.example.demo.repository;
import com.example.demo.entities.Tables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItablesRepository extends JpaRepository<Tables, Long>{

}
