package exercises;


public class Zywoo {
    public String warnTheSheep(String[] strings) {
        if (strings[strings.length-1].equals("wolf")) {
            return "Pls go away and stop eating my sheep";
        }else {
            int wolfPlace = 0;
            try {
                wolfPlace = findWolfPlace(strings);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "Oi! Sheep number " + (wolfPlace - 1) +"! You are about to be eaten by a wolf!";
        }
    }

    private int findWolfPlace(String[] strings) throws Exception {
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals("wolf")) {
                return strings.length - i;
            }
        }
        throw new Exception("There is no wolf between sheeps");
    }
}
