package org.ecos.reader.core.epub.pojos.content;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import org.ecos.reader.core.io.files.exceptions.DoNoExistsException;

import java.util.function.Predicate;

@XStreamAlias("package")
public class Content {

    @XStreamAlias("metadata")
    private Metadata mMetadata;

    @XStreamAlias("manifest")
    private Manifest mManifest;

    public Metadata getMetadata() {
        return mMetadata;
    }

    @SuppressWarnings("unused")
    public Manifest getManifest(){
        return mManifest;
    }

    public Item lookForManifestItemWith(Predicate<Item> predicate) throws DoNoExistsException {
        for (Item item : mManifest) {
            if(predicate.test(item))
                return item;
        }
        throw new DoNoExistsException("The item you're looking for do not exists.");
    }
}