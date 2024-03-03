package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringSchemaTest {
    private static StringSchema schema;
    private static Boolean expectedTrue;
    private static Boolean expectedFalse;

    @BeforeEach
    public void init() {
        Validator validator = new Validator();
        schema = validator.string();
        expectedTrue = true;
        expectedFalse = false;
    }
    @Test
    public void withoutRequiredNullTest() {
        Boolean actual = schema.isValid(null);
        assertEquals(expectedTrue, actual);
    }

    @Test
    public void withoutRequiredEmptySpaceTest() {
        Boolean actual = schema.isValid("");
        assertEquals(expectedTrue, actual);
    }

    @Test
    public void withRequiredNullTest() {
        schema.required();
        Boolean actual = schema.isValid(null);
        assertEquals(expectedFalse, actual);
    }

    @Test
    public void withRequiredEmptySpaceTest() {
        schema.required();
        Boolean actual = schema.isValid("");
        assertEquals(expectedFalse, actual);
    }

    @Test
    public void withRequiredTest() {
        schema.required();
        Boolean actual = schema.isValid("hexlet");
        assertEquals(expectedTrue, actual);
    }

    @Test
    public void withRequiredMinLength1() {
        schema.required();
        Boolean actual = schema.minLength(5).isValid("what does tha fox say");
        assertEquals(expectedTrue, actual);
    }

    @Test
    public void withRequiredMinLength2() {
        schema.required();
        Boolean actual = schema.minLength(5).isValid("what");
        assertEquals(expectedFalse, actual);
    }

    @Test
    public void withRequiredContainsTest1() {
        schema.required();
        Boolean actual = schema.contains("what").isValid("what does tha fox say");
        assertEquals(expectedTrue, actual);
    }

    @Test
    public void withRequiredContainsTest2() {
        schema.required();
        Boolean actual = schema.contains("whatthe").isValid("what does tha fox say");
        assertEquals(expectedFalse, actual);
    }

    @Test
    public void stringSchemaTest1() {
        schema.required();
        Boolean actual = schema.minLength(5).contains("what").isValid("what does tha fox say");
        assertEquals(expectedTrue, actual);
    }
    @Test
    public void stringSchemaTest2() {
        schema.required();
        Boolean actual = schema.minLength(5).contains("whatthe").isValid("what does tha fox say");
        assertEquals(expectedFalse, actual);
    }
}
