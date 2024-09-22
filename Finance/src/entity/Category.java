package entity;

import javax.persistence.*;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CategoryId;

    @Column(name = "CategoryDescription")
    private String CategoryDescription;

    public Category() {
    }

    public Category(String categoryDescription) {
        CategoryDescription = categoryDescription;
    }

    public Long getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(Long categoryId) {
        CategoryId = categoryId;
    }

    public String getCategoryDescription() {
        return CategoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        CategoryDescription = categoryDescription;
    }


}
