import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Tyler Herrin on 5/7/2015.
 */
public class IteratorTester
{
    public static void main(String args[])
    {
        ArrayList<Student> students = makeList();

        // Testing for loop iteration
        Course course = new Course(students);
        for(Student s : course)
        {
            System.out.println(s);
        }
        System.out.println();

        // Testing remove
        int x = 0;
        Iterator iter = course.iterator();
        while(x < 2)
        {
            System.out.println("REMOVING: " + iter.next());
            iter.remove();
            x++;
        }
        System.out.println();

        // Check loop interation again after remove
        for(Student s : course)
        {
            System.out.println(s);
        }
    }
    
    private static ArrayList<Student> makeList()
    {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Tyler Herrin", 1));
        students.add(new Student("Josh Harshman", 2));
        students.add(new Student("Ben Daschel", 3));
        students.add(new Student("Frank", 4));
        
        return students;
    }
}
