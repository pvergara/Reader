package org.ecos.epub.unit;

import org.ecos.epub.binders.toc.TableOfContentsBinder;
import org.ecos.epub.binders.toc.TableOfContentsBinderImpl;
import org.ecos.epub.pojos.toc.Metadata;
import org.ecos.epub.pojos.toc.TableOfContents;
import org.ecos.epub.pojos.toc.Title;
import org.ecos.reader.core.io.files.exceptions.DoNoExistsException;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class TableOfContentsTests {
    private String getTableOfContentsAsXMLString() {
        return "" +
                "<?xml version='1.0' encoding='UTF-8'?>\n" +
                "\n" +
                "<!DOCTYPE ncx PUBLIC '-//NISO//DTD ncx 2005-1//EN' 'http://www.daisy.org/z3986/2005/ncx-2005-1.dtd'>\n" +
                "<ncx xmlns=\"http://www.daisy.org/z3986/2005/ncx/\" version=\"2005-1\" xml:lang=\"es\">\n" +
                "  <head>\n" +
                "    <meta content=\"http://www.gutenberg.org/ebooks/36453\" name=\"dtb:uid\"/>\n" +
                "    <meta content=\"2\" name=\"dtb:depth\"/>\n" +
                "    <meta content=\"Ebookmaker 0.4.0a5 by Marcello Perathoner &lt;webmaster@gutenberg.org&gt;\" name=\"dtb:generator\"/>\n" +
                "    <meta content=\"0\" name=\"dtb:totalPageCount\"/>\n" +
                "    <meta content=\"0\" name=\"dtb:maxPageNumber\"/>\n" +
                "  </head>\n" +
                "  <docTitle>\n" +
                "    <text>La guardia blanca\n" +
                "novela histórica escrita en inglés</text>\n" +
                "  </docTitle>\n" +
                "  <navMap>\n" +
                "    <navPoint id=\"np-1\" playOrder=\"1\">\n" +
                "      <navLabel>\n" +
                "        <text>GUARDIA BLANCA</text>\n" +
                "      </navLabel>\n" +
                "      <content src=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-0.htm.html#pgepubid00000\"/>\n" +
                "    </navPoint>\n" +
                "    <navPoint id=\"np-2\" playOrder=\"2\">\n" +
                "      <navLabel>\n" +
                "        <text>Á QUIEN LEYERE.</text>\n" +
                "      </navLabel>\n" +
                "      <content src=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-0.htm.html#pgepubid00001\"/>\n" +
                "      <navPoint id=\"np-3\" playOrder=\"3\">\n" +
                "        <navLabel>\n" +
                "          <text>LA GUARDIA BLANCA</text>\n" +
                "        </navLabel>\n" +
                "        <content src=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-0.htm.html#pgepubid00002\"/>\n" +
                "      </navPoint>\n" +
                "      <navPoint id=\"np-4\" playOrder=\"4\">\n" +
                "        <navLabel>\n" +
                "          <text>CAPÍTULO I DE CÓMO LA OVEJA DESCARRIADA ABANDONÓ EL REDIL</text>\n" +
                "        </navLabel>\n" +
                "        <content src=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-0.htm.html#pgepubid00003\"/>\n" +
                "      </navPoint>\n" +
                "      <navPoint id=\"np-5\" playOrder=\"5\">\n" +
                "        <navLabel>\n" +
                "          <text>CAPÍTULO II DE CÓMO ROGER DE CLINTON EMPEZÓ Á VER EL MUNDO</text>\n" +
                "        </navLabel>\n" +
                "        <content src=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-0.htm.html#pgepubid00004\"/>\n" +
                "      </navPoint>\n" +
                "      <navPoint id=\"np-6\" playOrder=\"6\">\n" +
                "        <navLabel>\n" +
                "          <text>CAPÍTULO III DE CÓMO TRISTÁN DE HORLA DEJÓ AL BATANERO EN PERNETAS</text>\n" +
                "        </navLabel>\n" +
                "        <content src=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-0.htm.html#pgepubid00005\"/>\n" +
                "      </navPoint>\n" +
                "      <navPoint id=\"np-7\" playOrder=\"7\">\n" +
                "        <navLabel>\n" +
                "          <text>CAPÍTULO IV DE LA JUSTICIA INGLESA EN EL SIGLO CATORCE</text>\n" +
                "        </navLabel>\n" +
                "        <content src=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-0.htm.html#pgepubid00006\"/>\n" +
                "      </navPoint>\n" +
                "      <navPoint id=\"np-8\" playOrder=\"8\">\n" +
                "        <navLabel>\n" +
                "          <text>CAPÍTULO V DE LA EXTRAÑA COMPAÑÍA QUE SE REUNIÓ EN LA VENTA DEL PÁJARO VERDE</text>\n" +
                "        </navLabel>\n" +
                "        <content src=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-1.htm.html#pgepubid00007\"/>\n" +
                "      </navPoint>\n" +
                "      <navPoint id=\"np-9\" playOrder=\"9\">\n" +
                "        <navLabel>\n" +
                "          <text>CAPÍTULO VI DE CÓMO EL ARQUERO SIMÓN APOSTÓ SU COBERTOR DE PLUMA</text>\n" +
                "        </navLabel>\n" +
                "        <content src=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-1.htm.html#pgepubid00008\"/>\n" +
                "      </navPoint>\n" +
                "      <navPoint id=\"np-10\" playOrder=\"10\">\n" +
                "        <navLabel>\n" +
                "          <text>CAPÍTULO VII DE CÓMO LOS CAMINANTES ATRAVESARON EL BOSQUE</text>\n" +
                "        </navLabel>\n" +
                "        <content src=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-1.htm.html#pgepubid00009\"/>\n" +
                "      </navPoint>\n" +
                "      <navPoint id=\"np-11\" playOrder=\"11\">\n" +
                "        <navLabel>\n" +
                "          <text>CAPÍTULO VIII LOS TRES AMIGOS</text>\n" +
                "        </navLabel>\n" +
                "        <content src=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-2.htm.html#pgepubid00010\"/>\n" +
                "      </navPoint>\n" +
                "      <navPoint id=\"np-12\" playOrder=\"12\">\n" +
                "        <navLabel>\n" +
                "          <text>CAPÍTULO IX EN LA SELVA DE MUNSTER</text>\n" +
                "        </navLabel>\n" +
                "        <content src=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-2.htm.html#pgepubid00011\"/>\n" +
                "      </navPoint>\n" +
                "      <navPoint id=\"np-13\" playOrder=\"13\">\n" +
                "        <navLabel>\n" +
                "          <text>CAPÍTULO X UN CAPITÁN COMO HAY POCOS</text>\n" +
                "        </navLabel>\n" +
                "        <content src=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-2.htm.html#pgepubid00012\"/>\n" +
                "      </navPoint>\n" +
                "      <navPoint id=\"np-14\" playOrder=\"14\">\n" +
                "        <navLabel>\n" +
                "          <text>CAPÍTULO XI DEL CONVENTO Á ESCUDERO Y DE DISCÍPULO Á MAESTRO</text>\n" +
                "        </navLabel>\n" +
                "        <content src=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-3.htm.html#pgepubid00013\"/>\n" +
                "      </navPoint>\n" +
                "      <navPoint id=\"np-15\" playOrder=\"15\">\n" +
                "        <navLabel>\n" +
                "          <text>CAPÍTULO XII DE CÓMO ROGER APRENDIÓ MÁS DE LO QUE ÉL PODÍA ENSEÑAR</text>\n" +
                "        </navLabel>\n" +
                "        <content src=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-3.htm.html#pgepubid00014\"/>\n" +
                "      </navPoint>\n" +
                "      <navPoint id=\"np-16\" playOrder=\"16\">\n" +
                "        <navLabel>\n" +
                "          <text>CAPÍTULO XIII DE CÓMO LA GUARDIA BLANCA PARTIÓ PARA LA GUERRA</text>\n" +
                "        </navLabel>\n" +
                "        <content src=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-3.htm.html#pgepubid00015\"/>\n" +
                "      </navPoint>\n" +
                "      <navPoint id=\"np-17\" playOrder=\"17\">\n" +
                "        <navLabel>\n" +
                "          <text>CAPÍTULO XIV AVENTURAS DE VIAJE</text>\n" +
                "        </navLabel>\n" +
                "        <content src=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-4.htm.html#pgepubid00016\"/>\n" +
                "      </navPoint>\n" +
                "      <navPoint id=\"np-18\" playOrder=\"18\">\n" +
                "        <navLabel>\n" +
                "          <text>CAPÍTULO XV DE CÓMO EL GALEÓN AMARILLO SE HIZO Á LA VELA</text>\n" +
                "        </navLabel>\n" +
                "        <content src=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-4.htm.html#pgepubid00017\"/>\n" +
                "      </navPoint>\n" +
                "      <navPoint id=\"np-19\" playOrder=\"19\">\n" +
                "        <navLabel>\n" +
                "          <text>CAPÍTULO XVI DEL COMBATE ENTRE EL GALEÓN AMARILLO Y LOS DOS PIRATAS.</text>\n" +
                "        </navLabel>\n" +
                "        <content src=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-4.htm.html#pgepubid00018\"/>\n" +
                "      </navPoint>\n" +
                "      <navPoint id=\"np-20\" playOrder=\"20\">\n" +
                "        <navLabel>\n" +
                "          <text>CAPÍTULO XVII EN LA BARRA DEL GARONA</text>\n" +
                "        </navLabel>\n" +
                "        <content src=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-4.htm.html#pgepubid00019\"/>\n" +
                "      </navPoint>\n" +
                "      <navPoint id=\"np-21\" playOrder=\"21\">\n" +
                "        <navLabel>\n" +
                "          <text>CAPÍTULO XVIII DE CÓMO EL BARÓN HIZO VOTO DE PONERSE UN PARCHE</text>\n" +
                "        </navLabel>\n" +
                "        <content src=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-5.htm.html#pgepubid00020\"/>\n" +
                "      </navPoint>\n" +
                "      <navPoint id=\"np-22\" playOrder=\"22\">\n" +
                "        <navLabel>\n" +
                "          <text>CAPÍTULO XIX ANTE EL DUQUE DE AQUITANIA</text>\n" +
                "        </navLabel>\n" +
                "        <content src=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-5.htm.html#pgepubid00021\"/>\n" +
                "      </navPoint>\n" +
                "      <navPoint id=\"np-23\" playOrder=\"23\">\n" +
                "        <navLabel>\n" +
                "          <text>CAPÍTULO XX DE CÓMO ROGER DESHIZO UN ENTUERTO Y TOMÓ UN BAÑO</text>\n" +
                "        </navLabel>\n" +
                "        <content src=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-5.htm.html#pgepubid00022\"/>\n" +
                "      </navPoint>\n" +
                "      <navPoint id=\"np-24\" playOrder=\"24\">\n" +
                "        <navLabel>\n" +
                "          <text>CAPÍTULO XXI DONDE AGUSTÍN PISANO ARRIESGA SU CABEZA</text>\n" +
                "        </navLabel>\n" +
                "        <content src=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-6.htm.html#pgepubid00023\"/>\n" +
                "      </navPoint>\n" +
                "      <navPoint id=\"np-25\" playOrder=\"25\">\n" +
                "        <navLabel>\n" +
                "          <text>CAPÍTULO XXII UNA NOCHE DE HOLGORIO EN \"LA ROSA DE AQUITANIA\"</text>\n" +
                "        </navLabel>\n" +
                "        <content src=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-6.htm.html#pgepubid00024\"/>\n" +
                "      </navPoint>\n" +
                "      <navPoint id=\"np-26\" playOrder=\"26\">\n" +
                "        <navLabel>\n" +
                "          <text>CAPÍTULO XXIII LAS JUSTAS DE BURDEOS</text>\n" +
                "        </navLabel>\n" +
                "        <content src=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-6.htm.html#pgepubid00025\"/>\n" +
                "      </navPoint>\n" +
                "      <navPoint id=\"np-27\" playOrder=\"27\">\n" +
                "        <navLabel>\n" +
                "          <text>CAPÍTULO XXIV DE CÓMO EL ESTE ENVIÓ UN FAMOSO CAMPEÓN</text>\n" +
                "        </navLabel>\n" +
                "        <content src=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-6.htm.html#pgepubid00026\"/>\n" +
                "      </navPoint>\n" +
                "      <navPoint id=\"np-28\" playOrder=\"28\">\n" +
                "        <navLabel>\n" +
                "          <text>CAPÍTULO XXV DE UNA CARTA Y UNAS RELIQUIAS</text>\n" +
                "        </navLabel>\n" +
                "        <content src=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-7.htm.html#pgepubid00027\"/>\n" +
                "      </navPoint>\n" +
                "      <navPoint id=\"np-29\" playOrder=\"29\">\n" +
                "        <navLabel>\n" +
                "          <text>CAPÍTULO XXVI DONDE SE AVERIGUA QUIÉN ERA EL MISTERIOSO PALADÍN</text>\n" +
                "        </navLabel>\n" +
                "        <content src=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-7.htm.html#pgepubid00028\"/>\n" +
                "      </navPoint>\n" +
                "      <navPoint id=\"np-30\" playOrder=\"30\">\n" +
                "        <navLabel>\n" +
                "          <text>CAPÍTULO XXVII VISIÓN PROFÉTICA</text>\n" +
                "        </navLabel>\n" +
                "        <content src=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-7.htm.html#pgepubid00029\"/>\n" +
                "      </navPoint>\n" +
                "      <navPoint id=\"np-31\" playOrder=\"31\">\n" +
                "        <navLabel>\n" +
                "          <text>CAPÍTULO XXVIII ATAQUE Y DEFENSA DEL CASTILLO DE VILLAFRANCA</text>\n" +
                "        </navLabel>\n" +
                "        <content src=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-7.htm.html#pgepubid00030\"/>\n" +
                "      </navPoint>\n" +
                "      <navPoint id=\"np-32\" playOrder=\"32\">\n" +
                "        <navLabel>\n" +
                "          <text>CAPÍTULO XXIX EL PASO DE RONCESVALLES</text>\n" +
                "        </navLabel>\n" +
                "        <content src=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-7.htm.html#pgepubid00031\"/>\n" +
                "      </navPoint>\n" +
                "      <navPoint id=\"np-33\" playOrder=\"33\">\n" +
                "        <navLabel>\n" +
                "          <text>CAPÍTULO XXX LA GUARDIA BLANCA EN EL VALLE DE PAMPLONA</text>\n" +
                "        </navLabel>\n" +
                "        <content src=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-8.htm.html#pgepubid00032\"/>\n" +
                "      </navPoint>\n" +
                "      <navPoint id=\"np-34\" playOrder=\"34\">\n" +
                "        <navLabel>\n" +
                "          <text>CAPÍTULO XXXI DE CÓMO TRISTÁN Y EL BARÓN HICIERON DOS PRISIONEROS</text>\n" +
                "        </navLabel>\n" +
                "        <content src=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-8.htm.html#pgepubid00033\"/>\n" +
                "      </navPoint>\n" +
                "      <navPoint id=\"np-35\" playOrder=\"35\">\n" +
                "        <navLabel>\n" +
                "          <text>CAPÍTULO XXXII DONDE EL SEÑOR DE MOREL CUMPLE SU VOTO</text>\n" +
                "        </navLabel>\n" +
                "        <content src=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-8.htm.html#pgepubid00034\"/>\n" +
                "      </navPoint>\n" +
                "      <navPoint id=\"np-36\" playOrder=\"36\">\n" +
                "        <navLabel>\n" +
                "          <text>CAPÍTULO XXXIII \"LA ROCA DE LOS INGLESES\"</text>\n" +
                "        </navLabel>\n" +
                "        <content src=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-8.htm.html#pgepubid00035\"/>\n" +
                "      </navPoint>\n" +
                "      <navPoint id=\"np-37\" playOrder=\"37\">\n" +
                "        <navLabel>\n" +
                "          <text>CAPÍTULO XXXIV REGRESO Á LA PATRIA</text>\n" +
                "        </navLabel>\n" +
                "        <content src=\"@public@vhost@g@gutenberg@html@files@36453@36453-h@36453-h-9.htm.html#pgepubid00036\"/>\n" +
                "      </navPoint>\n" +
                "    </navPoint>\n" +
                "  </navMap>\n" +
                "</ncx>";
    }

    @Test
    public void givingSomeRightTOCXMLThenTheResultMustBeCorrect() throws DoNoExistsException {
        //Arrange
        TableOfContentsBinder binder = new TableOfContentsBinderImpl();
        String tableOfContentsAsXML = getTableOfContentsAsXMLString();

        //Act
        TableOfContents tableOfContents = binder.extractFrom(tableOfContentsAsXML);

        //Assertions
        assertThat(tableOfContents.getHeadCollection(),hasSize(5));
        assertThat(tableOfContents.getFirstMetadata(), is(equalTo(Metadata.from("http://www.gutenberg.org/ebooks/36453","dtb:uid"))));
        assertThat(tableOfContents.getTitle(), is(equalTo(Title.fromText("La guardia blanca\nnovela histórica escrita en inglés"))));
    }
}
