package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberSchemaTest {
    private static NumberSchema schema;
    private static Boolean expectedTrue;
    private static Boolean expectedFalse;

    @BeforeEach
    public void init() {
        Validator validator = new Validator();
        schema = validator.number();
        expectedTrue = true;
        expectedFalse = false;
    }

    @Test
    public void withoutRequiredNullTest() {
        Boolean actual = schema.isValid(null);
        assertEquals(expectedTrue, actual);
    }

    @Test
    public void withRequiredNullTest() {
        schema.required();
        Boolean actual = schema.isValid(null);
        assertEquals(expectedFalse, actual);
    }

    @Test
    public void withRequiredPositiveTest1() {
        schema.required();
        Boolean actual = schema.isValid(10);
        assertEquals(expectedTrue, actual);
    }

    @Test
    public void withRequiredPositiveTest2() {
        schema.positive().required();
        Boolean actual = schema.isValid(-10);
        assertEquals(expectedFalse, actual);
    }

    @Test
    public void withRequiredPositiveTest3() {
        schema.positive().required();
        Boolean actual = schema.isValid(0);
        assertEquals(expectedFalse, actual);
    }

    @Test
    public void withRequiredRangeTest1() {
        schema.required().range(5, 10);
        Boolean actual = schema.isValid(5);
        assertEquals(expectedTrue, actual);
    }

    @Test
    public void withRequiredRangeTest2() {
        schema.required().range(5, 10);
        Boolean actual = schema.isValid(10);
        assertEquals(expectedTrue, actual);
    }

    @Test
    public void withRequiredRangeTest3() {
        schema.required().range(5, 10);
        Boolean actual = schema.isValid(4);
        assertEquals(expectedFalse, actual);
    }

    @Test
    public void withRequiredRangeTest4() {
        schema.required().range(5, 10);
        Boolean actual = schema.isValid(11);
        assertEquals(expectedFalse, actual);
    }
}
