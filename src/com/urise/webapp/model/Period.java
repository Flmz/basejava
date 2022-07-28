package com.urise.webapp.model;

import java.util.Date;
import java.util.Objects;

public class Period {
    private final Date startDate;
    private final Date endDate;
    private final String description;

    public Period(Date startDate, Date endDate, String description) {
        Objects.requireNonNull(startDate);
        Objects.requireNonNull(description);
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Period period = (Period) o;
        return startDate.equals(period.startDate) && endDate.equals(period.endDate) && description.equals(period.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate, description);
    }

    @Override
    public String toString() {
        return "Period{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", description='" + description + '\'' +
                '}';
    }
}
