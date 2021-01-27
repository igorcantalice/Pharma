package controller;

import model.ModelEstoque;
import DAO.DAOEstoque;
import java.util.ArrayList;

/**
 *
 * @author icant
 */
public class ControllerEstoque {

    private DAOEstoque daoEstoque = new DAOEstoque();

    // SALVA ESTOQUE //
    public int salvarEstoqueController(ModelEstoque pModelEstoque) {
        return this.daoEstoque.salvarEstoqueDAO(pModelEstoque);
    }

    // CARREGA ESTOQUE COM BASE AO ID//
    public ModelEstoque getEstoqueController(int pProdId) {
        return this.daoEstoque.getEstoqueDAO(pProdId);
    }

    // CARREGA ESTOQUE COM BASE A DESCRICAO //
    public ModelEstoque getEstoqueController(String pProdDescricao) {
        return this.daoEstoque.getEstoqueDAO(pProdDescricao);
    }

    // CARREGA OS PRODUTOS DO ESTOQUE NUMA LISTA //
    public ArrayList<ModelEstoque> getListaEstoqueController() {
        return this.daoEstoque.getListaEstoqueDAO();
    }

    // ATUALIZA ESTOQUE //
    public boolean atualizarEstoqueController(ModelEstoque pModelEstoque) {
        return this.daoEstoque.atualizarEstoqueDAO(pModelEstoque);
    }

    // EXCLUI UM PRODUTO DO ESTOQUE //
    public boolean excluirEstoqueController(int pProdId) {
        return this.daoEstoque.excluirEstoqueDAO(pProdId);
    }

}
