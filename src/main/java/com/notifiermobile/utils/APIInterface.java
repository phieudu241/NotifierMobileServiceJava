package com.notifiermobile.utils;

public class APIInterface {
    //private static static String API_URL = "http://notifiermobile.com/api/notifier";
    public static final String DOMAIN_URL = "http://192.168.1.5:8282";
    public static final String API_URL = DOMAIN_URL + "/api/notifications";
    public static final String API_USER_URL = DOMAIN_URL + "/api/user";
    public static final String GET_URL = API_URL;
    public static final String ADD_URL = API_URL;
    public static final String UPDATE_URL = API_URL;
    public static final String DELETE_URL = API_URL;
    public static final String MARK_AS_READ_URL = API_URL + "/markAsRead";
    public static final String AUTHENTICATION = API_USER_URL + "/login";
    public static final String DONATION = DOMAIN_URL + "/donate";
}
