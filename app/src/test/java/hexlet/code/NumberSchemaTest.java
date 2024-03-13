package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberSchemaTest {
    private static NumberSchema schema;

    @BeforeEach
    public void init() {
        Validator validator = new Validator();
        schema = validator.number();
    }

    @Test
    public void withoutRequiredNullTest1() {
        Boolean actual = schema.isValid(null);
        assertEquals(true, actual);
    }
    @Test
    public void withoutRequiredNullTest2() {
        Boolean actual = schema.positive().isValid(null);
        assertEquals(true, actual);
    }
    @Test
    public void withRequiredNullTest() {
        Boolean actual = schema.required().isValid(null);
        assertEquals(false, actual);
    }

    @Test
    public void withRequiredPositiveTest1() {
        Boolean actual = schema.required().isValid(10);
        assertEquals(true, actual);
    }

    @Test
    public void withRequiredPositiveTest2() {
        Boolean actual = schema.required().positive().isValid(-10);
        assertEquals(false, actual);
    }

    @Test
    public void withRequiredPositiveTest3() {
        Boolean actual = schema.required().positive().isValid(0);
        assertEquals(false, actual);
    }

    @Test
    public void withRequiredRangeTest1() {
        Boolean actual = schema.required().range(5, 10).isValid(5);
        assertEquals(true, actual);
    }

    @Test
    public void withRequiredRangeTest2() {
        Boolean actual = schema.required().range(5, 10).isValid(10);
        assertEquals(true, actual);
    }

    @Test
    public void withRequiredRangeTest3() {
        Boolean actual = schema.required().range(5, 10).isValid(4);
        assertEquals(false, actual);
    }

    @Test
    public void withRequiredRangeTest4() {
        Boolean actual = schema.required().range(5, 10).isValid(11);
        assertEquals(false, actual);
    }
}
