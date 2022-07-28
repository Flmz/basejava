package com.urise.webapp.model;

import java.util.List;
import java.util.Objects;

public class Organization extends OrganizationSection {
    private final String nameOrganization;
    private final List<Period> periods;

    public Organization(List<Organization> listOrganization, String nameOrganization, List<Period> periods) {
        super(listOrganization);
        Objects.requireNonNull(nameOrganization);
        this.nameOrganization = nameOrganization;
        this.periods = periods;
    }

    public String getNameOrganization() {
        return nameOrganization;
    }

    public List<Period> getPeriods() {
        return periods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return nameOrganization.equals(that.nameOrganization) && periods.equals(that.periods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOrganization, periods);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "nameOrganization='" + nameOrganization + '\'' +
                ", periods=" + periods +
                '}';
    }
}
