package hexlet.code;

import java.util.Map;
import java.util.Objects;

public class MapSchema extends BaseSchema<Map<?, ?>> {

    public MapSchema required() {
        addCondition(Objects::nonNull);
        return this;
    }

    public MapSchema sizeof(int size) {
        addCondition(m -> ((Map<?, ?>) m).size() == size);
        return this;
    }
}
