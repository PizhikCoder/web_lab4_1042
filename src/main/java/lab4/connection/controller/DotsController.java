package lab4.connection.controller;


import lab4.connection.HttpCodes;
import lab4.connection.dto.DotDTO;
import lab4.database.service.interfaces.IDotsService;
import lab4.dotslogic.checkers.DotChecker;
import lab4.exception.DotLimitsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("https://localhost:3000")
public class DotsController {
    private final short NANOS_IN_MICRO= 1000;
    private IDotsService dotsService;

    private final DotChecker dotChecker;

    @Autowired
    public DotsController(IDotsService dotsService, DotChecker dotChecker) {
        this.dotsService = dotsService;
        this.dotChecker = dotChecker;
    }

    @GetMapping("/checkDot")
    public ResponseEntity<DotDTO> checkDot(DotDTO dot){
        try{
            final String execTime;
            long startTime = System.nanoTime();
            dot.setResult(dotChecker.checkHit(dot));
            execTime = String.valueOf((System.nanoTime() - startTime) / NANOS_IN_MICRO);
            dot.setExecTime(execTime);
            return ResponseEntity.ok(dot);
        }
        catch (DotLimitsException dotLimitsException){
            return ResponseEntity.status(HttpCodes.WRONG_DOT_LIMITS.getCode()).body(dot);
        }
    }
}
