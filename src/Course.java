/**
 * Created by jharshman on 5/8/15.
 */

import java.util.Iterator;
public class Course implements Iterable<Student> {

    Student [] _enrolledStudents;
    private int _insertCur;

    /**
     * Iterator Implementation
     * */
    public class CourseIterator implements Iterator<Student> {

        private int _cur;

        @Override
        public boolean hasNext() {
            return _cur < _enrolledStudents.length;
        }

        @Override
        public Student next() {
            Student student = _enrolledStudents[_cur++];
            return student;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    public Course(int maxStudents) {
        if(maxStudents < 1) {
            throw new RuntimeException("Cannot have negative number of students");
        }
        _enrolledStudents = new Student[maxStudents];
    }

    public final void enroll(Student student) {
        if(_insertCur >= _enrolledStudents.length) {
            throw new RuntimeException("No more room in class");
        }
        _enrolledStudents[_insertCur++] = student;
    }

    public final void remove(Student student) {
        for(int i = 0; i < _enrolledStudents.length; i++) {
            if(_enrolledStudents[i].equals(student)) {
                _enrolledStudents[i] = null;
                destroy();
                return;
            }
        }
    }

    public final int getCurrentSize() {
        return _insertCur;
    }
    public final int getMaxEnrolled() {
        return _enrolledStudents.length;
    }

    public void  destroy() {
        int offBy = 0;
        for(int i = 0; i < _enrolledStudents.length; i++) {
            if(_enrolledStudents[i] == null) {
                offBy++;
            }
            else {
                _enrolledStudents[i - offBy] = _enrolledStudents[i];
                _enrolledStudents[i] = null;
            }
        }
        _insertCur = _enrolledStudents.length - offBy;
    }

    @Override
    public Iterator<Student> iterator() {
        return new CourseIterator();
    }

}
