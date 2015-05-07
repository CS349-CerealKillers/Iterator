import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Tyler Herrin on 5/7/2015.
 */
public class Course implements Iterable<Student>
{
    private class CourseIterator implements Iterator<Student>
    {
        private int currentIndex, endIndex;
        private boolean nextCalled;
        private ArrayList<Student> students;

        public CourseIterator(ArrayList<Student> students)
        {
            this.students = students;
            this.currentIndex = 0;
            this.endIndex = this.students.size() - 1;
        }

        public boolean hasNext()
        {
            return this.currentIndex <= this.endIndex;
        }

        public Student next()
        {
            if(this.hasNext())
            {
                Student student = this.students.get(currentIndex);
                currentIndex++;
                nextCalled = true;
                return student;
            }
            throw new NoSuchElementException();
        }

        public void remove()
        {
            if(nextCalled)
            {
                this.students.remove(currentIndex - 1);
                this.endIndex--;
                this.currentIndex--;
                this.nextCalled = false;
            }
            else
            {
                throw new UnsupportedOperationException("Next has not been called or remove has already been called previously.");
            }
        }
    }

    private ArrayList<Student> students;

    public Course(ArrayList<Student> students)
    {
        this.students = students;
    }

    public Iterator<Student> iterator()
    {
        return new CourseIterator(this.students);
    }
}
