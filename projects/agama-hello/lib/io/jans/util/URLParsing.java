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

    public static Map<String, String> extractParametersFromUrl(String urlString) {
        Map<String, String> parameters = new HashMap<>();

        try {
            URL url = new URL(urlString);
            String query = url.getQuery();
            if (query != null) {
                String[] pairs = query.split("&");
                for (String pair : pairs) {
                    String[] keyValue = pair.split("=");
                    if (keyValue.length == 2) {
                        String key = keyValue[0];
                        String value = keyValue[1];
                        parameters.put(key, value);
                    }
                }
            }
        } catch (Exception e) {
            LOG.debug(e);
            e.printStackTrace();
        }
        return parameters;
    }
}