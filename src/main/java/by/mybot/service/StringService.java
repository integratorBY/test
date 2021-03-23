package by.mybot.service;

public class StringService {

    public static final String ARABIC = "1234567890";
    public static final String ROMAN = "IVXLCDM";

    private boolean isArabic(String text) {
        char[] symbol = text.toCharArray();
        boolean result = true;
        while(result){
            for (int i = 0; i < symbol.length; i++) {
                if(ARABIC.contains(symbol[i])){
                    result = true;
                }else{
                    result = false;
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        StringService stringService = new StringService();
        System.out.println(stringService.isArabic("154"));
    }

    private boolean isRoman(String text) {
        return ROMAN.contains(text);
    }

    public boolean isAllArabic(String text){
        return isArabic(getNumbersFromExample(text)[0]) && isArabic(getNumbersFromExample(text)[1]);
    }

    public boolean isAllRoman(String text){
        return isRoman(getNumbersFromExample(text)[0]) && isRoman(getNumbersFromExample(text)[1]);
    }

    public String getInstanceOfExample(String example, int number) {
        String[] words = example.split("\\s");
        //TODO проверка без пробелов
        return words[number];
    }

    private boolean isTrueSign(String text) {
        switch (getInstanceOfExample(text, 1)) {
            case "+":
                return true;
            case "-":
                return true;
            case "/":
                return true;
            case "*":
                return true;
            default:
                return false;
        }
    }

    public boolean isCanBeSolved(String text) {
        return (isAllArabic(text) || (isAllRoman(text))) && isTrueSign(text);
    }

    private String[] getNumbersFromExample(String text){
        return new String[]{getInstanceOfExample(text, 0) , getInstanceOfExample(text, 2)};
    }

    public int castStringToNumber(String number) {
        return Integer.parseInt(number);
    }

    public int convertRomanToInt(String romanNumeral) throws NumberFormatException {
        int integerValue = 0;
        for (int i = 0; i < romanNumeral.length(); i++) {
            char ch = romanNumeral.charAt(i);
            int number = letterToNumber(ch);
            if (number == -1) {
                throw new NumberFormatException("Invalid format");
            }
            integerValue += number;
        }
        return integerValue;
    }

    private int letterToNumber(char symbol) {
        switch (symbol) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return -1;
        }
    }
}
