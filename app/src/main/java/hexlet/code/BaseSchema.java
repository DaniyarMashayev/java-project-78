package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema<T> {

    private List<Predicate> totalCondition = new ArrayList<>();
    private boolean check;

    public final void setRequiredOn() {
        check = true;
    }
    public final Boolean isValid(Object obj) {
        if (obj == null) {
            return !check;
        }
        for (Predicate total: totalCondition) {
            if (!total.test(obj)) {
                return false;
            }
        }
        return true;
    }

    public final void addCondition(Predicate condition) {
        totalCondition.add(condition);
    }
}
