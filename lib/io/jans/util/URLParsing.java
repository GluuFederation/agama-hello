package io.jans.util;

import io.jans.service.cdi.util.CdiUtil;
import jakarta.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class URLParsing {
    private static Logger LOG = LoggerFactory.getLogger(URLParsing.class);

    public static String getRedirectUri() {
        final String redirect_uri = "redirect_uri";
        HttpServletRequest req = CdiUtil.bean(HttpServletRequest.class);

        if (req != null) {
            String URI =  req.getScheme() + "://" + req.getServerName() + req.getRequestURI() + (req.getQueryString() != null ? "?" + req.getQueryString() : "");
            return URI;
        }
        else {
            LOG.debug("Request url is missing...");
            return "";
        }
    }

}