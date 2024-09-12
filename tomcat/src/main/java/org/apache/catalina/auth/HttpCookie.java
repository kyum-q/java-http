package org.apache.catalina.auth;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class HttpCookie {

    private static final String AUTH_COOKIE_KEY = "JSESSIONID";
    private final Map<String, String> cookies;

    public HttpCookie(Map<String, String> cookies) {
        this.cookies = new ConcurrentHashMap<>(cookies);
    }

    public void addCookie(String key, String value) {
        cookies.put(key, value);
    }

    public void addAuthCookie(String value) {
        if (cookies.containsKey(AUTH_COOKIE_KEY)) {
            return;
        }
        cookies.put(AUTH_COOKIE_KEY, value);
    }

    public String getCookie(String key) {
        if (cookies.containsKey(key)) {
            return cookies.get(key);
        }
        return "";
    }

    public String getAuthCookie() {
        if (cookies.containsKey(AUTH_COOKIE_KEY)) {
            return cookies.get(AUTH_COOKIE_KEY);
        }
        return "";
    }

    @Override
    public String toString() {
        return cookies.entrySet().stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.joining("; "));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HttpCookie that = (HttpCookie) o;
        return Objects.equals(cookies, that.cookies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cookies);
    }
}
