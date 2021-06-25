package semestr2;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {
    private String name;
    private String surname;
    private String patronymic;
    private String date;
    public Person(){}

    public Person(String name, String surname, String patronymic, String date) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname) &&
                Objects.equals(patronymic, person.patronymic) &&
                Objects.equals(date, person.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, patronymic, date);
    }
}
