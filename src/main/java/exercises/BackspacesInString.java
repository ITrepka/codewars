package exercises;

public class BackspacesInString {
    public String cleanString(String s) {
        StringBuilder sb = new StringBuilder();

        for (String s1 : s.split("")) {
            if (!s1.equals("#")) {
                sb.append(s1);
            } else if (sb.toString().length() > 0){
                sb.deleteCharAt(sb.toString().length() - 1);
            }
        }
        return sb.toString();
    }
}
