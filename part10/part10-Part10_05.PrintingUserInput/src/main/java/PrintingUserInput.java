
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintingUserInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        while (true) {

            String input  = scanner.nextLine();

            if (input.equals("")) {
                break;
            }
            list.add(input);
        }
        list.stream().forEach(input -> System.out.println(input));
    }
}
