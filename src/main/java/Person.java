import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;

    public Person(PersonBuilder personBuilder) {
        if (personBuilder == null) {
            throw new IllegalStateException("Пожалуйста проверьте создание объекта билдера");
        }
        this.name = personBuilder.name;
        this.surname = personBuilder.surname;
        this.age = personBuilder.age;
        this.address = personBuilder.address;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder person = new PersonBuilder();
        OptionalInt x = getAge();
        int age = x.getAsInt();
        return person.setSurname(getSurname()).setAddress(getAddress()).setAge(age - 18);
    }

    public void setAge(int age) {
        this.age = age;
    }


    public boolean hasAge() {

        return age != 0;
    }

    public boolean hasAddress() {

        return address != null;
    }

    public String getName() {

        return name;
    }

    public String getSurname() {

        return surname;
    }

    public OptionalInt getAge() {
        if (hasAge()) {
            return OptionalInt.of(age);
        } else {
            return OptionalInt.empty();
        }
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        age++;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}