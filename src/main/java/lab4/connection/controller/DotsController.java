package lab4.connection.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lab4.connection.HttpCodes;
import lab4.connection.RequestAttribute;
import lab4.connection.dto.DotDTO;
import lab4.database.entity.DotEntity;
import lab4.database.service.interfaces.IDotsService;
import lab4.dotslogic.checkers.DotChecker;
import lab4.exception.DotLimitsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dots")
public class DotsController {
    private final short NANOS_IN_MICRO = 1000;
    private final IDotsService dotsService;

    private final DotChecker dotChecker;

    @Autowired
    public DotsController(IDotsService dotsService, DotChecker dotChecker) {
        this.dotsService = dotsService;
        this.dotChecker = dotChecker;
    }

    @GetMapping("/checkDot")
    public ResponseEntity<DotDTO> checkDot(DotDTO dot, HttpSession session){
        try{
            final String execTime;
            long startTime = System.nanoTime();
            dot.setResult(dotChecker.checkHit(dot));
            execTime = String.valueOf((System.nanoTime() - startTime) / NANOS_IN_MICRO);
            dot.setExecTime(execTime);
            dot.setOwnerLogin(session.getAttribute(RequestAttribute.USERNAME.getName()).toString());
            dotsService.saveDot(new DotEntity(dot));
            return ResponseEntity.ok(dot);
        }
        catch (DotLimitsException dotLimitsException){
            return ResponseEntity.status(HttpCodes.WRONG_DOT_LIMITS.getCode()).body(dot);
        }
    }

    @GetMapping("/recheckDot")
    public ResponseEntity<DotDTO> recheckDot(DotDTO dot){
        try{
            dot.setResult(dotChecker.checkHit(dot));
            return ResponseEntity.ok(dot);
        }
        catch (DotLimitsException dotLimitsException){
            return ResponseEntity.status(HttpCodes.WRONG_DOT_LIMITS.getCode()).body(dot);
        }
    }

    @GetMapping("/clearDots")
    public void clearDots(HttpServletRequest request){
        String username = request.getParameter(RequestAttribute.USERNAME.getName());
        if (username != null && !username.isEmpty()){
            dotsService.clearDots(username);
        }
    }

    @GetMapping("/getAllDots")
    public ResponseEntity<DotDTO[]> getAllDots(HttpServletRequest request) {
        String username = request.getParameter(RequestAttribute.USERNAME.getName());
        if (username != null && !username.isEmpty()) {
            DotDTO[] dots = dotsService.getAllDots(username).stream().map(DotDTO::new).toArray(DotDTO[]::new);
            return ResponseEntity.ok(dots);
        }
        return ResponseEntity.status(HttpCodes.UNKNOWN_USER.getCode()).build();
    }
}
