import java.util.Iterator;
import java.util.ArrayList;

public class Course implements Iterable<Student>{
   
   ArrayList<Student> myList;
   
   private class CourseIterator implements Iterator{
        private int cur;
   
        @Override
        public Student next() {
            Student student = myList.get(cur++);
            return student;
        }
        
        @Override
        public boolean hasNext() {
            return cur < myList.size();
        }

        @Override
        public void remove(){
            throw new UnsupportedOperationException();
        }
   }
   
   
   public Course() {
       myList = new ArrayList<Student>();
   }
   
   public Iterator<Student> iterator(){
        return new CourseIterator();
   }
   
   public void removeStudent(Student student){
      myList.remove(student);
   }
   
   public void addStudent(Student student){
      myList.add(student);
   }
   
   public int getSize(){
      return myList.size();
   }

}