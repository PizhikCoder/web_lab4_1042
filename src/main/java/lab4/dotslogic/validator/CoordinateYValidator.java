package lab4.dotslogic.validator;

import lab4.dotslogic.interfaces.IValidator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
@Qualifier("yValidator")
public class CoordinateYValidator implements IValidator<Short> {

    private final short Y_MIN_VALUE = -5;

    private final short Y_MAX_VALUE = 3;

    @Override
    public boolean validate(Short y) {
        return y != null && y >= Y_MIN_VALUE && y <= Y_MAX_VALUE;
    }
}
