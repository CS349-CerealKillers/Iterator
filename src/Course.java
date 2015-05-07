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
        private boolean nextCalled = false;

        public CourseIterator(int endIndex)
        {
            this.currentIndex = 0;
            this.endIndex = endIndex;
        }

        public boolean hasNext()
        {
            if((this.currentIndex) <= this.endIndex)
                return true;
            else
                return false;
        }

        public Student next()
        {
            if(this.hasNext())
            {
                Student student = students.get(currentIndex);
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
                students.remove(currentIndex - 1);
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
        return new CourseIterator(students.size() - 1);
    }
}
