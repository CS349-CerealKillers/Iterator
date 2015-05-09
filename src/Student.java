/**
 * Created by jharshman on 5/8/15.
 */
public class Student {

    String _name;
    public Student(String name) {
        _name = name;
    }
    @Override
    public String toString() {
        return _name;
    }
    @Override
    public boolean equals(Object that) {
        if(this.getClass().equals(that.getClass())) {
            Student student = (Student)that;
            if(student._name.equals(this._name)) {
                return true;
            }
        }
        return false;
    }
}
