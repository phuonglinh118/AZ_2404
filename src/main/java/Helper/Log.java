package Helper;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
    //Initialize Log4j instance
    private static final Logger log = LogManager.getLogger(Log.class);

    //Info Level Logs
    public static void info (String message){
        log.info(message);
    }
    public static void info (Object obj){
        log.info(obj);
    }
    //Warn Level Logs
    public static void warn (String message){
        log.warn(message);
    }
    public static void warn (Object obj){
        log.warn(obj);
    }
    //Error Level Logs
    public static void error (String message){
        log.error(message);
    }
    public static void error (Object obj){
        log.error(obj);
    }
    //Fatal Level Logs
    public static void fatal (String message){
        log.fatal(message);
    }
    //Debug Level Logs
    public static void debug (String message){
        log.debug(message);
    }
    public static void debug (Object obj){
        log.debug(obj);
    }
}
