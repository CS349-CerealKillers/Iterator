package com.benjamindaschel.iterator;

import java.util.Iterator;

/**
 * Created by Benjamin Daschel on 5/7/15.
 * Design a simple class called Course that contains a list of Students
 */

public class Course implements Iterable<Student> {

    Student[] mEnrolledStudents;
    private int mInsertCursor;

    public class CourseIterator implements Iterator<Student>{

        private int mCursor;

        @Override
        public boolean hasNext() {
            return mCursor < mEnrolledStudents.length;
        }

        @Override
        public Student next() {
            Student student = mEnrolledStudents[mCursor];
            mCursor++;
            return student;
        }

        @Override
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

    public Course(int maxEnrollment) {
        if(maxEnrollment < 1){
            throw new RuntimeException("Max enrollment must be positive");
        }
        mEnrolledStudents = new Student[maxEnrollment];
    }

    @Override
    public Iterator<Student> iterator() {
        return new CourseIterator();
    }

    public final void enrollStudent(Student newStudent){
        if(mInsertCursor >= mEnrolledStudents.length){
            throw new RuntimeException("Cannot enroll any more students.");
        }
        mEnrolledStudents[mInsertCursor++] = newStudent;
    }

    public final void removeStudent(Student removeStudent){
        for(int i = 0; i < mEnrolledStudents.length; i++){
            if (mEnrolledStudents[i].equals(removeStudent)){
                mEnrolledStudents[i] = null;
                collapseArray();
                return;
            }
        }
    }

    public final int getClassSize(){
        return mInsertCursor;
    }

    public final int getMaxEnrollment(){
        return mEnrolledStudents.length;
    }

    private void collapseArray() {
        int offset = 0;
        for (int i = 0; i < mEnrolledStudents.length; i++){
            if(mEnrolledStudents[i] == null){
                offset++;
            }else{
                mEnrolledStudents[i - offset] = mEnrolledStudents[i];
                mEnrolledStudents[i] = null;
            }
        }
        mInsertCursor = mEnrolledStudents.length - offset;
    }

}
