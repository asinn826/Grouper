import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by alfre on 2016-10-06.
 */
public class Parser {
    private String fileName;

    public Parser(String fileName) {
        this.fileName = fileName;
    }

    // parse a line into a list of numbers
    public void parseIntoListOfNumbers() {
        List<Integer> groupMemberNumbers = new ArrayList<Integer>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            for (Object line : stream.toArray()) {
                parseIntoListOfNumbersHelper(line.toString());
            }
//            stream.forEach(line -> {
//                parseIntoListOfNumbersHelper(line);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Integer> parseIntoListOfNumbersHelper(String line) {
        // separate out student numbers
        // logic: all non-number spaces can be discarded and used as separators
        // can map numbers to names later - let's just group them for now
        System.out.println(line);
        return null;
    }

}
