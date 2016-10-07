import java.util.List;

/**
 * Created by alfre on 2016-10-06.
 */
public class Person {
    private String fname;
    private String lname;
    private int studentNumber;
    private List<Person> groupMembers;

    public Person(String fname, String lname, int studentNumber) {
        this.fname = fname;
        this.lname = lname;
        this.studentNumber = studentNumber;
    }

    public Person(String fname, String lname, int studentNumber, List<Person> groupMembers) {
        this.fname = fname;
        this.lname = lname;
        this.studentNumber = studentNumber;
        this.groupMembers = groupMembers;
    }

    public String getName() {
        return fname + " " + lname;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

}
