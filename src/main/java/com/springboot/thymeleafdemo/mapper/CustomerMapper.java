package com.springboot.thymeleafdemo.mapper;

import com.springboot.thymeleafdemo.entity.Customer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CustomerMapper {
    @Select("SELECT * FROM customer_db WHERE username = #{username}")
    Customer getCustomer(String username);

    @Insert("INSERT INTO customer_db(first_Name, last_Name,phoneNumber ,email,user_name,password,salt) VALUES (#{firstname},#{lastname},#{phonenumber},#{email},#{username},#{password},#{salt})")
    @Options(useGeneratedKeys = true, keyProperty = "Id")
    int insert(Customer customer);

}


