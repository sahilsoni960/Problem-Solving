public class Validate24HourFormat {

    public static void main(String[] args) {
        boolean result = solution("23:11");

        if (result) {
            System.out.println("valid format");
        } else {
            System.out.println("invalid format");
        }

    }

    private static boolean solution(String time) {
        // 1. Check for null input
        if (time == null) {
            return false;
        }

        // 2. Split the string and ensure it has exactly two parts (hours and minutes)
        String[] parts = time.split(":");
        if (parts.length != 2) {
            return false;
        }

        try {
            // 3. Parse the parts into integers
            int hours = Integer.parseInt(parts[0]);
            int mins = Integer.parseInt(parts[1]);

            // 4. A valid 24-hour format has hours from 0-23 and minutes from 0-59.
            return (hours >= 0 && hours <= 23) && (mins >= 0 && mins <= 59);
        } catch (NumberFormatException e) {
            // 5. If parts are not numbers, it's an invalid format.
            return false;
        }
    }


}