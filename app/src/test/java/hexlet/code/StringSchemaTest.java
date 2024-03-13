package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringSchemaTest {
    private static StringSchema schema;

    @BeforeEach
    public void init() {
        Validator validator = new Validator();
        schema = validator.string();
    }
    @Test
    public void withoutRequiredNullTest() {
        Boolean actual = schema.isValid(null);
        assertEquals(true, actual);
    }

    @Test
    public void withoutRequiredEmptySpaceTest() {
        Boolean actual = schema.isValid("");
        assertEquals(true, actual);
    }

    @Test
    public void withRequiredNullTest() {
        Boolean actual = schema.required().isValid(null);
        assertEquals(false, actual);
    }

    @Test
    public void withRequiredEmptySpaceTest() {
        Boolean actual = schema.required().isValid("");
        assertEquals(false, actual);
    }

    @Test
    public void withRequiredTest() {
        Boolean actual = schema.required().isValid("hexlet");
        assertEquals(true, actual);
    }

    @Test
    public void withRequiredMinLength1() {
        Boolean actual = schema.required().minLength(5).isValid("what does tha fox say");
        assertEquals(true, actual);
    }

    @Test
    public void withRequiredMinLength2() {
        Boolean actual = schema.required().minLength(5).isValid("what");
        assertEquals(false, actual);
    }

    @Test
    public void withRequiredContainsTest1() {
        Boolean actual = schema.required().contains("what").isValid("what does tha fox say");
        assertEquals(true, actual);
    }

    @Test
    public void withRequiredContainsTest2() {
        Boolean actual = schema.required().contains("whatthe").isValid("what does tha fox say");
        assertEquals(false, actual);
    }

    @Test
    public void stringSchemaTest1() {
        Boolean actual = schema.required().minLength(5).contains("what").isValid("what does tha fox say");
        assertEquals(true, actual);
    }
    @Test
    public void stringSchemaTest2() {
        Boolean actual = schema.required().minLength(5).contains("whatthe").isValid("what does tha fox say");
        assertEquals(false, actual);
    }
}
