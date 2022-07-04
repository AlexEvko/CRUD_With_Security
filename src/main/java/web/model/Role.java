package web.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Role")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade ={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy = "roles")
    private Set<User> users;

    public Role(Long id, String name, Set<User> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public Role() {
    }

    @Override
    public String getAuthority() {
        return getName();
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Set<User> getUsers() {
        return this.users;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Role;
    }

    public String toString() {
        return this.getName();
    }
}
