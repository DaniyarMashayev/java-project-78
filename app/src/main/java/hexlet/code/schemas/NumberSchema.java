package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {

    public final NumberSchema required() {
        addCondition(n -> n instanceof Integer);
        setRequiredOn();
        return this;
    }

    public final NumberSchema positive() {
        addCondition(n -> n instanceof Integer && (Integer) n > 0);
        return this;
    }

    public final NumberSchema range(int min, int max) {
        addCondition(r -> (Integer) r >= min && (Integer) r <= max);
        return this;
    }
}
