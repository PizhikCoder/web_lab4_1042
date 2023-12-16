package lab4.dotslogic.checkers;

import lab4.connection.dto.DotDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
public class AreaChecker {
    public boolean check(DotDTO dot) {
        return checkFirstQuarter(dot.getX(), dot.getY(), dot.getR())
                || checkSecondQuarter(dot.getX(), dot.getY(), dot.getR())
                || checkThirdQuarter(dot.getX(), dot.getY(), dot.getR())
                || checkFourthQuarter(dot.getX(), dot.getY(), dot.getR());
    }

    protected boolean checkFirstQuarter(final short x, final short y, final short r) {
        return (x * x + y * y <= r) && (x <= 0) && (y >= 0);
    }

    protected boolean checkSecondQuarter(final short x, final short y, final short r) {
        return (x >= 0 && x <= r) && (y >= 0 && y <= r);
    }

    protected boolean checkThirdQuarter(final short x, final short y, final short r) {
        return (y >= x - r) && y <= 0 && x >= 0;
    }

    private boolean checkFourthQuarter(long x, long y, long r) {
        return false;
    }

}
