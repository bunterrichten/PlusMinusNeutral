package plusminus;

import java.util.HashMap;
import java.util.Map;

public class PlusMinus {
    public static double plusMinus(String txt) {

        HashMap<String, Double> list = new HashMap();

        list.put("good", 0.4);
        list.put("best", 0.8);

        list.put("nothing", -0.2);
        list.put("stupid", -0.4);
        list.put("not", -0.05);
        list.put("neither", -0.3);
        list.put("nor", -0.3);

        txt = txt.replaceAll("\\.|\\?|!|:|,|;|-", "");
        String[] parts = txt.split(" ");

        double result = 0;
        for (String word : parts) {
            if (list.containsKey(word)) {
                System.out.println(word + " is in list: " + list.get(word));
                result += list.get(word);
            }
        }

        System.out.println("end result: " + result);
        return result;
    }
}
