package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.users;
import org.springframework.stereotype.Repository;


@Repository
public interface IusersRepository  extends JpaRepository<users, Long>{


    users findByEmail(String email);
}
