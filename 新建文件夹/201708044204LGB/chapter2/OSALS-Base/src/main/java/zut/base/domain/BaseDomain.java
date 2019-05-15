package zut.base.domain;

import java.io.Serializable;

public abstract class BaseDomain implements Serializable {
    public abstract boolean equals(Object o);

    /**
     * When you override equals, you should override hashCode. See "Why are equals()
     * and hashCode() importation" for more information:
     * http://www.hibernate.org/109.html
     *
     * @return hashCode
     */
    public abstract int hashCode();

    /**
     * Returns a multi-line String with key=value pairs.
     *
     * @return a String representation of this class.
     */
    public abstract String toString();
}
