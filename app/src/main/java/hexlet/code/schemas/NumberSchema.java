package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {

    public final NumberSchema required() {
        setRequiredOn();
        return this;
    }

    public final NumberSchema positive() {
        addCondition(n ->  n > 0);
        return this;
    }

    public final NumberSchema range(int min, int max) {
        addCondition(r ->  r >= min &&  r <= max);
        return this;
    }
}
