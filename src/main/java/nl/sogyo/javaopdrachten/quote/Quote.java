package nl.sogyo.javaopdrachten.quote;

import java.time.LocalDate;

public class Quote {
    static String[][] quotes = {
        {"galileo", "eppur si muove"},
        {"archimedes", "eureka!"},
        {"erasmus", "in regione caecorum rex est luscus"},
        {"socrates", "I know nothing except the fact of my ignorance"},
        {"rené descartes", "cogito, ergo sum"},
        {"sir isaac newton", "if I have seen further it is by standing on the shoulders of giants"}
    };
    
    // Get today's date (yyyy-mm-dd)
    static LocalDate today = LocalDate.now();
    // alternatively, for testing other days:
    // static LocalDate today = LocalDate.now().minusDays(5);
    // static LocalDate today = LocalDate.now().plusDays(4);
    
    // Formatting the first line
    static void formatDate(){
        String weekDayNoFormat = today.getDayOfWeek().toString();
        String weekDay = weekDayNoFormat.substring(0, 1) + weekDayNoFormat.substring(1).toLowerCase();
        int day = today.getDayOfMonth(); 
        String monthNoFormat = today.getMonth().toString();
        String month = monthNoFormat.substring(0,1) + monthNoFormat.substring(1).toLowerCase();
        String ordinalDay;
        switch (day){
            case 1:
            ordinalDay = day +"st";
            break;
            case 2:
            ordinalDay = day +"nd";
            break;
            case 3:
            ordinalDay = day +"rd";
            break;
            case 21:
            ordinalDay = day +"st";
            break;
            case 22:
            ordinalDay = day +"nd";
            break;
            case 23:
            ordinalDay = day +"rd";
            break;
            case 31:
            ordinalDay = day +"st";
            break;
            default:
            ordinalDay = day +"th";
        }
        System.out.println("Quote for " + weekDay + " the " + ordinalDay + " of " + month + ":");
    }
    
    // Picking the quote corresponding to the day
    static String[] quoteOfDay;
    static int quoteIndex;
    
    static void getQuote(){
        int index = today.getDayOfYear();
        while(index>quotes.length){
            index-=quotes.length;
            quoteIndex = index;
        }
        quoteIndex = index - 1;
        quoteOfDay = quotes[quoteIndex];
    }
    
    // Formatting the second line (quote)
    static void formatQuote(){
        formatQuotee();
        formatQuoteText();
        System.out.println(quoteOfDay[1] + " -- " + quoteOfDay[0]);
    }

    static void formatQuotee(){
        String[] splitName = quoteOfDay[0].split(" ");
        for(int i=0; i<splitName.length; i++){
            splitName[i]= splitName[i].substring(0,1).toUpperCase() + splitName[i].substring(1).toLowerCase();
        }
        String quotee = String.join(" ", splitName);
        quoteOfDay[0] = quotee;
    }

    static void formatQuoteText(){
        String quoteText = "\"" + quoteOfDay[1].substring(0,1).toUpperCase() + quoteOfDay[1].substring(1).toLowerCase();
        if(quoteText.matches(".*[a-z]$")){
            quoteText = quoteText + ".\"";
        } else {
            quoteText = quoteText + "\"";
        }
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_GREEN = "\u001B[32m";
        quoteText = ANSI_GREEN + quoteText + ANSI_RESET;
        quoteOfDay[1]=quoteText;
    }
    
    public static void main(String... args) {
        formatDate();
        getQuote();
        formatQuote();
    }
}
