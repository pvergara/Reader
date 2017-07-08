package org.ecos.reader.core.io.files;

import java.util.Collection;

public interface FileCollection extends Collection<File> {
    Collection<String> getPathsAsString();
}