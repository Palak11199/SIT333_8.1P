package web.service;

import java.time.LocalDate;

/**
 * Service class containing all STEM game logic.
 * Includes math, date, and science questions.
 */
public class MathQuestionService {

    // ======================================================
    // VALIDATE NUMBERS
    // ======================================================

    private static Double parseNumber(String value) {

        try {

            if (value == null || value.isEmpty()) {
                return null;
            }

            return Double.parseDouble(value);

        } catch (Exception e) {

            return null;
        }
    }

    // ======================================================
    // ADDITION
    // ======================================================

    public static Double q1Addition(
            String num1,
            String num2) {

        Double a = parseNumber(num1);
        Double b = parseNumber(num2);

        if (a == null || b == null) {
            return null;
        }

        return a + b;
    }

    // ======================================================
    // SUBTRACTION
    // ======================================================

    public static Double q2Subtraction(
            String num1,
            String num2) {

        Double a = parseNumber(num1);
        Double b = parseNumber(num2);

        if (a == null || b == null) {
            return null;
        }

        return a - b;
    }

    // ======================================================
    // MULTIPLICATION
    // ======================================================

    public static Double q3Multiplication(
            String num1,
            String num2) {

        Double a = parseNumber(num1);
        Double b = parseNumber(num2);

        if (a == null || b == null) {
            return null;
        }

        return a * b;
    }

    // ======================================================
    // NEXT DAY
    // ======================================================

    public static String nextDay(String date) {

        try {

            return LocalDate.parse(date)
                    .plusDays(1)
                    .toString();

        } catch (Exception e) {

            return null;
        }
    }

    // ======================================================
    // PREVIOUS WEEK
    // ======================================================

    public static String previousWeek(String date) {

        try {

            return LocalDate.parse(date)
                    .minusDays(7)
                    .toString();

        } catch (Exception e) {

            return null;
        }
    }

    // ======================================================
    // SCIENCE QUESTION
    // ======================================================

    public static boolean boilingPoint(String answer) {

        return answer != null
                && answer.trim().equals("100");
    }
}