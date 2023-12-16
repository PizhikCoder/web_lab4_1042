package lab4.dotslogic.validator;

import lab4.dotslogic.interfaces.Validator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
@Qualifier("xValidator")
public class CoordinateXValidator implements Validator<Short> {
    private final short X_MIN_VALUE = -4;

    private final short X_MAX_VALUE = 4;

    @Override
    public boolean validate(Short x) {
        return x >= X_MIN_VALUE && x <= X_MAX_VALUE;
    }
}
