package hexlet.code;

import java.util.Map;

public class MapSchema extends BaseSchema {

    public final MapSchema required() {
        addCondition(m -> m instanceof Map<?, ?> && m != null);
        setRequiredOn();
        return this;
    }

    public final MapSchema sizeof(int size) {
        addCondition(m -> m instanceof Map && ((Map<?, ?>) m).size() == size);
        return this;
    }

    public final MapSchema shape(Map<String, BaseSchema> schemas) {
        addCondition(value -> schemas.entrySet().stream().allMatch(item -> {
            Object obj = ((Map) value).get(item.getKey());
            return item.getValue().isValid(obj);
        }));
        return this;
    }
}
