package reader.ecos.org.core.io.files;


@SuppressWarnings("unused")
public interface ZipFile {
    void prepareToUse(File file);
    boolean exists();
}
