package com.example.lap11.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


//    @NotNull(message = "category_id can not be null")
    @Column(columnDefinition = "int not null")
    private Integer category_id;


//    @NotEmpty(message = "title can not be null")
    @Column(columnDefinition = "varchar(100) not null")
//    @Size(max = 100)
    private String title;

//    @NotEmpty(message = "content can not be null")
    @Column(columnDefinition = "varchar(1000) not null")
//    @Size(max = 1000)
    private String content;

//    @NotNull(message = "user id can not be null")
    @Column(columnDefinition = "int not null")
    private Integer userId;

    @Column(columnDefinition = "datetime")
    private LocalDateTime publishDate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull(message = "category_id can not be null") Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(@NotNull(message = "category_id can not be null") Integer category_id) {
        this.category_id = category_id;
    }

    public @NotEmpty(message = "title can not be null") @Size(max = 100) String getTitle() {
        return title;
    }

    public void setTitle(@NotEmpty(message = "title can not be null") @Size(max = 100) String title) {
        this.title = title;
    }

    public @NotEmpty(message = "content can not be null") @Size(max = 1000) String getContent() {
        return content;
    }

    public void setContent(@NotEmpty(message = "content can not be null") @Size(max = 1000) String content) {
        this.content = content;
    }

    public @NotNull(message = "user id can not be null") Integer getUserId() {
        return userId;
    }

    public void setUserId(@NotNull(message = "user id can not be null") Integer user_id) {
        this.userId = user_id;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDateTime publish_date) {
        this.publishDate = publish_date;
    }
}
