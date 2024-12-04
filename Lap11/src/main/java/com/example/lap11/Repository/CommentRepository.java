package com.example.lap11.Repository;

import com.example.lap11.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    Comment findCommentById(Integer id);


    List<Comment> findCommentByUId(Integer id);

    @Query("select a from Comment a where a.uId=?1 and a.postId=?2 and a.commentDate=?3")
    Comment findCommentByUIdAndPostIdAndCommentDate(Integer id, Integer postId, LocalDate date);


}
