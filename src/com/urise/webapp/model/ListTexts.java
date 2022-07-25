package com.urise.webapp.model;

import java.util.List;
import java.util.Objects;

public class ListTexts extends Sections {

    private final List<String> text;

    public ListTexts(List<String> text) {
        Objects.requireNonNull(text);
        this.text = text;
    }

    public List<String> getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListTexts listTexts = (ListTexts) o;
        return text.equals(listTexts.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    @Override
    public String toString() {
        return text.toString();
    }
}
