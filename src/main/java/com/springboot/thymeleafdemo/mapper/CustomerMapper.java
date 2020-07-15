package com.springboot.thymeleafdemo.mapper;

import com.springboot.thymeleafdemo.entity.Customer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CustomerMapper {
    @Select("SELECT * FROM customer WHERE username = #{userName}")
    Customer getCustomer(String username);

    @Insert("INSERT INTO customer(first_name, last_name,phone_number ,email,username,password,salt) VALUES (#{firstName},#{lastName},#{phoneNumber},#{email},#{userName},#{password},#{salt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Customer customer);

}


