package org.w3c.types;

public class Identifier {
    private String mIdentifierAsString;

    public Identifier(String identifierAsString){
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
}
