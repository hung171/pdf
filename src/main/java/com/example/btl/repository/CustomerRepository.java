package com.example.btl.repository;

import com.example.btl.model.dto.CusView;
import com.example.btl.model.dto.CustomerService;
import com.example.btl.model.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "SELECT c.id as id, c.name as name, c.address as address, c.cccd as cccd, s.numWater as " +
            "numWater, c.email as email, s.volume as volume, c.phoneNumber as phoneNumber, c.status as status, c.created as created, " +
            "CASE WHEN s.volume <=10 " +
            "THEN 6.869 WHEN s.volume <=20 AND s.volume>10 THEN 8.11 \n" +
            "WHEN s.volume <=30 AND s.volume>20 THEN 9.969 \n" +
            "ELSE 18.318 END AS price \n" +
            "FROM Customer c \n" +
            "JOIN Service s on c.id= s.id where c.id= ?1")
    CusView findCustomerServiceI(@Param("id") int id);

    @Query(value = "SELECT c.id as id, c.name as name, c.address as address, c.cccd as cccd, s.numWater as " +
            "numWater, c.email as email, s.volume as volume, c.phoneNumber as phoneNumber, c.statusC as statusC, c.created as created, " +
            "CASE WHEN s.volume <=10 " +
            "THEN 6.869 WHEN s.volume <=20 AND s.volume>10 THEN 8.11 \n" +
            "WHEN s.volume <=30 AND s.volume>20 THEN 9.969 \n" +
            "ELSE 18.318 END AS price \n" +
            "FROM Customer c \n" +
            "JOIN Service s on c.id= s.id where c.statusC= '1' or c.statusC= '2'")
    List<CusView> findAllByStatus();
}
