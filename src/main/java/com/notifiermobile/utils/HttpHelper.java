package com.notifiermobile.utils;

import com.mysql.jdbc.StringUtils;
import com.notifiermobile.enums.RequestType;
import com.notifiermobile.exception.RequestException;
import com.notifiermobile.models.Authentication;
import com.notifiermobile.models.IRequestModel;
import com.notifiermobile.models.Notification;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class HttpHelper {

    public static HttpURLConnection createGetRequest(RequestType requestType, Authentication authentication,
                                                     Integer id, Integer type, Boolean unread) {
        String requestUrl = id != null ? requestType.getUrl() + "/" + id : requestType.getUrl();

        requestUrl += "?username=" + authentication.getUsername() + "&secretKey=" + authentication.getSecretKey();
        requestUrl += (type != null) ? "&type=" + type : "";
        requestUrl += (unread != null) ? "&unread=" + unread : "";

        URL url;
        HttpURLConnection request;
        try {
            url = new URL(requestUrl);
            request = (HttpURLConnection) url.openConnection();
            request.setDoOutput(true);
            request.setDoInput(true);
            request.setRequestProperty("Method", requestType.getMethod());
        } catch (MalformedURLException e) {
            throw new RequestException(e.getMessage());
        } catch (UnsupportedEncodingException e) {
            throw new RequestException(e.getMessage());
        } catch (IOException e) {
            throw new RequestException(e.getMessage());
        }

        return request;
    }

    public static HttpURLConnection createRequest(RequestType requestType, Authentication authentication, Integer id, IRequestModel model) {
        String requestUrl = id != null ? requestType.getUrl() + "/" + id : requestType.getUrl();
        requestUrl += "?username=" + authentication.getUsername() + "&secretKey=" + authentication.getSecretKey();

        HttpURLConnection request;
        try {
            URL url = new URL(requestUrl);
            request = (HttpURLConnection) url.openConnection();
            request.setDoOutput(true);
            request.setDoInput(true);
            request.setRequestMethod(requestType.getMethod());

            if (model != null) {
                request.setRequestProperty("Content-Type", "application/json");
                request.setRequestProperty("Accept", "application/json");
                OutputStream os = request.getOutputStream();
                os.write(model.generateJsonString().getBytes("UTF-8"));
                os.flush();
            }
        } catch (MalformedURLException e) {
            throw new RequestException(e.getMessage());
        } catch (UnsupportedEncodingException e) {
            throw new RequestException(e.getMessage());
        } catch (IOException e) {
            throw new RequestException(e.getMessage());
        }

        return request;
    }

    public static Notification getResponse(HttpURLConnection request) {
        Notification notification = null;
        try {
            String responseString = getResponseString(request);
            if (!StringUtils.isNullOrEmpty(responseString)) {
                notification = JSONUtils.getNotification(responseString);
            }
        } catch (IOException e) {
            throw new RequestException(e.getMessage());
        }

        return notification;
    }

    public static List<Notification> getResponses(HttpURLConnection request) {
        List<Notification> notifications;
        try {
            String responseString = getResponseString(request);
            notifications = JSONUtils.getNotifications(responseString);
        } catch (IOException e) {
            throw new RequestException(e.getMessage());
        }

        return notifications;
    }

    private static String getResponseString(HttpURLConnection request) throws IOException {
        StringBuilder responseString = new StringBuilder();

        int responseCode = request.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED) {
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));

            String line;
            while ((line = br.readLine()) != null) {
                responseString.append(line + "\n");
            }
            br.close();

        } else {
            throw new RequestException(responseCode);
        }

        return responseString.toString();
    }
}
