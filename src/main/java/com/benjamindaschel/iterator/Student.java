package com.benjamindaschel.iterator;

/**
 * Created by Benjamin Daschel on 5/7/15.
 */
public class Student {

    String mName;
    public Student(String name) {
        this.mName = name;
    }

    @Override
    public String toString() {
        return mName;
    }

    @Override
    public boolean equals(Object other){
        if(this.getClass().equals(other.getClass())){
            Student s = (Student)other;
            if(s.mName.equals(this.mName)){
                return true;
            }
        }
        return false;
    }
}
