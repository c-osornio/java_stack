import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        String greetings = String.format("Hello, %s. Lovely to see you!", name);
        return greetings;
    }

    // NINJA BONUS: Overload the guestGreeting method.
    public String guestGreeting(String name, String villian) {
        String greetings = String.format("Carefull %s. The %s has excaped from Arkham.", name, villian);
        return greetings;
    }
    
    public String dateAnnouncement() {
        Date date = new Date();
        return "It is currently " + date + ".";
    }
    
    public String respondBeforeAlexis(String conversation) {
        int a = conversation.indexOf("Alexis");     // check to see if "Alexis" is in the conversation
        int b = conversation.indexOf("Alfred");    // check to see if "Alfred" is in the conversation
        if (a != -1) {    // if Alexis is in the conversation
            return "Right away, sir. She certainly isn't sophisticated enough for that.";
        } else if (b != -1) {   // if Alfred is in the conversation
            return "At your service. As you wish, naturally.";
        } else {   // if neither
            return "Right. And with that I shall retire."; 
        }
    }
    // Write your own AlfredQuote method using any of the String methods you have learned!
    public String alfredYell(String quote) {
        return quote.toUpperCase();
    }
}

