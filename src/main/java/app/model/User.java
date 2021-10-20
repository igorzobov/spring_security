package app.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "placeholder for name is empty")
    @Size(min=2, max=30, message = "name should be between 2 and 20 characters")
    @Column(name = "name")
    private String name;

    @Min(value = 0, message = "age should be greater than 0")
    @Max(value = 200, message = "are you afigel?")
    @Column(name = "age")
    private int age;

    @NotEmpty(message = "placeholder for email is empty")
    @Email(message = "email is not correct")
    @Column(name = "email")
    private String email;

    public User() {}

    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
