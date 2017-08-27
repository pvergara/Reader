package org.w3c.types;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import org.ecos.core.interfaces.AsString;

@XStreamAlias("id")
public class Identifier implements AsString {
    public static Identifier Empty = from("");

    public static Identifier from(String identifierAsString) {
        return new Identifier(identifierAsString);
    }

    private String mIdentifierAsString;

    private Identifier(String identifierAsString){
        mIdentifierAsString = identifierAsString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Identifier that = (Identifier) o;

        return mIdentifierAsString.equals(that.mIdentifierAsString);
    }

    @Override
    public int hashCode() {
        return mIdentifierAsString.hashCode();
    }

    @Override
    public String toString() {
        return "Identifier{" +
                "mIdentifierAsString='" + mIdentifierAsString + '\'' +
                '}';
    }

    public String asString() {
        return mIdentifierAsString;
    }
}