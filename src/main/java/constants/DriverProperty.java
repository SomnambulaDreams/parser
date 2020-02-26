package constants;


public enum DriverProperty {

    FILE_PATH   ("driver.properties"),
    BROWSER     ("browser"),
    VERSION     ("version");

    public final String value;


    DriverProperty(String value) {
        this.value = value;
    }
}