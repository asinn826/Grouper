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

    public void parseIntoListOfNumbers() {
        List<Integer> groupMemberNumbers = new ArrayList<Integer>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            System.out.println(stream.findFirst());
//            stream.forEach(line -> {
//                groupMemberNumbers = parseIntoListOfNumbersHelper(line);
//            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Integer> parseIntoListOfNumbersHelper(String line) {
        return null;
    }

}
