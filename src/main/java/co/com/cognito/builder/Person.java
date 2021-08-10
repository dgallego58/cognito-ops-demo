package co.com.cognito.builder;

import java.util.Objects;
import java.util.function.Consumer;

public class Person {

    final String username;
    final String email;
    final String path;

    private <T> Person(PersonBuilder<T> builder) {
        this.username = builder.username;
        this.email = builder.email;
        this.path = builder.path;
    }

    public static <T> PersonBuilder<T> builder() {
        return new PersonBuilder<>();
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "Person{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", path='" + path + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return username.equals(person.username) && email.equals(person.email) && path.equals(person.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, email, path);
    }

    public static class PersonBuilder<T> {
        public String username;
        public String email;
        public String path;

        public PersonBuilder<T> with(Consumer<T> builderFun) {
            builderFun.accept((T) this);
            return this;
        }


        public Person build() {
            return new Person(this);
        }

    }
}
