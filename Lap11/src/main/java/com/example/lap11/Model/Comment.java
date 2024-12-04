package com.example.lap11.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
public class Comment {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer  comment_id ;

// @NotNull(message = "user id can not be null")
 @Column(columnDefinition = "int not null")
 private Integer uId;
// @NotNull(message = "post id can not be null")
 @Column(columnDefinition = "int not null")
 private Integer postId;
// @NotEmpty(message = "comment can not be empty ")
 @Column(columnDefinition = "varchar(100) not null")
// @Size(min = 4, max = 100)
  private String  comment;

    @Column(columnDefinition = "datetime")
   private LocalDateTime commentDate;

 public Comment() {
 }

 public Integer getComment_id() {
  return comment_id;
 }

 public void setComment_id(Integer comment_id) {
  this.comment_id = comment_id;
 }

 public Integer getIUserd() {
  return uId;
 }

 public void setId( Integer id) {
  this.uId = id;
 }

 public Integer getPostId() {
  return postId;
 }

 public void setPostId(Integer post_id) {
  this.postId = post_id;
 }

 public  String getComment() {
  return comment;
 }

 public void setComment( String comment) {
  this.comment = comment;
 }

 public LocalDateTime getCommentDate() {
  return commentDate;
 }

 public void setCommentDate(LocalDateTime comment_date) {
  this.commentDate = comment_date;
 }
}
