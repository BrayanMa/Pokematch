package fr.uge.jee.springmvc.pokematch.User;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;

public class User {
    @NotNull(message = "Cannot be empty")
    @Pattern(regexp = "^[A-Za-z]*$", message = "Invalid Input")
    @Pattern(regexp = "[\\S\\s]+\\S+", message = "Not empty")
    private String firstName;

    @NotNull(message = "Cannot be empty")
    @Pattern(regexp = "^[A-Za-z]*$", message = "Invalid Input")
    @Pattern(regexp = "[\\S\\s]+\\S+", message = "Not empty")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @ModelAttribute("user")
    public User user(){
        return new User();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
