package org.ecos.epub.pojos.toc;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.ecos.reader.core.exceptions.ConversionException;
import org.w3c.types.Identifier;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@XStreamAlias("navPoint")
public class NavigationPoint extends AbstractCollection<NavigationPoint> {

    @XStreamAsAttribute
    @XStreamAlias("id")
    private String mIdAsString;

    @XStreamAsAttribute
    @XStreamAlias("playOrder")
    private String mPlayOrder;

    @XStreamAsAttribute
    @XStreamAlias("class")
    private String mClass;

    @XStreamAlias("navLabel")
    private NavigationLabel mNavigationLabel;

    @XStreamAlias("content")
    private Content mContent;


    @XStreamImplicit
    private List<NavigationPoint> mInnerNavigationPoints;

    public NavigationPoint() {
        setNewCollectionIfNull();
    }

    public List<NavigationPoint> getInnerNavigationPoints() {
        setNewCollectionIfNull();

        return mInnerNavigationPoints;
    }

    private void setNewCollectionIfNull() {
        if (mInnerNavigationPoints == null)
            mInnerNavigationPoints = new ArrayList<>();
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public Iterator<NavigationPoint> iterator() {
        return mInnerNavigationPoints.iterator();
    }

    @Override
    public int size() {
        return mInnerNavigationPoints.size();
    }

    @Override
    public boolean add(NavigationPoint navigationPoint) {
        return mInnerNavigationPoints.add(navigationPoint);
    }

    public String getLabel() {
        return mNavigationLabel.asString();
    }

    public Identifier getId() {
        if (mIdAsString == null)
            return Identifier.Empty;

        return Identifier.from(mIdAsString);
    }

    public boolean isOrderANumber() {
        return StringUtils.isNumeric(mPlayOrder);
    }

    public Long getPlayOrderAsLong() throws ConversionException {
        try {
            return NumberUtils.createLong(mPlayOrder);
        } catch (NumberFormatException ignore) {
            throw new ConversionException(String.format("There's no way to convert %s to a long", mPlayOrder));
        }

    }

    public String getPlayOrderAsString() {
        return mPlayOrder;
    }

    public Content getContent() {
        return mContent;
    }
}