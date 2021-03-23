package by.mybot;

import by.mybot.service.ArithmeticService;
import by.mybot.service.StringService;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class Application {

    static Logger log = Logger.getLogger(Application.class);

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringService stringService = new StringService();
        ArithmeticService arithmeticService = new ArithmeticService();

        boolean success = true;
        while (success) {
            log.info("Введите ваш пример:");
            String text = sc.nextLine();
            success = stringService.isCanBeSolved(text);
            if (success) {
                String sign = stringService.getInstanceOfExample(text, 1);
                if (stringService.isAllArabic(text)) {
                    int first = stringService.castStringToNumber(stringService.getInstanceOfExample(text, 0));
                    int second = stringService.castStringToNumber(stringService.getInstanceOfExample(text, 2));
                    log.info(arithmeticService.count(first, second, sign));
                }
                if (stringService.isAllRoman(text)) {
                    int first = stringService.convertRomanToInt(stringService.getInstanceOfExample(text, 0));
                    int second = stringService.convertRomanToInt(stringService.getInstanceOfExample(text, 2));
                    log.info(arithmeticService.count(first, second, sign));
                }
            }
        }
    }
}
