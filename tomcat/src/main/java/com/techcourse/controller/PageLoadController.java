package com.techcourse.controller;

import org.apache.catalina.mvc.AbstractController;
import org.apache.catalina.reader.FileReader;
import org.apache.catalina.request.HttpRequest;
import org.apache.catalina.response.HttpResponse;
import org.apache.catalina.response.HttpStatus;
import org.apache.catalina.response.StatusLine;

public class PageLoadController extends AbstractController {

    @Override
    public boolean isMatchesRequest(HttpRequest request) {
        return request.getPath().endsWith(".css") ||
                request.getPath().endsWith(".js") ||
                request.getPath().endsWith(".html");
    }

    @Override
    public HttpResponse doGet(HttpRequest request) {
        return new HttpResponse(
                new StatusLine(request.getVersionOfProtocol(), HttpStatus.OK),
                request.getContentType(),
                FileReader.loadFileContent(request.getPathWithoutQuery()));
    }
}
