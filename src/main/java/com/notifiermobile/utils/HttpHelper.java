package com.notifiermobile.utils;

import com.notifiermobile.enums.RequestType;
import com.notifiermobile.exception.RequestException;
import com.notifiermobile.models.Authentication;
import com.notifiermobile.models.IRequestModel;
import com.notifiermobile.models.Notification;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.List;

public class HttpHelper {

    public static final int CONNECTION_TIMEOUT = 5000;
    public static final int HTTP_REQUEST_TIMEOUT = 408;

    public static HttpURLConnection createGetRequest(RequestType requestType,
                                                     Authentication authentication,
                                                     Integer id,
                                                     Integer type,
                                                     Boolean unread,
                                                     Integer fromId) {
        String requestUrl = id != null ? requestType.getUrl() + "/" + id : requestType.getUrl();

        if (authentication != null) {
            requestUrl += "?username=" + authentication.getUsername() + "&secretKey=" + authentication.getSecretKey();
        }

        requestUrl += (type != null) ? "&type=" + type : "";
        requestUrl += (unread != null) ? "&unread=" + unread : "";
        requestUrl += (fromId != null) ? "&fromId=" + fromId : "";

        URL url;
        HttpURLConnection request;
        try {
            url = new URL(requestUrl);
            request = (HttpURLConnection) url.openConnection();
            request.setConnectTimeout(CONNECTION_TIMEOUT);
            request.setRequestMethod(requestType.getMethod());
        } catch (MalformedURLException e) {
            throw new RequestException(e.getMessage());
        } catch (UnsupportedEncodingException e) {
            throw new RequestException(e.getMessage());
        } catch (SocketTimeoutException e) {
            throw new RequestException(HTTP_REQUEST_TIMEOUT, e.getMessage());
        } catch (IOException e) {
            throw new RequestException(e.getMessage());
        }

        return request;
    }

    public static HttpURLConnection createRequest(RequestType requestType,
                                                  Authentication authentication,
                                                  Integer id,
                                                  IRequestModel model) {
        String requestUrl = id != null ? requestType.getUrl() + "/" + id : requestType.getUrl();
        if (authentication != null) {
            requestUrl += "?username=" + authentication.getUsername() + "&secretKey=" + authentication.getSecretKey();
        }

        HttpURLConnection request;
        try {
            URL url = new URL(requestUrl);

            request = (HttpURLConnection) url.openConnection();
            request.setConnectTimeout(CONNECTION_TIMEOUT);
            request.setDoOutput(true);
            request.setDoInput(true);
            request.setRequestMethod(requestType.getMethod());

            if (model != null) {
                request.setRequestProperty("Content-Type", "application/json");
                request.setRequestProperty("Accept", "application/json");
                OutputStream os = request.getOutputStream();
                os.write(model.generateJsonString().getBytes("UTF-8"));
                os.flush();
                os.close();
            }
        } catch (MalformedURLException e) {
            throw new RequestException(e.getMessage());
        } catch (UnsupportedEncodingException e) {
            throw new RequestException(e.getMessage());
        } catch (SocketTimeoutException e) {
            throw new RequestException(HTTP_REQUEST_TIMEOUT, e.getMessage());
        } catch (IOException e) {
            throw new RequestException(e.getMessage());
        }

        return request;
    }

    public static Notification getResponse(HttpURLConnection request) {
        Notification notification = null;
        try {
            String responseString = getResponseString(request);
            if (responseString != null && responseString != "") {
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

    public static String getSecretKeyResponse(HttpURLConnection request) {
        String responseString;
        try {
            responseString = getResponseString(request);
            if (responseString != null) {
                responseString = responseString.replace("\n", "").replace("\"", "");
            }
        } catch (IOException e) {
            throw new RequestException(e.getMessage());
        }

        return responseString;
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
