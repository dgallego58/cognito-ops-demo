package co.com.cognito.builder;

import java.time.LocalDate;
import java.util.Objects;

public class Dog {

    private String race;
    private String name;
    private LocalDate birthDate;

    public Dog() {
        //javabean
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Dog dog = (Dog) o;
        return Objects.equals(getRace(), dog.getRace()) && Objects.equals(getName(), dog.getName()) && Objects.equals(getBirthDate(), dog.getBirthDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRace(), getName(), getBirthDate());
    }

    @Override
    public String toString() {
        return "Dog{" +
                "race='" + race + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    public String getRace() {
        return race;
    }

    public Dog setRace(String race) {
        this.race = race;
        return this;
    }

    public String getName() {
        return name;
    }

    public Dog setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Dog setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }
}
