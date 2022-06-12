package util;

import java.util.ResourceBundle;


public class Util {

    public static final String DATABASE_RESOURCE = "database";

    public static final String URL_KEY = "url";
    public static final String USER_KEY = "username";
    public static final String PASSWORD_KEY = "password";

    private static final ResourceBundle resource = ResourceBundle.getBundle(DATABASE_RESOURCE);

    public static final String getValue(String key) {
        return resource.getString(key);
    }

    public static final String URL = Util.getValue(URL_KEY);
    public static final String USER = Util.getValue(USER_KEY);
    public static final String PASSWORD = Util.getValue(PASSWORD_KEY);

}
