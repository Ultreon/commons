package com.ultreon.commons.lang;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.io.Serializable;
import java.util.Objects;

/**
 * Percentage utility object.
 *
 * @author Qboi
 * @since 1.0.0
 */
public final class Percentage implements Serializable, Comparable<Percentage> {
    private static final long serialVersionUID = 0L;
    private final double percentage;

    /**
     *
     */
    public Percentage(double percentage) {
        this.percentage = percentage;
    }

    public static Percentage toPercentage(double value) {
        return new Percentage(value * 100);
    }

    public double value() {
        return percentage / 100;
    }

    @Override
    public int compareTo(@NonNull Percentage o) {
        return Double.compare(percentage, o.percentage);
    }

    public double percentage() {
        return percentage;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Percentage that = (Percentage) obj;
        return Double.doubleToLongBits(this.percentage) == Double.doubleToLongBits(that.percentage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(percentage);
    }

    @Override
    public String toString() {
        return "Percentage[" +
                "percentage=" + percentage + ']';
    }

}
