package lab4.dotslogic.validator;

import lab4.dotslogic.interfaces.Validator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
@Qualifier("rValidator")
public class RValidator implements Validator<Short> {

    private final short R_MIN_VALUE = -4;

    private final short R_MAX_VALUE = 4;

    @Override
    public boolean validate(Short r) {
        return r >= R_MIN_VALUE && r <= R_MAX_VALUE;
    }
}