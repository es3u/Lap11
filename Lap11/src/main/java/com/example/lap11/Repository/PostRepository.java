package com.example.lap11.Repository;
import com.example.lap11.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {


    Post findPostById(Integer postId);
//
    @Query("select i from Post i where i.userId = ?1")
    List<Post> findPostByUser_id(Integer userId);

    @Query("select a from Post a where a.publishDate = ?1")
    List<Post> findPostByPublish_date(LocalDate date);


    @Query("select b from Post b where b.category_id = ?1")
    List<Post> findPostByCategory(Integer category);

    Post findPostByTitleAndUserId(String title , Integer userId);

    @Query("select c from Post c where c.publishDate BETWEEN ?1 and ?2")
    List<Post> findPostByPublishDateBetween(LocalDate start, LocalDate end);







    




}
