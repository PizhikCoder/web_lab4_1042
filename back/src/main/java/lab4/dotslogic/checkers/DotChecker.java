package lab4.dotslogic.checkers;


import lab4.connection.dto.DotDTO;
import lab4.dotslogic.interfaces.IValidator;
import lab4.exception.DotLimitsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
public class DotChecker {
    private final IValidator<Float> xValidator;
    private final IValidator<Float> yValidator;
    private final IValidator<Float> rValidator;
    private final AreaChecker areaChecker;

    public DotChecker(@Qualifier("xValidator") IValidator<Float> xValidator,
                      @Qualifier("yValidator") IValidator<Float> yValidator,
                      @Qualifier("rValidator") IValidator<Float> rValidator,
                      @Autowired AreaChecker areaChecker) {
        this.xValidator = xValidator;
        this.yValidator = yValidator;
        this.rValidator = rValidator;
        this.areaChecker = areaChecker;
    }

    public boolean checkHit(DotDTO dot) throws DotLimitsException {
        if (xValidator.validate(dot.getX())
                && yValidator.validate(dot.getY())
                && rValidator.validate(dot.getR())){
            return areaChecker.check(dot);
        }
        throw new DotLimitsException();
    }
}
