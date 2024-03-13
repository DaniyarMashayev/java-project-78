package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapSchemaTest {
    private static MapSchema schema;
    private static Validator validator;

    @BeforeEach
    public void init() {
        validator = new Validator();
        schema = validator.map();
    }

    @Test
    public void withoutRequiredNullTest() {
        Boolean actual = schema.isValid(null);
        assertEquals(true, actual);
    }

    @Test
    public void withRequiredNullTest() {
        Boolean actual = schema.required().isValid(null);
        assertEquals(false, actual);
    }

    @Test
    public void withRequiredNullTest2() {
        Boolean actual = schema.required().isValid(new HashMap<>());
        assertEquals(true, actual);
    }

    @Test
    public void sizeofTest1() {
        schema.required().sizeof(2);
        HashMap<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        Boolean actual = schema.isValid(data);
        assertEquals(false, actual);
    }

    @Test
    public void sizeofTest2() {
        schema.required().sizeof(2);
        HashMap<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        data.put("key2", "value2");
        Boolean actual = schema.isValid(data);
        assertEquals(true, actual);
    }
    @Test
    public void shapeTest1() {
        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("firstName", validator.string().required());
        schemas.put("lastName", validator.string().required().minLength(2));
        schema.shape(schemas);
        Map<String, String> human = new HashMap<>();
        human.put("firstName", "John");
        human.put("lastName", "Smith");
        assertEquals(true, schema.isValid(human));
}
    @Test
    public void shapeTest2() {
        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("firstName", validator.string().required());
        schemas.put("lastName", validator.string().required().minLength(2));
        schema.shape(schemas);
        Map<String, String> human = new HashMap<>();
        human.put("firstName", "John");
        human.put("lastName", null);
        assertEquals(false, schema.isValid(human));
    }

    @Test
    public void shapeTest3() {
        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("firstName", validator.string().required());
        schemas.put("lastName", validator.string().required().minLength(2));
        schema.shape(schemas);
        Map<String, String> human = new HashMap<>();
        human.put("firstName", "Anna");
        human.put("lastName", "B");
        assertEquals(false, schema.isValid(human));
    }
}
