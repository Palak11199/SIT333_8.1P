package web.service;

public class MathQuestionService {

    public static Double q1Addition(String num1, String num2) {
        try {
            if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty()) {
                return null;
            }
            double a = Double.parseDouble(num1);
            double b = Double.parseDouble(num2);
            return a + b;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Double q2Subtraction(String num1, String num2) {
        try {
            if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty()) {
                return null;
            }
            double a = Double.parseDouble(num1);
            double b = Double.parseDouble(num2);
            return a - b;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    // YOU MUST ADD THIS (Q3)
    public static Double q3Multiplication(String num1, String num2) {
        try {
            if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty()) {
                return null;
            }
            double a = Double.parseDouble(num1);
            double b = Double.parseDouble(num2);
            return a * b;
        } catch (NumberFormatException e) {
            return null;
        }
    }
}