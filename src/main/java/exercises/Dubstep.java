package exercises;

public class Dubstep {
    public static String SongDecoder (String song)
    {
        return song.replaceAll("WUB", " ").trim().replaceAll("[ ]{2,}", " ");
    }
}
