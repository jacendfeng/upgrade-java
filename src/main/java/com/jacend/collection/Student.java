package com.jacend.collection;

public class Student implements Comparable<Student> {

    private int score;

    @Override
    public int compareTo(Student o) {
        return this.score - o.score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "score=" + score +
                '}';
    }
}
