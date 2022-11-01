package CustomException;

public class LogInFailureException extends Exception{
    public LogInFailureException(String s)
    {
        super(s);
    }
}
