package lab4.dotslogic.checkers;

import lab4.connection.dto.DotDTO;
import org.springframework.stereotype.Component;

@Component
public class AreaChecker {
    public boolean check(DotDTO dot) {
        return checkFirstQuarter(dot.getX(), dot.getY(), dot.getR())
                || checkSecondQuarter(dot.getX(), dot.getY(), dot.getR())
                || checkThirdQuarter(dot.getX(), dot.getY(), dot.getR())
                || checkFourthQuarter(dot.getX(), dot.getY(), dot.getR());
    }

    protected boolean checkFirstQuarter(final float x, final float y, final float r) {
        return (x >= 0 && x <= r) && (y >= 0 && y <= r);
    }

    protected boolean checkSecondQuarter(final float x, final float y, final float r) {
        return (x * x + y * y <= r*r) && (x <= 0) && (y >= 0);
    }

    protected boolean checkThirdQuarter(final float x, final float y, final float r) {
        return false;
    }

    protected boolean checkFourthQuarter(final float x, final float y, final float r) {
        return (y >= x - r) && y <= 0 && x >= 0;
    }

}
