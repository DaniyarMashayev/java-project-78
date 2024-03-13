package hexlet.code;

public class StringSchema extends BaseSchema {

    public final StringSchema required() {
        addCondition(s -> s instanceof String && s != null && !"".equals(s));
        setRequiredOn();
        return this;
    }

    public final StringSchema minLength(int length) {
        addCondition(i -> i.toString().length() >= length);
        return this;
    }

    public final StringSchema contains(String subString) {
        addCondition(s -> s.toString().contains(subString));
        return this;
    }
}
