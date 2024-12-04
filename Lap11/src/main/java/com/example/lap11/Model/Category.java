package com.example.lap11.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @NotEmpty(message = "category name can be not Empty")
    @Column(unique = true, columnDefinition = "varchar(15)")
//    @Size(min = 4 , max = 15)
    private String categoryName;

    public Category() {
    }

    public Integer getCategoryId() {
        return id;
    }

    public void setCategoryId(Integer categoryId) {
        this.id = categoryId;
    }

    public @NotEmpty(message = "category name can be not Empty") @Size(min = 4, max = 15) String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(@NotEmpty(message = "category name can be not Empty") @Size(min = 4, max = 15) String categoryName) {
        this.categoryName = categoryName;
    }
}
