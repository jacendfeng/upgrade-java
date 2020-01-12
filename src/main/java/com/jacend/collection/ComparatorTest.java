package com.jacend.collection;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {

    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setScore(89);

        Student student2 = new Student();
        student2.setScore(93);

        Student student3 = new Student();
        student2.setScore(67);

        Student[] stus = new Student[] {student1, student2, student3};


        Arrays.sort(stus, new StuComparator());
        for (Student student : stus) {
            System.out.println(student.getScore());
        }
    }

    static class StuComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.getScore() - o2.getScore();
        }
    }
}
