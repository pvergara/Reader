package org.ecos.epub.pojos.toc;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import org.w3c.types.Identifier;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;

@XStreamAlias("navPoint")
public class NavigationPoint  extends AbstractCollection<NavigationPoint> {
    @XStreamAlias("navLabel")
    private NavigationLabel mNavigationLabel;

    @XStreamAlias("content")
    private Content mContent;

    @XmlAttribute
    @XStreamAlias("id")
    private Identifier mId;
    @XmlAttribute
    @XStreamAlias("playOrder")
    private String playOrder;

    @XmlAttribute
    @XStreamAlias("class")
    private String mClass;





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
        if(mInnerNavigationPoints == null)
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

}
