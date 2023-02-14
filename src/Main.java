import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // First version
        System.out.println("---First version---");
        String result = biggestLine(
                (startLetter, lines) -> {
                    ArrayList<String> linesList = new ArrayList<>(List.of(lines));
                    Collections.sort(linesList, (line1, line2) -> 0-Integer.compare(line1.length(), line2.length()));
                    for (String line : linesList) {
                        if (line.startsWith(startLetter.toUpperCase())) {
                            return line;
                        }
                    }
                    return "There are no strings starting with this character.";
                },
                "s",
                "Sometimes it gets cold in the winter. And some people's souls get cold sometimes too.",
                "S The snow is falling and people are falling.",
                "S In winter, everything around you freezes. And so are the people."
        );
        System.out.println(result);
        // Second version
        System.out.println("---Second version---");
        String result2 = biggestLine(
                (firstLetter, strings) -> {
                    String res = "";
                    for(int i = 0; i < strings.length; i++) {
                        if (strings[i].startsWith(firstLetter.toUpperCase())) {
                            if (strings[i].length() > res.length()) {
                                    res = strings[i];
                            }

                        }
                    }
                    if(res.isEmpty()) {
                        return "There are no strings starting with this character.";
                    }
                    return res;
                },
                "o",
                "O Sometimes it's hot and stuffy in the summer. And some people around here are stuffy too.",
                "O The roofs of houses and cars get very hot in summer. Some people's roofs also get hot and start to go.",
                "O In summer, some people become more relaxed and naked. So you start to miss winter."
        );
        System.out.println(result2);
    }
    public static String biggestLine(CanTakeStringVarargs stringVarargsInterface, String startLetter, String...lines){
        return stringVarargsInterface.getBiggestStartingWith(startLetter, lines);
    }

}