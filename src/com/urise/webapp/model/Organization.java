package com.urise.webapp.model;

import java.util.List;
import java.util.Objects;

public class Organization {
    private final String name;
    private final List<Period> periods;

    public Organization(String name, List<Period> periods) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(periods);
        this.name = name;
        this.periods = periods;
    }

    public String getName() {
        return name;
    }

    public List<Period> getPeriods() {
        return periods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return name.equals(that.name) && periods.equals(that.periods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, periods);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "nameOrganization='" + name + '\'' +
                ", periods=" + periods +
                '}';
    }
}
