package ru.bootcamp.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue
    private long id;
    @Column(unique = true, length = 100)
    private String role;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    protected Role() {
    }

    public Role(String name) {
        role = name;
    }

    @Override
    public String getAuthority() {
        return getRole();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return this.role.equals(role.role);
    }

    @Override
    public String toString() {
        return role;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + role.hashCode();
        return result;
    }
}

