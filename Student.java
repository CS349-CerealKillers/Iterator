public class Student {

    private String name;
    
    public Student(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object other){
        if(other instanceof Student){
            Student temp = (Student)other;
            if(temp.name.equals(this.name))
                return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return name;
    }
}