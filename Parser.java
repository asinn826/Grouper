import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by alfre on 2016-10-06.
 */
public class Parser {
    private String fileName;
    private ArrayList<ArrayList<Integer>> studentNumberGroups;
    private List<Person> people;
    private Map<Integer, Person> numberPersonMap;

    public Parser(String fileName) {
        this.fileName = fileName;
        studentNumberGroups = new ArrayList<ArrayList<Integer>>();
        people = new ArrayList<Person>();
        numberPersonMap = new HashMap<Integer, Person>();
    }

    public ArrayList<ArrayList<Integer>> getStudentNumberGroups() {
        return studentNumberGroups;
    }

    public List<Person> getPeople() {
        return people;
    }

    public Map<Integer, Person> getNumberPersonMap() {
        return numberPersonMap;
    }

    // parse a line into a list of numbers
    public void parseIntoListOfNumbers() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            for (Object line : stream.toArray()) {
                studentNumberGroups.add(parseIntoListOfNumbersHelper(line.toString()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // returns all student numbers contained on a single line
    private static ArrayList<Integer> parseIntoListOfNumbersHelper(String line) {
        // separate out student numbers
        // logic: all non-number spaces can be discarded and used as separators
        // can map numbers to names later - let's just group them for now
        ArrayList<Integer> numbersOnThisLine = new ArrayList<Integer>();
        char[] buffer = new char[8];
        for (int i = 0; i < line.length(); i++) {
            if (Character.isDigit(line.charAt(i))) {
                for (int j = 0; j < 8; j++) {
                    buffer[j] = line.charAt(i + j);
                }
                int studentNumber = Integer.parseInt(new String(buffer));
                numbersOnThisLine.add(studentNumber);
                i += 8;
                buffer = new char[8];
            }
        }
        System.out.println(numbersOnThisLine.toString());
        return numbersOnThisLine;
    }

    public void parseNamesAndNumber() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            for (Object line : stream.toArray()) {
                parseNamesAndNumberHelper(line.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseNamesAndNumberHelper(String s) {
        StringBuffer fname = new StringBuffer();
        StringBuffer lname = new StringBuffer();
        StringBuffer studentNum = new StringBuffer();
//        System.out.println(s);
        int i = 0;
        // TODO: should refactor this code to get rid of 3 identical while loops
//        fname = parseOnlyNameAndNumber("f", s, i);
        while (i < s.length() && s.charAt(i) != ',') {
            fname.append(s.charAt(i));
            i++;
        }
        i++;
        while (i < s.length() && s.charAt(i) != ',') {
            lname.append(s.charAt(i));
            i++;
        }
        i++;
        while (i < s.length() && s.charAt(i) != ',') {
            studentNum.append(s.charAt(i));
            i++;
        }
        Integer studentNumber = Integer.parseInt(studentNum.toString());
        Person p = new Person(fname.toString(), lname.toString(), studentNumber);
        people.add(p);
        numberPersonMap.put(studentNumber, p);
//        System.out.println(fname);
//        System.out.println(lname);
//        System.out.println(studentNum);
    }


}
