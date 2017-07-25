package org.ecos.epub.pojos.toc;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NavigationMap extends AbstractCollection<NavigationPoint> {
    @XStreamImplicit
    private List<NavigationPoint> mNavigationPoints;

    public NavigationMap() {
        mNavigationPoints = new ArrayList<>();
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public Iterator<NavigationPoint> iterator() {
        return mNavigationPoints.iterator();
    }

    @Override
    public int size() {
        return mNavigationPoints.size();
    }

    @Override
    public boolean add(NavigationPoint navigationPoint) {
        return mNavigationPoints.add(navigationPoint);
    }
}
