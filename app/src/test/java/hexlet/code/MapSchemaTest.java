package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapSchemaTest {
    private static MapSchema schema;
    private static boolean expectedTrue;
    private static boolean expectedFalse;

    @BeforeEach
    public void init() {
        Validator validator = new Validator();
        schema = validator.map();
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
        Boolean actual = schema.required().isValid(null);
        assertEquals(expectedFalse, actual);
    }

    @Test
    public void withRequiredNullTest2() {
        Boolean actual = schema.required().isValid(new HashMap<>());
        assertEquals(expectedTrue, actual);
    }

    @Test
    public void sizeofTest1() {
        schema.required().sizeof(2);
        HashMap<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        Boolean actual = schema.isValid(data);
        assertEquals(expectedFalse, actual);
    }

    @Test
    public void sizeofTest2() {
        schema.required().sizeof(2);
        HashMap<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        data.put("key2", "value2");
        Boolean actual = schema.isValid(data);
        assertEquals(expectedTrue, actual);
    }
}

