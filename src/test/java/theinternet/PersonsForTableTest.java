package theinternet;

public class PersonsForTableTest {

    private String name;
    private int height;
    private int mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;

    public PersonsForTableTest(String name, int height, int mass, String hairColor, String skinColor, String eyeColor, String birthYear, String gender) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.hairColor = hairColor;
        this.skinColor = skinColor;
        this.eyeColor = eyeColor;
        this.birthYear = birthYear;
        this.gender = gender;
    }

    public void info() {
        System.out.println("_________________");
        System.out.printf("name: %s\n", this.name);
        System.out.printf("height: %d\n", this.height);
        System.out.printf("mass: %d\n", this.mass);
        System.out.printf("hairColor: %s\n", this.hairColor);
        System.out.printf("skinColor: %s\n", this.skinColor);
        System.out.printf("eyeColor: %s\n", this.eyeColor);
        System.out.printf("birthYear: %s\n", this.birthYear);
        System.out.printf("gender: %s\n", this.gender);
    }

    public String getName() {
        return name;
    }

    public int getMass() {
        return mass;
    }

    public String getHairColor() {
        return hairColor;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public String getGender() {
        return gender;
    }

    //tao getter khi thuoc tinh cua minh la private
    //Tao setter khi thuoc tinh la public, private k set dc
    public int getHeight() {
        return height;
    }

}
