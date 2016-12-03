package springscrath.core.model.entities;

import com.fasterxml.jackson.annotation.JsonView;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.context.annotation.Bean;

@Entity
@Table(name = "users")

public class User {

    public interface WithoutName {
    };

    public interface WithName extends WithoutName {
    };

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min = 3, max = 80)
    private String email;

    @NotNull
    @Size(min = 2, max = 80)
    private String name;

    public User() {
    }

    public User(long id) {
        this.id = id;
    }

    public User(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public User(String email, String name, long id) {
        this.email = email;
        this.name = name;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long value) {
        this.id = value;
    }

    @JsonView(WithoutName.class)
    public String getEmail() {
        return email;
    }

    public void setEmail(String value) {
        this.email = value;
    }

    @JsonView(WithName.class)
    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

} // class User
