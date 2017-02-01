package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private int age;
    private String name;
    private List<Student> students = new ArrayList<>();

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Student> getStudents()
    {
        return students;
    }

    public void setStudents(List<Student> students)
    {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for (Student student : students)
        {
            if (student.getAverageGrade() == averageGrade)
            {
                return student;
            }
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        if (students.isEmpty()) return null;

        double maxGrade = students.get(0).getAverageGrade();
        int indexMax = 0;
        for (int i = 0; i < students.size(); i++)
        {
            if (students.get(i).getAverageGrade() >= maxGrade){
                maxGrade = students.get(i).getAverageGrade();
                indexMax = i;
            }
        }
        return students.get(indexMax);
    }

    public Student getStudentWithMinAverageGrade() {
        if (students.isEmpty()) return null;

        double minGrade = students.get(0).getAverageGrade();
        int indexMin = 0;
        for (int i = 0; i < students.size(); i++)
        {
            if (students.get(i).getAverageGrade() <= minGrade){
                minGrade = students.get(i).getAverageGrade();
                indexMin = i;
            }
        }
        return students.get(indexMin);
    }

    public void expel(Student student) {
        students.remove(student);
    }
}
