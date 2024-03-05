package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema<T> {

    private final List<Predicate> totalCondition;

    public BaseSchema() {
        totalCondition = new ArrayList<>();
    }

    public Boolean isValid(Object obj) {
        for (Predicate total: totalCondition) {
            if (!total.test(obj)) {
                return false;
            }
        }
        return true;
    }

    public void addCondition(Predicate condition) {
        totalCondition.add(condition);
    }
}
