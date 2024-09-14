package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import theinternet.Person;

import java.util.List;
import java.util.OptionalDouble;

import static supports.Browser.all;
import static supports.Browser.visit;

public class TC05_WebTablesPage {
    private List<Person> people;
    private By lastName = By.xpath("//table[@id='table1']/tbody/tr");
    public void open() {
        visit("https://the-internet.herokuapp.com/tables");
    }

    public void getTable() {
        people = all(lastName)
                .stream()
                .map(WebElement::getText)
                .map(rowContent -> rowContent.split(" ")).map(cellContent -> new Person(cellContent[1], cellContent[0], cellContent[3]))
                .toList();
    }

    public List<Person> getMaxDuePerson() {
        OptionalDouble maxDue = people.stream().mapToDouble(Person::getDue).max();
        return people.stream().filter(p -> p.getDue() == maxDue.getAsDouble()).toList();
    }

    public List<Person> getMinDuePerson() {
        OptionalDouble minDue = people.stream().mapToDouble(Person::getDue).min();
        return people.stream().filter(p -> p.getDue() == minDue.getAsDouble()).toList();
    }
}
