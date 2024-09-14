package theinternet;

public class Person {
    private String lastname;
    private String firstname;
    private String due;

    public Person(String lastname, String firstname, String due) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.due = due;
    }

    public String getFullname() {
        return String.format("%s %s", firstname, lastname);
    }

    public float getDue() {
        return Float.valueOf(due.replace("$", ""));
    }
}
