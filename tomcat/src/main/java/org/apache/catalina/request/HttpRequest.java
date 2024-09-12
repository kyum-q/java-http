package org.apache.catalina.request;

import java.util.Map;

import org.apache.catalina.auth.HttpCookie;
import org.apache.catalina.http.VersionOfProtocol;

public class HttpRequest {
    private final RequestLine requestLine;
    private final RequestHeader requestHeader;
    private final RequestBody requestBody;

    public HttpRequest(RequestLine requestLine, RequestHeader requestHeader, RequestBody requestBody) {
        this.requestLine = requestLine;
        this.requestHeader = requestHeader;
        this.requestBody = requestBody;
    }

    public boolean checkQueryParamIsEmpty() {
        return requestLine.checkQueryParamIsEmpty();
    }

    public boolean isSameHttpMethod(HttpMethod httpMethod) {
        return requestLine.isSameHttpMethod(httpMethod);
    }

    public VersionOfProtocol getVersionOfProtocol() {
        return requestLine.getVersionOfProtocol();
    }

    public String getPathWithoutQuery() {
        return requestLine.getPathWithoutQuery();
    }

    public Map<String, String> getQueryParam() {
        return requestLine.getQueryParam();
    }

    public Map<String, String> getBody() {
        return requestBody.getBody();
    }

    public String getFileType() {
        return requestHeader.getFileType();
    }

    public HttpCookie getCookie() {
        return requestHeader.getCookie();
    }
}
