public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age;
    protected String address;

    public PersonBuilder() {
        super();
    }

    public PersonBuilder setName(String name) {
       this.name = name;
        return this;
    }
    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }
    public PersonBuilder setAge(int age) {
        if(age<0 || age > 110){
            throw new IllegalArgumentException("Некорректный возраст");
        }
        this.age = age;
        return this;
    }
    public PersonBuilder setAddress(String address) {
       this.address = address;
       return this;
    }

    public Person build() {
        Person person = null;
        if (checkPerson()){
            person = new Person(this);
        }else {
            throw new IllegalStateException("Person не прошёл проверку на наличие имени и фамилии");
        }
        return person;
    }

    public boolean checkPerson(){
        return (name != null && !name.trim().isEmpty() && surname != null && !surname.trim().isEmpty());
    }

}