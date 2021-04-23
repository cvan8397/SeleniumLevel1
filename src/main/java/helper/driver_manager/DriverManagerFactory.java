package helper.driver_manager;

public class DriverManagerFactory {
    public static DriverManager getDriverManager(DriverType driverType) {
        DriverManager driverManager;
        switch (driverType) {
            case IE:
                driverManager = new IEDriverManager();
                break;
            case FIREFOX:
                driverManager = new FireFoxManager();
                break;
            default:
                driverManager = new ChromeDriverManager();
                break;
        }
        return driverManager;
    }
    public enum DriverType {
        CHROME, FIREFOX, IE;
    }
}
