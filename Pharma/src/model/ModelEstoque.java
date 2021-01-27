package model;
/**
*
* @author icant
*/
public class ModelEstoque {

    private int prodId;
    private String prodDescricao;
    private int prodQtd;
    private double prodPreco;

    // CONSTRUTOR //
    public ModelEstoque(){}

    // SETA VALOR DE PROD ID //
    public void setProdId(int pProdId){
        this.prodId = pProdId;
    }
    //RETORNA VALOR DE PROD ID //
    public int getProdId(){
        return this.prodId;
    }

    // SETA VALOR DE PROD DESCRICAO//
    public void setProdDescricao(String pProdDescricao){
        this.prodDescricao = pProdDescricao;
    }

    // RETORNA VALOR DE PROD DESCRICAO//
    public String getProdDescricao(){
        return this.prodDescricao;
    }

    // SETA VALOR DE PROD QTD//
    public void setProdQtd(int pProdQtd){
        this.prodQtd = pProdQtd;
    }
    // RETORNA VALOR DE PROD QTD//
    public int getProdQtd(){
        return this.prodQtd;
    }

    // SETA VALOR DE PROD PRECO//
    public void setProdPreco(double pProdPreco){
        this.prodPreco = pProdPreco;
    }

    // RETORNA VALOR DE PROD PRECO//
    public double getProdPreco(){
        return this.prodPreco;
    }
}