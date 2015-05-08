package com.benjamindaschel.iterator;

/**
 * Created by Benjamin Daschel on 5/7/15.
 */
public class Main {

    public static void main(String[] args) {

        Course course = new Course(30);

        for(int i = 0; i < course.getMaxEnrollment(); i++){
            course.enrollStudent(new Student("Student " + i));
        }

        for(Student s: course){
            System.out.println(s);
        }

        System.out.println(course.getClassSize());

        try {
            course.enrollStudent(new Student("This should throw an exception"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(int i = 0; i < course.getMaxEnrollment(); i++){
            course.removeStudent(new Student("Student " + i));
        }

        System.out.println("Course size: " + course.getClassSize());
    }
}
