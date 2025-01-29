public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        if (numbers.startsWith("//")) {
            String delimiterLine = numbers.split("\n")[0];
            String delimiters = delimiterLine.substring(2);

            // If the delimiter is enclosed in square brackets, handle multiple delimiters
            if (delimiters.startsWith("[")) {
                delimiters = delimiters.substring(1, delimiters.length() - 1);
                String[] delimiterArray = delimiters.split("\\]\\[");

                for (String delimiter : delimiterArray) {
                    numbers = numbers.replace(delimiter, ",");
                }
            } else {
                numbers = numbers.replace(delimiters, ",");
            }

            numbers = numbers.substring(delimiterLine.length() + 1);

        } else {
            numbers = numbers.replace("\n", ",");
        }

        String[] numArray = numbers.split(",");

        int sum = 0;
        handleInvalidCharacter(numArray);
        StringBuilder negativeNumbers = new StringBuilder();


        for (String num : numArray) {
            int number = Integer.parseInt(num);

            if (number < 0) {
                if (negativeNumbers.length() > 0) {
                    negativeNumbers.append(",");
                }
                negativeNumbers.append(number);
            } else {
                sum += number;
            }
        }

        if (negativeNumbers.length() > 0) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negativeNumbers);
        }

        return sum;
    }

    private void handleInvalidCharacter(String[] numArray ){
        StringBuilder invalidCharacters = new StringBuilder();
        for(String num : numArray){
            if(invalidCharacters.length()>0){
                invalidCharacters.append(",");
            }
            if(num.equals("a") || num.equals("b")){
                invalidCharacters.append(num);
            }
        }
        if(invalidCharacters.length()>0){
            throw new IllegalArgumentException("Invalid character not allowed: " + invalidCharacters);
        }
    }
}
