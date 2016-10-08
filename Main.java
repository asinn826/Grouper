/**
 * Created by alfre on 2016-10-06.
 */
public class Main {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\alfre\\IdeaProjects\\Grouper\\assets\\moredata.csv";
        Parser p = new Parser(fileName);
        p.parseIntoListOfNumbers();
        p.parseNamesAndNumber();

        Matcher m = new Matcher(p.getStudentNumberGroups(), p.getPeople(), p.getNumberPersonMap());
        m.matchNumbersWithPeople();
        m.keepOnlyCompleteGroups();
        m.printGroups();
    }
}
