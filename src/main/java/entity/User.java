package entity;

public class User {
    private Person person_id;
    private String name;
    private String password;

    public User() {
    }

    public User(Person person_id, String name, String password) {
        this.person_id = person_id;
        this.name = name;
        this.password = password;
    }

    public Person getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Person person_id) {
        this.person_id = person_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "\nUser{" +
                "person_id=" + person_id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
