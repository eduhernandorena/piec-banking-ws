//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.3.0 
// Consulte <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2020.05.12 às 02:54:09 PM BRT 
//


package br.org.fiergs.piecbankingws.main.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/bws_registro_cbr/Recursos/XSD/Schema.xsd}requisicao"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/bws_registro_cbr/Recursos/XSD/Schema.xsd}resposta"/&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/bws_registro_cbr/Recursos/XSD/Schema.xsd}erro"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "requisicaoEntity",
        "respostaEntity",
        "erroEntity"
})
@XmlRootElement(name = "root")
public class RootEntity {

    @XmlElement(required = true)
    protected RequisicaoEntity requisicaoEntity;
    @XmlElement(required = true)
    protected RespostaEntity respostaEntity;
    @XmlElement(required = true)
    protected ErroEntity erroEntity;

    /**
     * Obtém o valor da propriedade requisicao.
     * 
     * @return
     *     possible object is
     *     {@link RequisicaoEntity }
     *     
     */
    public RequisicaoEntity getRequisicaoEntity() {
        return requisicaoEntity;
    }

    /**
     * Define o valor da propriedade requisicao.
     * 
     * @param value
     *     allowed object is
     *     {@link RequisicaoEntity }
     *     
     */
    public void setRequisicaoEntity(RequisicaoEntity value) {
        this.requisicaoEntity = value;
    }

    /**
     * Obtém o valor da propriedade resposta.
     * 
     * @return
     *     possible object is
     *     {@link RespostaEntity }
     *     
     */
    public RespostaEntity getRespostaEntity() {
        return respostaEntity;
    }

    /**
     * Define o valor da propriedade resposta.
     * 
     * @param value
     *     allowed object is
     *     {@link RespostaEntity }
     *     
     */
    public void setRespostaEntity(RespostaEntity value) {
        this.respostaEntity = value;
    }

    /**
     * Obtém o valor da propriedade erro.
     * 
     * @return
     *     possible object is
     *     {@link ErroEntity }
     *     
     */
    public ErroEntity getErroEntity() {
        return erroEntity;
    }

    /**
     * Define o valor da propriedade erro.
     * 
     * @param value
     *     allowed object is
     *     {@link ErroEntity }
     *     
     */
    public void setErroEntity(ErroEntity value) {
        this.erroEntity = value;
    }

}
