package driver_manager;

public class DriverManagerFactory {
    public static DriverManager getDriverManager(DriverType type) {
        DriverManager driverManager;
        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
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
}
