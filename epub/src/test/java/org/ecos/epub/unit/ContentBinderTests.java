package org.ecos.epub.unit;

import org.ecos.epub.binders.ContentBinder;
import org.ecos.epub.binders.ContentBinderImpl;
import org.ecos.epub.pojos.content.Content;
import org.ecos.epub.pojos.content.Item;
import org.ecos.reader.core.exceptions.DoNoExistsException;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

@SuppressWarnings("SpellCheckingInspection")
public class ContentBinderTests {
    private String getContainerAsXMLString() {
        return "" +
                "<package " +
                "   xmlns:dc=\"http://purl.org/dc/elements/1.1/\" " +
                "   xmlns:dcterms=\"http://purl.org/dc/terms/\" " +
                "   xmlns:opf=\"http://www.idpf.org/2007/opf\" " +
                "   xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" " +
                "   xmlns=\"http://www.idpf.org/2007/opf\" " +
                "   version=\"2.0\" " +
                "   unique-identifier=\"id\"" +
                ">\n" +
                "  <metadata>\n" +
                "    <dc:rights>Public domain in the USA.</dc:rights>\n" +
                "    <dc:identifier id=\"id\" opf:scheme=\"URI\">http://www.gutenberg.org/ebooks/36453</dc:identifier>\n" +
                "    <dc:creator opf:file-as=\"Doyle, Arthur Conan\">Arthur Conan Doyle</dc:creator>\n" +
                "    <dc:contributor opf:file-as=\"Iribas, Juan L.\" opf:role=\"trl\">Juan L. Iribas</dc:contributor>\n" +
                "    <dc:title>La guardia blanca / novela histórica escrita en inglés</dc:title>\n" +
                "    <dc:language xsi:type=\"dcterms:RFC4646\">es</dc:language>\n" +
                "    <dc:subject>Historical fiction</dc:subject>\n" +
                "    <dc:subject>Hundred Years' War, 1339-1453 -- Fiction</dc:subject>\n" +
                "    <dc:subject>Knights and knighthood -- Fiction</dc:subject>\n" +
                "    <dc:subject>Middle Ages -- Fiction</dc:subject>\n" +
                "    <dc:subject>Archers -- Fiction</dc:subject>\n" +
                "    <dc:subject>War stories</dc:subject>\n" +
                "    <dc:subject>British -- France -- Fiction</dc:subject>\n" +
                "    <dc:date opf:event=\"publication\">2011-06-17</dc:date>\n" +
                "    <dc:date opf:event=\"conversion\">2017-06-19T06:16:35.374829+00:00</dc:date>\n" +
                "    <dc:source>http://www.gutenberg.org/files/36453/36453-h/36453-h.htm</dc:source>\n" +
                "  </metadata>\n" +
                "  <manifest>\n" +
                "    <item id=\"item1\" media-type=\"text/css\" href=\"pgepub.css\"/>\n" +
                "    <item id=\"item2\" media-type=\"text/css\" href=\"0.css\"/>\n" +
                "    <item id=\"item3\" media-type=\"text/css\" href=\"1.css\"/>\n" +
                "    <item id=\"item4\" media-type=\"application/xhtml+xml\" href=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-0.htm.html\"/>\n" +
                "    <item id=\"item5\" media-type=\"application/xhtml+xml\" href=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-1.htm.html\"/>\n" +
                "    <item id=\"item6\" media-type=\"application/xhtml+xml\" href=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-2.htm.html\"/>\n" +
                "    <item id=\"item7\" media-type=\"application/xhtml+xml\" href=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-3.htm.html\"/>\n" +
                "    <item id=\"item8\" media-type=\"application/xhtml+xml\" href=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-4.htm.html\"/>\n" +
                "    <item id=\"item9\" media-type=\"application/xhtml+xml\" href=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-5.htm.html\"/>\n" +
                "    <item id=\"item10\" media-type=\"application/xhtml+xml\" href=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-6.htm.html\"/>\n" +
                "    <item id=\"item11\" media-type=\"application/xhtml+xml\" href=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-7.htm.html\"/>\n" +
                "    <item id=\"item12\" media-type=\"application/xhtml+xml\" href=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-8.htm.html\"/>\n" +
                "    <item id=\"item13\" media-type=\"application/xhtml+xml\" href=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-9.htm.html\"/>\n" +
                "    <item id=\"item14\" media-type=\"application/xhtml+xml\" href=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-10.htm.html\"/>\n" +
                "    <item id=\"ncx\" media-type=\"application/x-dtbncx+xml\" href=\"toc.ncx\"/>\n" +
                "  </manifest>\n" +
                "  <spine toc=\"ncx\">\n" +
                "    <itemref idref=\"item4\" linear=\"yes\"/>\n" +
                "    <itemref idref=\"item5\" linear=\"yes\"/>\n" +
                "    <itemref idref=\"item6\" linear=\"yes\"/>\n" +
                "    <itemref idref=\"item7\" linear=\"yes\"/>\n" +
                "    <itemref idref=\"item8\" linear=\"yes\"/>\n" +
                "    <itemref idref=\"item9\" linear=\"yes\"/>\n" +
                "    <itemref idref=\"item10\" linear=\"yes\"/>\n" +
                "    <itemref idref=\"item11\" linear=\"yes\"/>\n" +
                "    <itemref idref=\"item12\" linear=\"yes\"/>\n" +
                "    <itemref idref=\"item13\" linear=\"yes\"/>\n" +
                "    <itemref idref=\"item14\" linear=\"yes\"/>\n" +
                "  </spine>\n" +
                "</package>";
    }

    @Test
    public void givingACorrectContainerXMLThenTheResultMustBeCorrect() throws DoNoExistsException {
        //Arrange
        ContentBinder binder = new ContentBinderImpl();
        String contentXML = getContainerAsXMLString();

        //Act
        Content content = binder.extractContentFrom(contentXML);

        //Assertions
        assertThat(content.getMetadata().getRights(), is(equalTo("Public domain in the USA.")));
        assertThat(content.getMetadata().getIdentifier(), is(equalTo("http://www.gutenberg.org/ebooks/36453")));
        assertThat(content.getMetadata().getCreator(), is(equalTo("Arthur Conan Doyle")));
        assertThat(content.getMetadata().getContributor(), is(equalTo("Juan L. Iribas")));
        assertThat(content.getMetadata().getTitle(), is(equalTo("La guardia blanca / novela histórica escrita en inglés")));
        assertThat(content.getMetadata().getLanguage(), is(equalTo("es")));

        assertThat(content.getMetadata().getSubjects(), hasSize(7));
        assertThat(content.getMetadata().getSubjects(), hasItem("British -- France -- Fiction"));
        assertThat(content.getMetadata().getSubjects(), hasItem("Hundred Years' War, 1339-1453 -- Fiction"));

        Item manifestItem = content.lookForManifestItemWith(item->item.getId().equals("ncx"));

        assertThat(manifestItem.getHyperlinkReference(), is(equalTo("toc.ncx")));

    }

    @Test
    public void givingAnSubtleIncorrectContentXMLThenTheResultMustBeIncorrect() throws Exception {
        throw new Exception("TODO");
    }

}