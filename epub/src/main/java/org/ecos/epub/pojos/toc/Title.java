package org.ecos.epub.pojos.toc;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class Title {
    @XStreamAlias("text")
    private String mText;

    private Title(String textAsString) {
        mText = textAsString;
    }

    @SuppressWarnings("SameParameterValue")
    public static Title fromText(String textAsString) {
        return new Title(textAsString);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Title title = (Title) o;

        return mText.equals(title.mText);
    }

    @Override
    public int hashCode() {
        return mText.hashCode();
    }

    @Override
    public String toString() {
        return "Title{" +
                "mText='" + mText + '\'' +
                '}';
    }
}
