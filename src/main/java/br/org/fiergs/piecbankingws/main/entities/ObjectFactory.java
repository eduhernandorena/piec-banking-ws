//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.3.0 
// Consulte <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2020.05.12 às 02:54:09 PM BRT 
//


package br.org.fiergs.piecbankingws.main.entities;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.org.fiergs.cobranca.bb.entities package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.org.fiergs.cobranca.bb.entities
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ErroEntity }
     * 
     */
    public ErroEntity createErro() {
        return new ErroEntity();
    }

    /**
     * Create an instance of {@link RequisicaoEntity }
     * 
     */
    public RequisicaoEntity createRequisicao() {
        return new RequisicaoEntity();
    }

    /**
     * Create an instance of {@link RespostaEntity }
     * 
     */
    public RespostaEntity createResposta() {
        return new RespostaEntity();
    }

    /**
     * Create an instance of {@link RootEntity }
     * 
     */
    public RootEntity createRoot() {
        return new RootEntity();
    }

}
