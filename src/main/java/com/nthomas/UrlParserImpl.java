package com.nthomas;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UrlParserImpl implements UrlParser {

    String hosts;
    Set<String> hostList;
    private Set<String> getWhiteListedHosts() {
        if (hostList == null) {
            if (hosts == null && !(hosts.length() > 0)) {
                return Collections.emptySet();
            } else {
                Collections.addAll(hostList = new HashSet<>(), hosts.split(","));
                hostList.forEach(String::trim);
                for (String path : hostList) {
                    hostList.add(hostOnly(path));
                }
            }
        }
        return hostList;
    }

    public void setWhiteListedHosts(String list) {
        hosts = list;
    }

    private static String hostOnly(String URL) {
        final String prefix_http = "http";
        final String prefix_https = "https";
        if (URL.contains(prefix_http)) {
            return URL.substring(URL.indexOf(prefix_http + prefix_separator.length() + prefix_http.length()));
        } else if (URL.contains(prefix_https)) {
            return URL.substring(URL.indexOf(prefix_https + prefix_separator.length() + prefix_http.length()));
        }
        return URL;
    }

    @Override
    public Boolean willMatch(String url) {
        String host = getHost(url);
        if (getWhiteListedHosts().contains(host)) {
            return true;
        } else {
            return false;
        }
    }

    private static final String prefix_separator = "://";

    private static String getHost(String path) {
        return path.substring(path.indexOf(prefix_separator + prefix_separator.length()));
    }
}
