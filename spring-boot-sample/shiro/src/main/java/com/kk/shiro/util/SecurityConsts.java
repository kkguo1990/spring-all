package com.kk.shiro.util;

public class SecurityConsts {

    public static final String REQUEST_AUTH_HEADER = "authentication";

    public static final String CURRENT_TIME_MILLIS="current-time-millis";

    public static final String ACCOUNT="account";

    public static final long TOKEN_TIME_MAX = 10*60*1000;

    public static final long TOKEN_TIME_MIN =5*60*1000;

    public static final String REDIS_PREFIX = "redis_prefix_token";

}
