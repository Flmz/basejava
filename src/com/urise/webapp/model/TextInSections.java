package com.urise.webapp.model;

import java.util.Objects;

public class TextInSections extends Sections {
    private final String text;

    public TextInSections(String text) {
        Objects.requireNonNull(text, "Text cant be null");
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextInSections that = (TextInSections) o;
        return text.equals(that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
