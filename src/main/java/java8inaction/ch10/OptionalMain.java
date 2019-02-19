package java8inaction.ch10;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class OptionalMain {

    public String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar)
                     .flatMap(Car::getInsurance)
                     .map(Insurance::getName)
                     .orElse("Unknown");
    }

    public Set<String> getCarInsuranceNames(List<Person> persons) {
         persons.stream()
                      .map(Person::getCar)
                      .map(optCar -> optCar.flatMap(Car::getInsurance))
                      .map(optInsurance -> optInsurance.map(Insurance::getName))
                      .map(Optional::get);

        return null;
    }

    public static void main(String[] args) {
        OptionalMain om = new OptionalMain();
        Person p1 = new Person();
        Person p2 = new Person();
        List<Person> lp = new ArrayList<>();
        lp.add(p1);
        lp.add(p2);

    }
}
