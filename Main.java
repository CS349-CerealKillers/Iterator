public class Main{
   
   public static void main(String[] args){
      Course course = new Course();
      
      for(int i = 0; i < 8; i++){
         course.addStudent(new Student("Joe "+ (i+1)));
      }
      
      System.out.println("Using iterator to display students:\n");
      
      for(Student student: course){
         System.out.println(student);
      }
      
      
   }

}