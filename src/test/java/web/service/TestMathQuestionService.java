package web.service;

import org.junit.Assert;
import org.junit.Test;

public class TestMathQuestionService {

    // ✅ VALID CASES

    @Test
    public void testAdditionValid() {
        Assert.assertEquals(5.0, MathQuestionService.q1Addition("2", "3"), 0.001);
    }

    @Test
    public void testSubtractionValid() {
        Assert.assertEquals(1.0, MathQuestionService.q2Subtraction("3", "2"), 0.001);
    }

    @Test
    public void testMultiplicationValid() {
        Assert.assertEquals(6.0, MathQuestionService.q3Multiplication("2", "3"), 0.001);
    }

    // ✅ EDGE CASES

    @Test
    public void testAdditionWithZero() {
        Assert.assertEquals(2.0, MathQuestionService.q1Addition("2", "0"), 0.001);
    }

    @Test
    public void testNegativeNumbers() {
        Assert.assertEquals(-1.0, MathQuestionService.q1Addition("-2", "1"), 0.001);
    }

    // ❌ INVALID INPUTS

    @Test
    public void testAdditionEmpty() {
        Assert.assertNull(MathQuestionService.q1Addition("", "3"));
    }

    @Test
    public void testAdditionNull() {
        Assert.assertNull(MathQuestionService.q1Addition(null, "3"));
    }

    @Test
    public void testAdditionInvalidText() {
        Assert.assertNull(MathQuestionService.q1Addition("abc", "3"));
    }

    @Test
    public void testSubtractionInvalid() {
        Assert.assertNull(MathQuestionService.q2Subtraction("x", "2"));
    }

    @Test
    public void testMultiplicationInvalid() {
        Assert.assertNull(MathQuestionService.q3Multiplication("2", "y"));
    }
}