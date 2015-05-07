/**
 * Created by Tyler Herrin on 5/7/2015.
 */
public class Student
{
    private String name;
    private int id;

    public Student(String name, int id)
    {
        this.name = name;
        this.id = id;
    }

    public String getName()
    {
        return this.name;
    }

    public int getID()
    {
        return this.id;
    }

    public String toString()
    {
        return "Name: " + this.name + ", ID: " + this.id;
    }
}
