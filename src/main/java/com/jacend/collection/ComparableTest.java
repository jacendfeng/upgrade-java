package com.jacend.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparableTest {

    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setScore(89);

        Student student2 = new Student();
        student2.setScore(93);

        Student student3 = new Student();
        student2.setScore(67);

        Student[] stus = new Student[] {student1, student2, student3};
        Arrays.sort(stus);

        for (Student student : stus) {
            System.out.println(student.getScore());
        }

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        Collections.sort(studentList);

        System.out.println(studentList);
    }
}
