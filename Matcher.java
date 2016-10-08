import java.util.*;

/**
 * Created by alfre on 2016-10-07.
 */
public class Matcher {
    private ArrayList<ArrayList<Integer>> studentNumberGroups;
    private List<Person> people;
    private Map<Integer, Person> numberPersonMap;
    private Set<List<Person>> groups;

    public Matcher(ArrayList<ArrayList<Integer>> studentNumberGroups, List<Person> people, Map<Integer, Person> numberPersonMap) {
        this.studentNumberGroups = studentNumberGroups;
        this.people = people;
        this.numberPersonMap = numberPersonMap;
        groups = new HashSet<>();
    }

    public void matchNumbersWithPeople() {
        // have list list of numbers
        // have list of people
        // for all list of numbers in list:
        //      for all numbers in list of numbers:
        //          match with Person
        //          print out first name, last name, and student number in nice format
        ArrayList<Person> group = new ArrayList<>();
        for (ArrayList<Integer> l : studentNumberGroups) {
            for (Integer i : l) {
                if (numberPersonMap.containsKey(i)) {
                    group.add(numberPersonMap.get(i));
                }
            }
            groups.add(group);
            group = new ArrayList<>();
        }
        for (List<Person> l : groups) {
            System.out.println(l.toString());
        }
    }
}
