package hexlet.code;

public class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        addCondition(s -> s != null && !"".equals(s));
        return this;
    }

    public StringSchema minLength(int length) {
        addCondition(i -> i.toString().length() >= length);
        return this;
    }

    public StringSchema contains(String subString) {
        addCondition(s -> s.toString().contains(subString));
        return this;
    }
}
