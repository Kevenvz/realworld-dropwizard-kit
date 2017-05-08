package io.realworld.conduit.auth;

import java.security.Principal;
import java.util.Objects;

public class UserPrincipal implements Principal {
    private final Integer id;
    private final String name;

    public UserPrincipal(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "UserPrincipal{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final UserPrincipal myUser = (UserPrincipal) o;
        return Objects.equals(id, myUser.id) &&
                Objects.equals(name, myUser.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
