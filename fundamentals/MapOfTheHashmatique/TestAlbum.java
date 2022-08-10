import java.util.HashMap;
import java.util.Set;

public class TestAlbum {
    public static void main(String[] args) {
        // Create a trackList of type HashMap
        HashMap<String, String> trackList = new HashMap<String, String>();

        // Add in at least 4 songs that are stored by title
        trackList.put("All The Small Things", "Say it ain't so, I will not go, Turn the lights off, Carry me home");
        trackList.put("What's My Age Again?", "My friends say I should act my age, What's my age again? What's my age again?");
        trackList.put("First Date", "Let's go, Don't wait, This night's almost over, Honest, Let's make, This night last forever");
        trackList.put("Dammit", "And it's happened once again, I'll turn to a friend, Someone that understands, Sticks to the masterplan");

        // Pull out one of the songs by its track title
        String firstDate = trackList.get("First Date");
        System.out.println(firstDate);

        // Print out all the track names and lyrics in the format Track: Lyrics
        Set<String> keys = trackList.keySet();
        for (String key : keys) {
            System.out.println("\n------------" + key);
            System.out.println(trackList.get(key));
        }
    }
}
