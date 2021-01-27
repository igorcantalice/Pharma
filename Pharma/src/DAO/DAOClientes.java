package DAO;

import connection.ConnectionSQLite;
import model.ModelClientes;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

/**
 *
 * @author icant
 */
public class DAOClientes extends ConnectionSQLite {

    // CADASTRAR CLIENTE NO BANCO // 
    public boolean salvarClientesDAO(ModelClientes pModelClientes) {
        conectar();

        String sql = "INSERT INTO tbl_clientes (cli_cpf, cli_nome, cli_endereco, cli_bairro, cli_contato) VALUES (?,?,?,?,?)";

        PreparedStatement preparedStatement = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);

        try {
            preparedStatement.setLong(1, pModelClientes.getCliCPF());
            preparedStatement.setString(2, pModelClientes.getCliNome());
            preparedStatement.setString(3, pModelClientes.getCliEndereco());
            preparedStatement.setString(4, pModelClientes.getCliBairro());
            preparedStatement.setString(5, pModelClientes.getCliContato());
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOClientes.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        desconectar();
        return true;
    }

    // CARREGAR LISTA DE CLIENTES //
    public List<ModelClientes> getListaClientesDAO() {
        List<ModelClientes> listaClientes = new ArrayList<>();
        ModelClientes modelClientes = new ModelClientes();
        conectar();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        String sql = "SELECT cli_cpf, cli_nome, cli_endereco, cli_bairro, cli_contato FROM tbl_clientes";

        try {
            preparedStatement = criarPreparedStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                modelClientes = new ModelClientes();
                modelClientes.setCliCPF(resultSet.getLong(1));
                modelClientes.setCliNome(resultSet.getString(2));
                modelClientes.setCliEndereco(resultSet.getString(3));
                modelClientes.setCliBairro(resultSet.getString(4));
                modelClientes.setCliContato(resultSet.getString(5));
                listaClientes.add(modelClientes);
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }
        desconectar();
        return listaClientes;
    }

    // EXCLUIR CLIENTE PELO CPF //
    public boolean excluirClientesDAO(long pCPF) {
        conectar();
        PreparedStatement preparedStatement;
        String sql = "DELETE FROM tbl_clientes WHERE cli_cpf = '" + pCPF + "'";
        preparedStatement = this.criarPreparedStatement(sql);
        try {
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOClientes.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return false;
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    Logger.getLogger(DAOClientes.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            }
        }
        this.desconectar();
        return true;
    }

    // CARREGAR CLIENTE POR CPF //
    public ModelClientes getClientesDAO(long pCPF) {
        ModelClientes modelClientes = new ModelClientes();
        conectar();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        String sql = "SELECT cli_cpf, cli_nome, cli_endereco, cli_bairro, cli_contato FROM tbl_clientes WHERE cli_cpf = '" + pCPF + "'";

        preparedStatement = criarPreparedStatement(sql);
        try {
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                modelClientes = new ModelClientes();
                modelClientes.setCliCPF(resultSet.getLong(1));
                modelClientes.setCliNome(resultSet.getString(2));
                modelClientes.setCliEndereco(resultSet.getString(3));
                modelClientes.setCliBairro(resultSet.getString(4));
                modelClientes.setCliContato(resultSet.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOClientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            System.err.println(e);
        }
        desconectar();
        return modelClientes;
    }

    // ATUALIZAR CADASTRO DE CLIENTES //
    public boolean alterarClientes(ModelClientes modelClientes) {
        this.conectar();

        String sql = "UPDATE tbl_clientes SET cli_nome=?, cli_endereco=?, cli_bairro=?, cli_contato=? WHERE cli_cpf = '" + modelClientes.getCliCPF() + "'";

        PreparedStatement preparedStatement = this.criarPreparedStatement(sql);

        try {
            preparedStatement.setString(1, modelClientes.getCliNome());
            preparedStatement.setString(2, modelClientes.getCliEndereco());
            preparedStatement.setString(3, modelClientes.getCliBairro());
            preparedStatement.setString(4, modelClientes.getCliContato());
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAOClientes.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    Logger.getLogger(DAOClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        this.desconectar();
        return true;
    }
}