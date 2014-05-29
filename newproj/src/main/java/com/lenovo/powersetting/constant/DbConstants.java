package com.lenovo.powersetting.constant;

/**
 * Some constants about db
 * just sample
 */
public final class DbConstants {

    public static final String DB_NAME = "powersetting.db";
    public static final int DB_VERSION = 1;

    private static final String TERMINATOR = ";";

    /**
     * image sdcard cache table *
     */
    public static final StringBuffer CREATE_SAMPLE_TABLE_SQL = new StringBuffer();
    public static final String SAMPLE_TABLE_TABLE_NAME = "sample_table";
    public static final String SAMPLE_TABLE_ID = android.provider.BaseColumns._ID;
    public static final String SAMPLE_TABLE_TAG = "tag";
    public static final String SAMPLE_TABLE_URL = "url";
    public static final String SAMPLE_TABLE_PATH = "path";
    public static final String SAMPLE_TABLE_ENTER_TIME = "enter_time";
    public static final String SAMPLE_TABLE_LAST_USED_TIME = "last_used_time";
    public static final String SAMPLE_TABLE_USED_COUNT = "used_count";
    public static final String SAMPLE_TABLE_PRIORITY = "priority";
    public static final String SAMPLE_TABLE_IS_EXPIRED = "is_expired";
    public static final String SAMPLE_TABLE_IS_FOREVER = "is_forever";


    static {
        /**
         * sql to image sdcard cache table
         **/
        CREATE_SAMPLE_TABLE_SQL.append("CREATE TABLE ").append(SAMPLE_TABLE_TABLE_NAME);
        CREATE_SAMPLE_TABLE_SQL.append(" (").append(SAMPLE_TABLE_ID)
                .append(" integer primary key autoincrement,");
        CREATE_SAMPLE_TABLE_SQL.append(SAMPLE_TABLE_TAG).append(" text,");
        CREATE_SAMPLE_TABLE_SQL.append(SAMPLE_TABLE_URL).append(" text,");
        CREATE_SAMPLE_TABLE_SQL.append(SAMPLE_TABLE_PATH).append(" text,");
        CREATE_SAMPLE_TABLE_SQL.append(SAMPLE_TABLE_ENTER_TIME).append(" integer,");
        CREATE_SAMPLE_TABLE_SQL.append(SAMPLE_TABLE_LAST_USED_TIME).append(" integer,");
        CREATE_SAMPLE_TABLE_SQL.append(SAMPLE_TABLE_USED_COUNT).append(" integer,");
        CREATE_SAMPLE_TABLE_SQL.append(SAMPLE_TABLE_PRIORITY).append(" integer,");
        CREATE_SAMPLE_TABLE_SQL.append(SAMPLE_TABLE_IS_EXPIRED).append(" integer,");
        CREATE_SAMPLE_TABLE_SQL.append(SAMPLE_TABLE_IS_FOREVER).append(" integer)");
        CREATE_SAMPLE_TABLE_SQL.append(TERMINATOR);

    }
}
