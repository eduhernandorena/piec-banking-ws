package br.org.fiergs.piecbankingws.main.utils;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

public class MyNamespaceMapper extends NamespacePrefixMapper {

    private static final String SCH_PREFIX = "sch";
    private static final String SCH_URI = "http://www.tibco.com/schemas/bws_registro_cbr/Recursos/XSD/Schema.xsd";

    @Override
    public String getPreferredPrefix(String namespaceUri, String suggestion,
                                     boolean requirePrefix) {
        if (SCH_URI.equals(namespaceUri)) {
            return SCH_PREFIX;
        }

        return suggestion;
    }

    @Override
    public String[] getPreDeclaredNamespaceUris() {
        return new String[]{SCH_URI};
    }

}

