void method0() { 
public static final String[] openGroupNumericFunctions = { "ABS", "ACOS", "ASIN", "ATAN", "ATAN2", "BITAND", "BITOR", "BITXOR", "CEILING", "COS", "COT", "DEGREES", "EXP", "FLOOR", "LOG", "LOG10", "MOD", "PI", "POWER", "RADIANS", "RAND", "ROUND", "ROUNDMAGIC", "SIGN", "SIN", "SQRT", "TAN", "TRUNCATE" };
public static final String[] openGroupStringFunctions = { "ASCII", "CHAR", "CONCAT", "DIFFERENCE", "HEXTORAW", "INSERT", "LCASE", "LEFT", "LENGTH", "LOCATE", "LTRIM", "RAWTOHEX", "REPEAT", "REPLACE", "RIGHT", "RTRIM", "SOUNDEX", "SPACE", "SUBSTR", "UCASE" };
public static final String[] openGroupDateTimeFunctions = { "CURDATE", "CURTIME", "DATEDIFF", "DAYNAME", "DAYOFMONTH", "DAYOFWEEK", "DAYOFYEAR", "HOUR", "MINUTE", "MONTH", "MONTHNAME", "NOW", "QUARTER", "SECOND", "SECONDS_SINCE_MIDNIGHT", "TIMESTAMPADD", "TIMESTAMPDIFF", "TO_CHAR", "WEEK", "YEAR" };
public static final String[] openGroupSystemFunctions = { "DATABASE", "IFNULL", "USER" };
// 
private static final int FUNC_ISAUTOCOMMIT = 71;
private static final int FUNC_ISREADONLYSESSION = 72;
private static final int FUNC_ISREADONLYDATABASE = 73;
private static final int FUNC_ISREADONLYDATABASEFILES = 74;
private static final int FUNC_DATABASE = 75;
private static final int FUNC_IDENTITY = 76;
private static final int FUNC_SYSDATE = 77;
private static final int FUNC_TIMESTAMPADD = 78;
private static final int FUNC_TIMESTAMPDIFF = 79;
private static final int FUNC_TRUNCATE = 80;
private static final int FUNC_TO_CHAR = 81;
private static final int FUNC_TIMESTAMP = 82;
private static final int FUNC_CRYPT_KEY = 83;
private static final int FUNC_ISOLATION_LEVEL = 85;
private static final int FUNC_SESSION_ISOLATION_LEVEL = 86;
private static final int FUNC_DATABASE_ISOLATION_LEVEL = 87;
private static final int FUNC_TRANSACTION_CONTROL = 88;
private static final int FUNC_TIMEZONE = 89;
private static final int FUNC_SESSION_TIMEZONE = 90;
private static final int FUNC_DATABASE_TIMEZONE = 91;
private static final int FUNC_DATABASE_VERSION = 92;
// 
private static final int FUNC_ACOS = 101;
private static final int FUNC_ASIN = 102;
private static final int FUNC_ATAN = 103;
private static final int FUNC_ATAN2 = 104;
private static final int FUNC_COS = 105;
private static final int FUNC_COT = 106;
private static final int FUNC_DEGREES = 107;
private static final int FUNC_LOG10 = 110;
private static final int FUNC_PI = 111;
private static final int FUNC_RADIANS = 112;
private static final int FUNC_RAND = 113;
private static final int FUNC_ROUND = 114;
private static final int FUNC_SIGN = 115;
private static final int FUNC_SIN = 116;
private static final int FUNC_TAN = 117;
private static final int FUNC_BITAND = 118;
private static final int FUNC_BITOR = 119;
private static final int FUNC_BITXOR = 120;
private static final int FUNC_ROUNDMAGIC = 121;
private static final int FUNC_ASCII = 122;
private static final int FUNC_CHAR = 123;
private static final int FUNC_CONCAT = 124;
private static final int FUNC_DIFFERENCE = 125;
private static final int FUNC_HEXTORAW = 126;
private static final int FUNC_LEFT = 128;
private static final int FUNC_LOCATE = 130;
private static final int FUNC_LTRIM = 131;
private static final int FUNC_RAWTOHEX = 132;
private static final int FUNC_REPEAT = 133;
private static final int FUNC_REPLACE = 134;
private static final int FUNC_REVERSE = 135;
private static final int FUNC_RIGHT = 136;
private static final int FUNC_RTRIM = 137;
private static final int FUNC_SOUNDEX = 138;
private static final int FUNC_SPACE = 139;
private static final int FUNC_SUBSTR = 140;
private static final int FUNC_DATEADD = 141;
private static final int FUNC_DATEDIFF = 142;
private static final int FUNC_SECONDS_MIDNIGHT = 143;
private static final int FUNC_REGEXP_MATCHES = 144;
// 
static final IntKeyIntValueHashMap customRegularFuncMap = new IntKeyIntValueHashMap();
static final IntKeyIntValueHashMap customValueFuncMap = new IntKeyIntValueHashMap();
private int extractSpec;
private String matchPattern;
private Pattern pattern;
}