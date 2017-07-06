package org.ecos.reader.core.io.files;

public class PathImpl implements Path {
    private String pathAsString;

    private PathImpl(String pathAsString) {

        this.pathAsString = pathAsString;
    }

    public static Path from(String pathAsString){
        return new PathImpl(pathAsString);
    }

    @Override
    public String asString() {
        return pathAsString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PathImpl path = (PathImpl) o;

        return pathAsString.equals(path.pathAsString);
    }

    @Override
    public int hashCode() {
        return pathAsString.hashCode();
    }
}
