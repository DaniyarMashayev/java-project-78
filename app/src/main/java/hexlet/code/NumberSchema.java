package hexlet.code;

public class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        addCondition(n -> n instanceof Integer);
        return this;
    }

    public NumberSchema positive() {
        addCondition(n -> n instanceof Integer && (Integer) n > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        addCondition(r -> (Integer) r >= min && (Integer) r <= max);
        return this;
    }
}
