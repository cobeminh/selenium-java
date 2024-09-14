package theinternet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TC05_TableTest {
    /**
     * `[
     * {
     * "name": "Luke Skywalker",
     * "height": "172",
     * "mass": "77",
     * "hair_color": "blond",
     * "skin_color": "fair",
     * "eye_color": "blue",
     * "birth_year": "19BBY",
     * "gender": "male"
     * },
     * {
     * "name": "Darth Vader",
     * "height": "202",
     * "mass": "136",
     * "hair_color": "none",
     * "skin_color": "white",
     * "eye_color": "yellow",
     * "birth_year": "41.9BBY",
     * "gender": "male"
     * },
     * {
     * "name": "Leia Organa",
     * "height": "150",
     * "mass": "49",
     * "hair_color": "brown",
     * "skin_color": "light",
     * "eye_color": "brown",
     * "birth_year": "19BBY",
     * "gender": "female"
     * },
     * {
     * "name": "Owen Lars",
     * "height": "178",
     * "mass": "120",
     * "hair_color": "brown, grey",
     * "skin_color": "light",
     * "eye_color": "blue",
     * "birth_year": "52BBY",
     * "gender": "male"
     * },
     * {
     * "name": "Beru Whitesun lars",
     * "height": "165",
     * "mass": "75",
     * "hair_color": "brown",
     * "skin_color": "light",
     * "eye_color": "blue",
     * "birth_year": "47BBY",
     * "gender": "female"
     * },
     * {
     * "name": "Biggs Darklighter",
     * "height": "183",
     * "mass": "84",
     * "hair_color": "black",
     * "skin_color": "light",
     * "eye_color": "brown",
     * "birth_year": "24BBY",
     * "gender": "male"
     * },
     * {
     * "name": "Obi-Wan Kenobi",
     * "height": "182",
     * "mass": "77",
     * "hair_color": "auburn, white",
     * "skin_color": "fair",
     * "eye_color": "blue-gray",
     * "birth-year": "57BBY",
     * "gender": "male"
     * }
     * ]
     * ==>LIST<{
     * "name": "string",
     * "height": "182",
     * "mass": "77",
     * "hair_color": "string",
     * "skin_color": "string",
     * "eye_color": "string",
     * "birth-year": "string",
     * "gender": "mastringle"
     * }>
     * Instance <></> Object vs Class
     */
    public static void main(String[] args) {
        List<PersonsForTableTest> persons = new ArrayList<PersonsForTableTest>();
        persons.add(new PersonsForTableTest("Luke Skywalke", 172, 77, "blond", "fair", "blue", "19BBY", "female"));
        persons.add(new PersonsForTableTest("Darth Vader", 202, 136, "none", "white", "yellow", "41.9BBY", "male"));
        persons.add(new PersonsForTableTest("Beru Whitesun lars", 165, 75, "brown", "light", "blue", "47BBY", "female"));
        persons.add(new PersonsForTableTest("Biggs Darklighter", 183, 84, "black", "light", "brown", "24BBY", "female"));
        persons.add(new PersonsForTableTest("Obi-Wan Kenobi", 182, 77, "auburn, white", "fair", "blue-gray", "57BBY", "male"));

        //print person height>170
        List<PersonsForTableTest> persons1 = persons
                .stream()
                .filter(p -> (p.getHeight() > 170 && Objects.equals(p.getGender(), "female")))
                .toList();

        //SUM MASS
        int totalmass = persons.stream().mapToInt(PersonsForTableTest::getMass).sum();
        System.out.println(totalmass);

        //GET NAME
        List<String> name = persons.stream().map(PersonsForTableTest::getName).toList();
        System.out.println(name);

        //print list
        persons.forEach(PersonsForTableTest::info);
    }
}
