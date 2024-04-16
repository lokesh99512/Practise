package Pattrens;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Pattrens {

	  public static void processFlightNumbers(String flightString) {
	        String[] words = flightString.split(", ");
	        String[] flightNumbers;

	        switch (findCase(words)) {
	            case "All":
	                System.out.println("Processing all flights");
	                flightNumbers = extractFlightNumbers(words);
	                break;
	            case "Except":
	                System.out.println("Processing excepted flights");
	                flightNumbers = extractFlightNumbers(words);
	                break;
	            case "Specific":
	                System.out.println("Processing specific flights");
	                flightNumbers = extractFlightNumbers(words);
	                break;
	            default:
	                System.out.println("Invalid input");
	                flightNumbers = new String[0];
	                break;
	        }

	        System.out.println("Flight Numbers: " + Arrays.toString(flightNumbers));
	    }

	    public static String findCase(String[] words) {
	        if (Arrays.asList(words).contains("All")) {
	            return "All";
	        } else if (Arrays.asList(words).contains("Except")) {
	            return "Except";
	        } else if (containsFlightNumber(words)) {
	            return "Specific";
	        } else {
	            return "Invalid";
	        }
	    }

	    public static boolean containsFlightNumber(String[] words) {
	        Pattern pattern = Pattern.compile("[A-Z]+\\s\\d+");
	        for (String word : words) {
	            Matcher matcher = pattern.matcher(word);
	            if (matcher.find()) {
	                return true;
	            }
	        }
	        return false;
	    }

	    public static String[] extractFlightNumbers(String[] words) {
	        Pattern pattern = Pattern.compile("[A-Z]+\\s\\d+");
	        return Arrays.stream(words)
	                .filter(word -> pattern.matcher(word).matches())
	                .toArray(String[]::new);
	    }

//	    public static void main(String[] args) {
//	    	List number = Arrays.asList(2,2,4,5);
//	    	
//	    	
//	    	
//	    	System.out.println(number.stream().distinct().collect(Collectors.toList()));
//	    	
//	    }
	    
//	    public static void main(String[] args) {
//	        String input = " except  Uk 345, Uk 347";
//	        List<String> flightNumbers = extractFlightNumbers(input);
//	        for (String flightNumber : flightNumbers) {
//	            System.out.println(flightNumber);
//	        }
//	    }
//
//	    public static List<String> extractFlightNumbers(String input) {
//	        List<String> flightNumbers = new ArrayList<>();
//	     
//	        Pattern pattern = Pattern.compile("\\b[A-Za-z]+\\s*\\d+\\b");
//	        Matcher matcher = pattern.matcher(input);
//	        while (matcher.find()) {
//	            String flightNumber = matcher.group();
//	            flightNumbers.add(flightNumber.replaceAll("(\\b[A-Za-z]+)(\\s*)(\\d+\\b)", "$1 $3"));
//	        }
//	        return flightNumbers;
//	    }
	    
	    
	    
//	    
//	    public static void main(String[] args) {
//	        String inputString1 = "07:30";
//	        String inputString2 = "For All Flights departed between 09:01 TO 23:59 HRS";
//	        String inputString3 = "For All Flights between 15:00 HRS TILL 23:59 HRS";
//
//	        // Extract times from input strings
//	        Map<String, String> times1 = extractTimes(inputString1);
//	        Map<String, String> times2 = extractTimes(inputString2);
//	        Map<String, String> times3 = extractTimes(inputString3);
//
//	        // Print extracted times
//	        System.out.println("Time from inputString1: From " + times1.get("from") + " to " + times1.get("to"));
//	        System.out.println("Time from inputString2: From " + times2.get("from") + " to " + times2.get("to"));
//	        System.out.println("Time from inputString3: From " + times3.get("from") + " to " + times3.get("to"));
//	    }
//
//	    // Method to extract times from a given input string
//	    public static Map<String, String> extractTimes(String input) {
//	        // Regular expression pattern to match time in HH:MM format
//	        Pattern timePattern = Pattern.compile("\\b(\\d{2}:\\d{2})\\b");
//	        
//	        Matcher matcher = timePattern.matcher(input);
//	        Map<String, String> times = new HashMap<>();
//	        int i = 0;
//	        while (matcher.find() && i < 2) {
//	            times.put((i == 0) ? "from" : "to", matcher.group());
//	            i++;
//	        }
//	        // If only one time is found, set both fromTime and toTime to that time
//	        if (i == 1) {
//	            times.put("to", times.get("from"));
//	        }
//	        return times;
//	    }
	    
	    
	    public static String checkDay(String inputString) {
	        String pattern = "\\b(MON|TUE|WED|THU|FRI|SAT|SUN)\\b";
	        Pattern dayPattern = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
	        Matcher matcher = dayPattern.matcher(inputString);
	        StringBuilder resultBuilder = new StringBuilder();
	        while (matcher.find()) {
	            resultBuilder.append(matcher.group().toUpperCase()).append(",");
	        }
	        String result = resultBuilder.toString().trim();
	        return result.isEmpty() ? null : result.substring(0, result.length() - 1);
	    }

	    public static void main(String[] args) {
	        String inputString1 = "MON,THU";
	        String result1 = checkDay(inputString1);
	        System.out.println(result1); // Output: MON,THU

	        String inputString2 = "XYZ";
	        String result2 = checkDay(inputString2);
	        System.out.println(result2); // Output: null
	    }
	}