package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<?, ?>> {

    public final MapSchema required() {
        setRequiredOn();
        return this;
    }

    public final MapSchema sizeof(int size) {
        addCondition(m -> m.size() == size);
        return this;
    }

    public final MapSchema shape(Map<String, BaseSchema<String>> schemas) {
        addCondition(value -> schemas.entrySet().stream().allMatch(item -> {
            Object obj = (value).get(item.getKey());
            return item.getValue().isValid(obj);
        }));
        return this;
    }
}
