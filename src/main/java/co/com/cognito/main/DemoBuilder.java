package co.com.cognito.main;

import co.com.cognito.builder.Dog;
import co.com.cognito.builder.GenericBuilder;
import co.com.cognito.builder.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.Consumer;

public class DemoBuilder {


    public static Consumer<Object> printerConsumer = arg -> System.out.println(arg.toString());

    public static void main(String[] args) {

        var person = Person.<Person.PersonBuilder>builder()
                .with(p -> {
                    p.email = "dgallego58@uan.edu.co";
                    p.path = "/path/to/class";
                    p.username = "dgallego58";
                }).build();
        printerConsumer.accept(person);

        var animal = GenericBuilder.buildFor(Dog.class)
                .with(dog -> dog.setName("Carlos"))
                .with(dog -> dog.setBirthDate(LocalDate.parse("2020-01-15", DateTimeFormatter.ofPattern("yyyy-MM-dd"))))
                .with(dog -> dog.setRace("San Bernardo"))
                .get();

        printerConsumer.accept(animal);

    }
}
