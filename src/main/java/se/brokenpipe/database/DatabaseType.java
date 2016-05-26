package se.brokenpipe.database;

public enum DatabaseType {
    MYSQL("", ""),
    POSTGRES("jdbc:postgresql://{0}:{1}/{2}", "org.postgresql.Driver"),
    DERBY("", "");

    private final String urlTemplate;
    private final String driver;

    DatabaseType(String urlTemplate, String driver) {
        this.urlTemplate = urlTemplate;
        this.driver = driver;
    }

    public String getUrlTemplate() {
        return urlTemplate;
    }

    public String getDriver() {
        return driver;
    }
}
