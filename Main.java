/**
 * Created by alfre on 2016-10-06.
 */
public class Main {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\alfre\\IdeaProjects\\Grouper\\assets\\data.csv";
        Parser p = new Parser(fileName);
        p.parseIntoListOfNumbers();
        p.parseNamesAndNumber();
        p.matchNumbersWithPeople();
    }
}
