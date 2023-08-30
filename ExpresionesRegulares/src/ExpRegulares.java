import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ExpRegulares {
    public static void main(String[] args) {
        StringBuilder input = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            input.append(args[i]);
            if (i < args.length - 1) {
                input.append(" ");
            }
        }
        String inputString = input.toString().trim();
        boolean isValid = false;
        if (validatePattern(inputString, "\\bHola mundo\\b")) {
            isValid = true;
        } else if (validatePattern(inputString, "\\bHola mundo\\b", Pattern.CASE_INSENSITIVE)) {
            isValid = true;
        } else if (validatePattern(inputString, "(Java|Python|Go|Pascal|Perl)")) {
            isValid = true;
        } else if (validatePattern(inputString, "^[a-zA-Z0-9._%+-]+@(unison\\.mx|uson\\.mx)$")) {
            isValid = true;
        } else if (validatePattern(inputString, "^ISI\\d{4}-[12]\\.(csv|txt)$")) {
            isValid = true;
        }
        if (isValid) {
            System.out.println("Los argumentos introducidos son validos.");
        } else {
            System.out.println("Los argumentos introducidos no son validos.");
        }
    }
    private static boolean validatePattern(String input, String pattern) {
        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(input);
        return matcher.matches();
    }
    private static boolean validatePattern(String input, String pattern, int flags) {
        Pattern regexPattern = Pattern.compile(pattern, flags);
        Matcher matcher = regexPattern.matcher(input);
        return matcher.matches();
    }
}