package com.example.repository.permission;

import com.example.dto_interface.IUserDto;
import com.example.model.permission.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, String> {

    @Query(value = "select `name` as userName , `password` from `user` where `name` like :userName", nativeQuery = true)
    List<IUserDto> findUserName(@Param("userName") String username);
}
