package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {

    public final StringSchema required() {
        addCondition(s -> !"".equals(s));
        setRequiredOn();
        return this;
    }

    public final StringSchema minLength(int length) {
        addCondition(i -> i.length() >= length);
        return this;
    }

    public final StringSchema contains(String subString) {
        addCondition(s -> s.contains(subString));
        return this;
    }
}
