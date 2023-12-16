package lab4.exception;

public class DotLimitsException extends Exception{
    public DotLimitsException(){
        super("Dot's param was not in the limits!");
    }
}
