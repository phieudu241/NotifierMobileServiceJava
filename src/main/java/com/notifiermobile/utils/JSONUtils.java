package com.notifiermobile.utils;

import com.notifiermobile.json.JSONArray;
import com.notifiermobile.json.JSONObject;
import com.notifiermobile.models.Notification;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class JSONUtils {

    public static Notification getNotification(String encodedString) {
        JSONObject result = new JSONObject(encodedString);
        return createNotification(result);
    }

    public static List<Notification> getNotifications(String encodedString) {
        List<Notification> notifications = new ArrayList<Notification>();

        JSONArray results = new JSONArray(encodedString);
        for (Object result : results) {
            notifications.add(createNotification((JSONObject) result));
        }

        return notifications;
    }

    private static Notification createNotification(JSONObject jsonObject) {
        Notification notification = new Notification();
        notification.setId(jsonObject.getInt("Id"));
        notification.setType(jsonObject.getInt("Type"));
        notification.setTitle(jsonObject.getString("Title"));
        notification.setMessage(jsonObject.getString("Message"));
        notification.setUnRead(jsonObject.getBoolean("UnRead"));
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        try {
            notification.setCreateDate(dateFormat.parse(jsonObject.getString("CreateDate")));
        } catch (ParseException e) {
            notification.setCreateDate(null);
        }
        return notification;
    }
}
