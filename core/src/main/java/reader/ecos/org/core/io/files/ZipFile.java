package reader.ecos.org.core.io.files;


@SuppressWarnings("WeakerAccess")
public interface ZipFile {
    void prepareTheUse(File file);
    boolean exists();
}
