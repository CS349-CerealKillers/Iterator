/**
 * Created by jharshman on 5/8/15.
 */
public class Main {

    public static void main(String ... args) {

        Course course = new Course(10);

        // fill all spots in the course
        for(int i = 0; i < course.getMaxEnrolled(); i++) {
            course.enroll(new Student("Student no. " + i));
        }

        System.out.println("There are " + course.getCurrentSize() + " students currently enrolled in the class");
        // demonstrate enhanced for loop
        for(Student s : course) {
            System.out.println(s);
        }

        //remove all from list
        for(int i = 0; i < course.getMaxEnrolled(); i++) {
            course.remove(new Student("Student no. " + i));
        }

        System.out.println("There are " + course.getCurrentSize() + " students currently enrolled in the class");

    }
}
