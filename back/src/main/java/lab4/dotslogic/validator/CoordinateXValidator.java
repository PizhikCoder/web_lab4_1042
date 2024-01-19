package lab4.dotslogic.validator;

import lab4.dotslogic.interfaces.IValidator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("xValidator")
public class CoordinateXValidator implements IValidator<Float> {
    private final short X_MIN_VALUE = -4;

    private final short X_MAX_VALUE = 4;

    @Override
    public boolean validate(Float x) {
        return x != null && x >= X_MIN_VALUE && x <= X_MAX_VALUE;
    }
}
