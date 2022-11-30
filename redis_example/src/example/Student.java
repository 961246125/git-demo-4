package example;

import java.util.Objects;

public class Student {

    private String name;

    private String number;

    public Student(String name, String number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name,student.name) && Objects.equals(number, student.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
