package fr.uge.jee.springmvc.reststudents;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

/*public class Student {

    @JsonIgnore
    private long uid;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("first_name")
    private String firstName;

    public Student() {}

    public Student(long uid, String lastName, String firstName) {
        this.uid = uid;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public void setUid(long uid){
        this.uid = uid;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonIgnore
    public long getUid() {
        return uid;
    }

    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return "Student{" +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}*/
