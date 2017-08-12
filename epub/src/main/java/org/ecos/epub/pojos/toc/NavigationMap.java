package org.ecos.epub.pojos.toc;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

import org.ecos.reader.core.exceptions.CollectionOutOfBoundException;
import org.ecos.reader.core.exceptions.EmptyCollectionException;

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

    public NavigationPoint getNavigationPoint(int index) throws EmptyCollectionException, CollectionOutOfBoundException {
        collectionGuardClauses(index);

        return mNavigationPoints.get(index);
    }

    private void collectionGuardClauses(int index) throws EmptyCollectionException, CollectionOutOfBoundException {
        if(mNavigationPoints==null || mNavigationPoints.size()==0)
            throw new EmptyCollectionException();
        if(index<=0 || index>=mNavigationPoints.size())
            throw new CollectionOutOfBoundException();
    }
}
