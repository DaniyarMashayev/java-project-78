package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StringSchema {
    private final List<Predicate> totalCondition;

    public StringSchema() {
        totalCondition = new ArrayList<>();
    }

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

    public Boolean isValid(String obj) {
        for (Predicate total : totalCondition) {
            if (!total.test(obj)) {
                return false;
            }
        }
        return true;
    }
    private void addCondition(Predicate condition) {
        totalCondition.add(condition);
    }
}
