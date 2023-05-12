package com.ligaaclabs.twitter.repository;

import com.ligaaclabs.twitter.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, UUID> {
    List<User> searchByUsernameOrLastnameOrFirstname(String username, String lastname, String firstname);
//    void createUser(User user);
//    boolean findByUsername(User user);
//
//    List<User> getAllUsers();
//
//    boolean search(String query);
//
//    List<User> getSearchUsers(String query);
//    User searchByUsername(String username);
//
//    void addPost(User user, Post post);
}
