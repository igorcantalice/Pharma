package controller;

import DAO.DAOClientes;
import java.util.List;
import model.ModelClientes;

/**
 *
 * @author icant
 */
public class ControllerClientes {

    DAOClientes dAOClientes = new DAOClientes();

    //SALVAR NOVO USUÁRIO NO BD// 
    public boolean salvarClientesController(ModelClientes modelClientes) {
        return this.dAOClientes.salvarClientesDAO(modelClientes);
    }

    //CARREGAR LISTA DE CLIENTES//
    public List<ModelClientes> getListaClientesController() {
        return this.dAOClientes.getListaClientesDAO();
    }

    public boolean excluirClientesController(long pCPF) {
        return this.dAOClientes.excluirClientesDAO(pCPF);
    }

    public ModelClientes getClientesController(long pCPF) {
        return this.dAOClientes.getClientesDAO(pCPF);
    }

    public boolean alterarClientesController(ModelClientes modelClientes) {
        return this.dAOClientes.alterarClientes(modelClientes);
    }

}
