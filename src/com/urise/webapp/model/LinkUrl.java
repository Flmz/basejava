package com.urise.webapp.model;

import java.util.Objects;

public class LinkUrl {
    private final String url;

    public LinkUrl(String url) {
        Objects.requireNonNull(url);
        this.url = url;

    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkUrl linkUrl = (LinkUrl) o;
        return url.equals(linkUrl.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url);
    }
}
