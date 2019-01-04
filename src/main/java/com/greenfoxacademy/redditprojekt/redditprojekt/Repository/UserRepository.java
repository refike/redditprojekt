package com.greenfoxacademy.redditprojekt.redditprojekt.Repository;

import com.greenfoxacademy.redditprojekt.redditprojekt.Repository.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
