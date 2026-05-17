package web.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMathQuestionService {

    // ✅ VALID CASES

    @Test
    public void testAdditionValid() {

        Assertions.assertEquals(
                5.0,
                MathQuestionService.q1Addition("2", "3"),
                0.001
        );
    }

    @Test
    public void testSubtractionValid() {

        Assertions.assertEquals(
                1.0,
                MathQuestionService.q2Subtraction("3", "2"),
                0.001
        );
    }

    @Test
    public void testMultiplicationValid() {

        Assertions.assertEquals(
                6.0,
                MathQuestionService.q3Multiplication("2", "3"),
                0.001
        );
    }

    // ✅ EDGE CASES

    @Test
    public void testAdditionWithZero() {

        Assertions.assertEquals(
                2.0,
                MathQuestionService.q1Addition("2", "0"),
                0.001
        );
    }

    @Test
    public void testNegativeNumbers() {

        Assertions.assertEquals(
                -1.0,
                MathQuestionService.q1Addition("-2", "1"),
                0.001
        );
    }

    // ❌ INVALID INPUTS

    @Test
    public void testAdditionEmpty() {

        Assertions.assertNull(
                MathQuestionService.q1Addition("", "3")
        );
    }

    @Test
    public void testAdditionNull() {

        Assertions.assertNull(
                MathQuestionService.q1Addition(null, "3")
        );
    }

    @Test
    public void testAdditionInvalidText() {

        Assertions.assertNull(
                MathQuestionService.q1Addition("abc", "3")
        );
    }

    @Test
    public void testSubtractionInvalid() {

        Assertions.assertNull(
                MathQuestionService.q2Subtraction("x", "2")
        );
    }

    @Test
    public void testMultiplicationInvalid() {

        Assertions.assertNull(
                MathQuestionService.q3Multiplication("2", "y")
        );
    }

    // ✅ DATE TESTS

    @Test
    public void testNextDay() {

        Assertions.assertEquals(
                "2025-05-11",
                MathQuestionService.nextDay("2025-05-10")
        );
    }

    @Test
    public void testPreviousWeek() {

        Assertions.assertEquals(
                "2025-05-03",
                MathQuestionService.previousWeek("2025-05-10")
        );
    }

    // ✅ SCIENCE QUESTION

    @Test
    public void testBoilingPoint() {

        Assertions.assertTrue(
                MathQuestionService.boilingPoint("100")
        );
    }
}