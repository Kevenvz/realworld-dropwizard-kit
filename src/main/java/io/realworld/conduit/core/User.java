package io.realworld.conduit.core;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
@NamedQueries(
        {
                @NamedQuery(
                        name = "io.realworld.conduit.core.User.findAll",
                        query = "SELECT u FROM User u"
                )
        }
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "bio")
    private String bio;

    @Column(name = "image")
    private String image;

    public User() {
    }

    public User(String email, String username, String passwordHash, String bio, String image) {
        this.email = email;
        this.username = username;
        this.passwordHash = passwordHash;
        this.bio = bio;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }

        final User that = (User) o;

        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.email, that.email) &&
                Objects.equals(this.username, that.username) &&
                Objects.equals(this.passwordHash, that.passwordHash) &&
                Objects.equals(this.bio, that.bio) &&
                Objects.equals(this.image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, username, passwordHash, bio, image);
    }
}
