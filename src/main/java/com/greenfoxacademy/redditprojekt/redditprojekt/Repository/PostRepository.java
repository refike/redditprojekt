package com.greenfoxacademy.redditprojekt.redditprojekt.Repository;

import com.greenfoxacademy.redditprojekt.redditprojekt.Repository.Model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post,Long> {
     List<Post> findAllByOrderByScoreDesc ();
}
