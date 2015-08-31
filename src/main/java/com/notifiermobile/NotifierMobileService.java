package com.notifiermobile;

import com.notifiermobile.enums.RequestType;
import com.notifiermobile.models.AddModel;
import com.notifiermobile.models.Authentication;
import com.notifiermobile.models.Notification;
import com.notifiermobile.models.UpdateModel;
import com.notifiermobile.utils.HttpHelper;

import java.net.HttpURLConnection;
import java.util.List;

public class NotifierMobileService {

    /**
     * Get all notifications
     *
     * @param authentication
     * @return
     */
    public static List<Notification> getAll(Authentication authentication) {
        return getAll(authentication, null, null);
    }

    /**
     * Get notifications by type
     *
     * @param authentication
     * @param type
     * @return
     */
    public static List<Notification> getAll(Authentication authentication, Integer type) {
        return getAll(authentication, type, null);
    }

    /**
     * Get notifications by unread
     *
     * @param authentication
     * @param unread
     * @return
     */
    public static List<Notification> getAll(Authentication authentication, Boolean unread) {
        return getAll(authentication, null, unread);
    }

    /**
     * Get notifications by type and unread
     *
     * @param authentication
     * @param type
     * @param unread
     * @return
     */
    public static List<Notification> getAll(Authentication authentication, Integer type, Boolean unread) {
        HttpURLConnection request = HttpHelper.createGetRequest(RequestType.GET_ALL, authentication, null, type, unread);
        List<Notification> notifications = HttpHelper.getResponses(request);
        return notifications;
    }

    /**
     * Get notification by id
     *
     * @param id
     * @param authentication
     * @return
     */
    public static Notification get(int id, Authentication authentication) {
        HttpURLConnection request = HttpHelper.createGetRequest(RequestType.GET, authentication, id, null, null);
        Notification notification = HttpHelper.getResponse(request);
        return notification;
    }

    /**
     * Add a notification
     *
     * @param authentication
     * @param model
     */
    public static void add(Authentication authentication, AddModel model) {
        HttpURLConnection request = HttpHelper.createRequest(RequestType.ADD, authentication, null, model);
        HttpHelper.getResponse(request);
    }

    /**
     * Update notification
     *
     * @param id
     * @param authentication
     * @param model
     */
    public static void update(int id, Authentication authentication, UpdateModel model) {
        HttpURLConnection request = HttpHelper.createRequest(RequestType.UPDATE, authentication, id, model);
        HttpHelper.getResponse(request);
    }

    /**
     * Delete notification
     *
     * @param id
     * @param authentication
     */
    public static void delete(int id, Authentication authentication) {
        HttpURLConnection request = HttpHelper.createRequest(RequestType.DELETE, authentication, id, null);
        HttpHelper.getResponse(request);
    }

    /**
     * Mark a notification as read
     *
     * @param id
     * @param authentication
     */
    public static void markAsRead(int id, Authentication authentication) {
        HttpURLConnection request = HttpHelper.createRequest(RequestType.MARK_AS_READ, authentication, id, null);
        HttpHelper.getResponse(request);
    }
}
