//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.3.0 
// Consulte <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2020.05.12 às 02:54:09 PM BRT 
//


package br.org.fiergs.piecbankingws.main.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;


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
 *         &lt;element name="siglaSistemaMensagem" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="3"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="codigoRetornoPrograma" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/&gt;
 *         &lt;element name="nomeProgramaErro" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="8"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="textoMensagemErro" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="68"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="numeroPosicaoErroPrograma" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short"&gt;
 *               &lt;totalDigits value="4"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="codigoTipoRetornoPrograma" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short"&gt;
 *               &lt;totalDigits value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="textoNumeroTituloCobrancaBb" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="20"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="numeroCarteiraCobranca" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short"&gt;
 *               &lt;totalDigits value="4"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="numeroVariacaoCarteiraCobranca" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short"&gt;
 *               &lt;totalDigits value="4"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="codigoPrefixoDependenciaBeneficiario" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short"&gt;
 *               &lt;totalDigits value="4"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="numeroContaCorrenteBeneficiario" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;totalDigits value="9"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="codigoCliente" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;totalDigits value="9"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="linhaDigitavel" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="47"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="codigoBarraNumerico" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="52"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="codigoTipoEnderecoBeneficiario" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short"&gt;
 *               &lt;totalDigits value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="nomeLogradouroBeneficiario" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="60"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="nomeBairroBeneficiario" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="30"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="nomeMunicipioBeneficiario" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="30"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="codigoMunicipioBeneficiario" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;totalDigits value="9"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="siglaUfBeneficiario" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="codigoCepBeneficiario" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;totalDigits value="9"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="indicadorComprovacaoBeneficiario" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="numeroContratoCobranca" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;totalDigits value="9"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
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
    "siglaSistemaMensagem",
    "codigoRetornoPrograma",
    "nomeProgramaErro",
    "textoMensagemErro",
    "numeroPosicaoErroPrograma",
    "codigoTipoRetornoPrograma",
    "textoNumeroTituloCobrancaBb",
    "numeroCarteiraCobranca",
    "numeroVariacaoCarteiraCobranca",
    "codigoPrefixoDependenciaBeneficiario",
    "numeroContaCorrenteBeneficiario",
    "codigoCliente",
    "linhaDigitavel",
    "codigoBarraNumerico",
    "codigoTipoEnderecoBeneficiario",
    "nomeLogradouroBeneficiario",
    "nomeBairroBeneficiario",
    "nomeMunicipioBeneficiario",
    "codigoMunicipioBeneficiario",
    "siglaUfBeneficiario",
    "codigoCepBeneficiario",
    "indicadorComprovacaoBeneficiario",
    "numeroContratoCobranca"
})
@XmlRootElement(name = "resposta")
public class RespostaEntity {

    protected String siglaSistemaMensagem;
    protected Short codigoRetornoPrograma;
    protected String nomeProgramaErro;
    protected String textoMensagemErro;
    protected Short numeroPosicaoErroPrograma;
    protected Short codigoTipoRetornoPrograma;
    protected String textoNumeroTituloCobrancaBb;
    protected Short numeroCarteiraCobranca;
    protected Short numeroVariacaoCarteiraCobranca;
    protected Short codigoPrefixoDependenciaBeneficiario;
    protected Integer numeroContaCorrenteBeneficiario;
    protected Integer codigoCliente;
    protected String linhaDigitavel;
    protected String codigoBarraNumerico;
    protected Short codigoTipoEnderecoBeneficiario;
    protected String nomeLogradouroBeneficiario;
    protected String nomeBairroBeneficiario;
    protected String nomeMunicipioBeneficiario;
    protected Integer codigoMunicipioBeneficiario;
    protected String siglaUfBeneficiario;
    protected Integer codigoCepBeneficiario;
    protected String indicadorComprovacaoBeneficiario;
    protected Integer numeroContratoCobranca;

    /**
     * Obtém o valor da propriedade siglaSistemaMensagem.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiglaSistemaMensagem() {
        return siglaSistemaMensagem;
    }

    /**
     * Define o valor da propriedade siglaSistemaMensagem.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiglaSistemaMensagem(String value) {
        this.siglaSistemaMensagem = value;
    }

    /**
     * Obtém o valor da propriedade codigoRetornoPrograma.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getCodigoRetornoPrograma() {
        return codigoRetornoPrograma;
    }

    /**
     * Define o valor da propriedade codigoRetornoPrograma.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setCodigoRetornoPrograma(Short value) {
        this.codigoRetornoPrograma = value;
    }

    /**
     * Obtém o valor da propriedade nomeProgramaErro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeProgramaErro() {
        return nomeProgramaErro;
    }

    /**
     * Define o valor da propriedade nomeProgramaErro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeProgramaErro(String value) {
        this.nomeProgramaErro = value;
    }

    /**
     * Obtém o valor da propriedade textoMensagemErro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextoMensagemErro() {
        return textoMensagemErro;
    }

    /**
     * Define o valor da propriedade textoMensagemErro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextoMensagemErro(String value) {
        this.textoMensagemErro = value;
    }

    /**
     * Obtém o valor da propriedade numeroPosicaoErroPrograma.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getNumeroPosicaoErroPrograma() {
        return numeroPosicaoErroPrograma;
    }

    /**
     * Define o valor da propriedade numeroPosicaoErroPrograma.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setNumeroPosicaoErroPrograma(Short value) {
        this.numeroPosicaoErroPrograma = value;
    }

    /**
     * Obtém o valor da propriedade codigoTipoRetornoPrograma.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getCodigoTipoRetornoPrograma() {
        return codigoTipoRetornoPrograma;
    }

    /**
     * Define o valor da propriedade codigoTipoRetornoPrograma.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setCodigoTipoRetornoPrograma(Short value) {
        this.codigoTipoRetornoPrograma = value;
    }

    /**
     * Obtém o valor da propriedade textoNumeroTituloCobrancaBb.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextoNumeroTituloCobrancaBb() {
        return textoNumeroTituloCobrancaBb;
    }

    /**
     * Define o valor da propriedade textoNumeroTituloCobrancaBb.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextoNumeroTituloCobrancaBb(String value) {
        this.textoNumeroTituloCobrancaBb = value;
    }

    /**
     * Obtém o valor da propriedade numeroCarteiraCobranca.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getNumeroCarteiraCobranca() {
        return numeroCarteiraCobranca;
    }

    /**
     * Define o valor da propriedade numeroCarteiraCobranca.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setNumeroCarteiraCobranca(Short value) {
        this.numeroCarteiraCobranca = value;
    }

    /**
     * Obtém o valor da propriedade numeroVariacaoCarteiraCobranca.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getNumeroVariacaoCarteiraCobranca() {
        return numeroVariacaoCarteiraCobranca;
    }

    /**
     * Define o valor da propriedade numeroVariacaoCarteiraCobranca.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setNumeroVariacaoCarteiraCobranca(Short value) {
        this.numeroVariacaoCarteiraCobranca = value;
    }

    /**
     * Obtém o valor da propriedade codigoPrefixoDependenciaBeneficiario.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getCodigoPrefixoDependenciaBeneficiario() {
        return codigoPrefixoDependenciaBeneficiario;
    }

    /**
     * Define o valor da propriedade codigoPrefixoDependenciaBeneficiario.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setCodigoPrefixoDependenciaBeneficiario(Short value) {
        this.codigoPrefixoDependenciaBeneficiario = value;
    }

    /**
     * Obtém o valor da propriedade numeroContaCorrenteBeneficiario.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumeroContaCorrenteBeneficiario() {
        return numeroContaCorrenteBeneficiario;
    }

    /**
     * Define o valor da propriedade numeroContaCorrenteBeneficiario.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumeroContaCorrenteBeneficiario(Integer value) {
        this.numeroContaCorrenteBeneficiario = value;
    }

    /**
     * Obtém o valor da propriedade codigoCliente.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    /**
     * Define o valor da propriedade codigoCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodigoCliente(Integer value) {
        this.codigoCliente = value;
    }

    /**
     * Obtém o valor da propriedade linhaDigitavel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinhaDigitavel() {
        return linhaDigitavel;
    }

    /**
     * Define o valor da propriedade linhaDigitavel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinhaDigitavel(String value) {
        this.linhaDigitavel = value;
    }

    /**
     * Obtém o valor da propriedade codigoBarraNumerico.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoBarraNumerico() {
        return codigoBarraNumerico;
    }

    /**
     * Define o valor da propriedade codigoBarraNumerico.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoBarraNumerico(String value) {
        this.codigoBarraNumerico = value;
    }

    /**
     * Obtém o valor da propriedade codigoTipoEnderecoBeneficiario.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getCodigoTipoEnderecoBeneficiario() {
        return codigoTipoEnderecoBeneficiario;
    }

    /**
     * Define o valor da propriedade codigoTipoEnderecoBeneficiario.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setCodigoTipoEnderecoBeneficiario(Short value) {
        this.codigoTipoEnderecoBeneficiario = value;
    }

    /**
     * Obtém o valor da propriedade nomeLogradouroBeneficiario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeLogradouroBeneficiario() {
        return nomeLogradouroBeneficiario;
    }

    /**
     * Define o valor da propriedade nomeLogradouroBeneficiario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeLogradouroBeneficiario(String value) {
        this.nomeLogradouroBeneficiario = value;
    }

    /**
     * Obtém o valor da propriedade nomeBairroBeneficiario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeBairroBeneficiario() {
        return nomeBairroBeneficiario;
    }

    /**
     * Define o valor da propriedade nomeBairroBeneficiario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeBairroBeneficiario(String value) {
        this.nomeBairroBeneficiario = value;
    }

    /**
     * Obtém o valor da propriedade nomeMunicipioBeneficiario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeMunicipioBeneficiario() {
        return nomeMunicipioBeneficiario;
    }

    /**
     * Define o valor da propriedade nomeMunicipioBeneficiario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeMunicipioBeneficiario(String value) {
        this.nomeMunicipioBeneficiario = value;
    }

    /**
     * Obtém o valor da propriedade codigoMunicipioBeneficiario.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodigoMunicipioBeneficiario() {
        return codigoMunicipioBeneficiario;
    }

    /**
     * Define o valor da propriedade codigoMunicipioBeneficiario.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodigoMunicipioBeneficiario(Integer value) {
        this.codigoMunicipioBeneficiario = value;
    }

    /**
     * Obtém o valor da propriedade siglaUfBeneficiario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiglaUfBeneficiario() {
        return siglaUfBeneficiario;
    }

    /**
     * Define o valor da propriedade siglaUfBeneficiario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiglaUfBeneficiario(String value) {
        this.siglaUfBeneficiario = value;
    }

    /**
     * Obtém o valor da propriedade codigoCepBeneficiario.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodigoCepBeneficiario() {
        return codigoCepBeneficiario;
    }

    /**
     * Define o valor da propriedade codigoCepBeneficiario.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodigoCepBeneficiario(Integer value) {
        this.codigoCepBeneficiario = value;
    }

    /**
     * Obtém o valor da propriedade indicadorComprovacaoBeneficiario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndicadorComprovacaoBeneficiario() {
        return indicadorComprovacaoBeneficiario;
    }

    /**
     * Define o valor da propriedade indicadorComprovacaoBeneficiario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndicadorComprovacaoBeneficiario(String value) {
        this.indicadorComprovacaoBeneficiario = value;
    }

    /**
     * Obtém o valor da propriedade numeroContratoCobranca.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumeroContratoCobranca() {
        return numeroContratoCobranca;
    }

    /**
     * Define o valor da propriedade numeroContratoCobranca.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumeroContratoCobranca(Integer value) {
        this.numeroContratoCobranca = value;
    }

    @Override
    public String toString() {
        return "Resposta{" +
                "siglaSistemaMensagem='" + siglaSistemaMensagem + '\'' +
                ", codigoRetornoPrograma=" + codigoRetornoPrograma +
                ", nomeProgramaErro='" + nomeProgramaErro + '\'' +
                ", textoMensagemErro='" + textoMensagemErro + '\'' +
                ", numeroPosicaoErroPrograma=" + numeroPosicaoErroPrograma +
                ", codigoTipoRetornoPrograma=" + codigoTipoRetornoPrograma +
                ", textoNumeroTituloCobrancaBb='" + textoNumeroTituloCobrancaBb + '\'' +
                ", numeroCarteiraCobranca=" + numeroCarteiraCobranca +
                ", numeroVariacaoCarteiraCobranca=" + numeroVariacaoCarteiraCobranca +
                ", codigoPrefixoDependenciaBeneficiario=" + codigoPrefixoDependenciaBeneficiario +
                ", numeroContaCorrenteBeneficiario=" + numeroContaCorrenteBeneficiario +
                ", codigoCliente=" + codigoCliente +
                ", linhaDigitavel='" + linhaDigitavel + '\'' +
                ", codigoBarraNumerico='" + codigoBarraNumerico + '\'' +
                ", codigoTipoEnderecoBeneficiario=" + codigoTipoEnderecoBeneficiario +
                ", nomeLogradouroBeneficiario='" + nomeLogradouroBeneficiario + '\'' +
                ", nomeBairroBeneficiario='" + nomeBairroBeneficiario + '\'' +
                ", nomeMunicipioBeneficiario='" + nomeMunicipioBeneficiario + '\'' +
                ", codigoMunicipioBeneficiario=" + codigoMunicipioBeneficiario +
                ", siglaUfBeneficiario='" + siglaUfBeneficiario + '\'' +
                ", codigoCepBeneficiario=" + codigoCepBeneficiario +
                ", indicadorComprovacaoBeneficiario='" + indicadorComprovacaoBeneficiario + '\'' +
                ", numeroContratoCobranca=" + numeroContratoCobranca +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RespostaEntity that = (RespostaEntity) o;
        return Objects.equals(getSiglaSistemaMensagem(), that.getSiglaSistemaMensagem()) &&
                Objects.equals(getCodigoRetornoPrograma(), that.getCodigoRetornoPrograma()) &&
                Objects.equals(getNomeProgramaErro(), that.getNomeProgramaErro()) &&
                Objects.equals(getTextoMensagemErro(), that.getTextoMensagemErro()) &&
                Objects.equals(getNumeroPosicaoErroPrograma(), that.getNumeroPosicaoErroPrograma()) &&
                Objects.equals(getCodigoTipoRetornoPrograma(), that.getCodigoTipoRetornoPrograma()) &&
                Objects.equals(getTextoNumeroTituloCobrancaBb(), that.getTextoNumeroTituloCobrancaBb()) &&
                Objects.equals(getNumeroCarteiraCobranca(), that.getNumeroCarteiraCobranca()) &&
                Objects.equals(getNumeroVariacaoCarteiraCobranca(), that.getNumeroVariacaoCarteiraCobranca()) &&
                Objects.equals(getCodigoPrefixoDependenciaBeneficiario(), that.getCodigoPrefixoDependenciaBeneficiario()) &&
                Objects.equals(getNumeroContaCorrenteBeneficiario(), that.getNumeroContaCorrenteBeneficiario()) &&
                Objects.equals(getCodigoCliente(), that.getCodigoCliente()) &&
                Objects.equals(getLinhaDigitavel(), that.getLinhaDigitavel()) &&
                Objects.equals(getCodigoBarraNumerico(), that.getCodigoBarraNumerico()) &&
                Objects.equals(getCodigoTipoEnderecoBeneficiario(), that.getCodigoTipoEnderecoBeneficiario()) &&
                Objects.equals(getNomeLogradouroBeneficiario(), that.getNomeLogradouroBeneficiario()) &&
                Objects.equals(getNomeBairroBeneficiario(), that.getNomeBairroBeneficiario()) &&
                Objects.equals(getNomeMunicipioBeneficiario(), that.getNomeMunicipioBeneficiario()) &&
                Objects.equals(getCodigoMunicipioBeneficiario(), that.getCodigoMunicipioBeneficiario()) &&
                Objects.equals(getSiglaUfBeneficiario(), that.getSiglaUfBeneficiario()) &&
                Objects.equals(getCodigoCepBeneficiario(), that.getCodigoCepBeneficiario()) &&
                Objects.equals(getIndicadorComprovacaoBeneficiario(), that.getIndicadorComprovacaoBeneficiario()) &&
                Objects.equals(getNumeroContratoCobranca(), that.getNumeroContratoCobranca());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSiglaSistemaMensagem(), getCodigoRetornoPrograma(), getNomeProgramaErro(), getTextoMensagemErro(), getNumeroPosicaoErroPrograma(), getCodigoTipoRetornoPrograma(), getTextoNumeroTituloCobrancaBb(), getNumeroCarteiraCobranca(), getNumeroVariacaoCarteiraCobranca(), getCodigoPrefixoDependenciaBeneficiario(), getNumeroContaCorrenteBeneficiario(), getCodigoCliente(), getLinhaDigitavel(), getCodigoBarraNumerico(), getCodigoTipoEnderecoBeneficiario(), getNomeLogradouroBeneficiario(), getNomeBairroBeneficiario(), getNomeMunicipioBeneficiario(), getCodigoMunicipioBeneficiario(), getSiglaUfBeneficiario(), getCodigoCepBeneficiario(), getIndicadorComprovacaoBeneficiario(), getNumeroContratoCobranca());
    }
}
