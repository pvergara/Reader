package org.ecos.epub.pojos.content;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import org.ecos.core.interfaces.functional.Function1;
import org.ecos.reader.core.io.files.exceptions.DoNoExistsException;

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

    public Item lookForManifestItemWith(Function1<Boolean,Item> evaluator) throws DoNoExistsException {
        for (Item item : mManifest) {
            if(evaluator.execute(item))
                return item;
        }
        throw new DoNoExistsException("The item you're looking for do not exists.");
    }
}