package exercises;

public class HumanReadableTime {
    public static String makeReadable(int seconds) {
        int secondsToWrite = seconds % 60;
        int minutes = (seconds / 60) % 60;
        int hours = (seconds / 60) / 60;

        StringBuilder clock = new StringBuilder();

        clock.append(hours < 10 ? "0" + hours : hours);
        clock.append(":");
        clock.append(minutes < 10 ? "0" + minutes : minutes);
        clock.append(":");
        clock.append(secondsToWrite < 10 ? "0" + secondsToWrite : secondsToWrite);

        return clock.toString();
    }
}
