package DAO;

import model.ModelEstoque;
import connection.ConnectionSQLite;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author icant
 */
public class DAOEstoque extends ConnectionSQLite {

    // SALVA O ESTOQUE // 
    public int salvarEstoqueDAO(ModelEstoque pModelEstoque) {
        this.conectar();
        String sql
                = "INSERT INTO tbl_estoque ("
                + "prod_descricao,"
                + "prod_qtd,"
                + "prod_preco"
                + ") VALUES (?,?,?);";

        try (PreparedStatement preparedStatement = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, pModelEstoque.getProdDescricao());
            preparedStatement.setInt(2, pModelEstoque.getProdQtd());
            preparedStatement.setDouble(3, pModelEstoque.getProdPreco());
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.desconectar();
        }

    }

    // CARREGA O ESTOQUE COM BASE AO PARAMETRO PRODID //
    public ModelEstoque getEstoqueDAO(int pProdId) {
        ModelEstoque modelEstoque = null;

        String sql = "SELECT "
                + "pk_prod_id,"
                + "prod_descricao,"
                + "prod_qtd,"
                + "prod_preco"
                + " FROM"
                + " tbl_estoque"
                + " WHERE"
                + " pk_prod_id = ?"
                + ";";

        this.conectar();

        try (PreparedStatement preparedStatement = criarPreparedStatement(sql)) {

            preparedStatement.setInt(1, pProdId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                modelEstoque = new ModelEstoque();
                modelEstoque.setProdId(resultSet.getInt(1));
                modelEstoque.setProdDescricao(resultSet.getString(2));
                modelEstoque.setProdQtd(resultSet.getInt(3));
                modelEstoque.setProdPreco(resultSet.getDouble(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.desconectar();
        }
        return modelEstoque;
    }

    // CARREGA ESTOQUE NUMA LISTA //
    public ArrayList<ModelEstoque> getListaEstoqueDAO() {
        ArrayList<ModelEstoque> listamodelEstoque = new ArrayList();
        ModelEstoque modelEstoque = null;

        String sql = "SELECT "
                + "pk_prod_id,"
                + "prod_descricao,"
                + "prod_qtd,"
                + "prod_preco"
                + " FROM"
                + " tbl_estoque"
                + ";";

        this.conectar();

        try (PreparedStatement preparedStatement = criarPreparedStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                modelEstoque = new ModelEstoque();
                modelEstoque.setProdId(resultSet.getInt(1));
                modelEstoque.setProdDescricao(resultSet.getString(2));
                modelEstoque.setProdQtd(resultSet.getInt(3));
                modelEstoque.setProdPreco(resultSet.getDouble(4));
                listamodelEstoque.add(modelEstoque);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.desconectar();
        }
        return listamodelEstoque;
    }

    // CARREGA ESTOQUE COM BASE AO NOME DO PRODUTO //
    public ModelEstoque getEstoqueDAO(String pProdDescricao) {
        ModelEstoque modelEstoque = null;

        String sql = "SELECT "
                + "pk_prod_id,"
                + "prod_descricao,"
                + "prod_qtd,"
                + "prod_preco"
                + " FROM"
                + " tbl_estoque"
                + " WHERE"
                + " prod_descricao = '" + pProdDescricao + "'"
                + ";";

        this.conectar();

        try (PreparedStatement preparedStatement = criarPreparedStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                modelEstoque = new ModelEstoque();
                modelEstoque.setProdId(resultSet.getInt(1));
                modelEstoque.setProdDescricao(resultSet.getString(2));
                modelEstoque.setProdQtd(resultSet.getInt(3));
                modelEstoque.setProdPreco(resultSet.getDouble(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.desconectar();
        }
        return modelEstoque;
    }

    // ATUALIZA DADOS DO PRODUTO NO ESTOQUE //
    public boolean atualizarEstoqueDAO(ModelEstoque pModelEstoque) {
        this.conectar();
        String sql
                = "UPDATE tbl_estoque SET "
                + "prod_descricao = ?,"
                + "prod_qtd = ?,"
                + "prod_preco = ?"
                + " WHERE pk_prod_id = ? "
                + ";";

        try (PreparedStatement preparedStatement = criarPreparedStatement(sql)) {
            preparedStatement.setString(1, pModelEstoque.getProdDescricao());
            preparedStatement.setInt(2, pModelEstoque.getProdQtd());
            preparedStatement.setDouble(3, pModelEstoque.getProdPreco());
            preparedStatement.setInt(4, pModelEstoque.getProdId());
            return preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.desconectar();
        }

    }

    // EXCLUI PRODUTO NO ESTOQUE //
    public boolean excluirEstoqueDAO(int pProdId) {
        this.conectar();
        String sql
                = "DELETE FROM tbl_estoque "
                + " WHERE pk_prod_id = ? "
                + ";";

        try (PreparedStatement preparedStatement = criarPreparedStatement(sql)) {
            preparedStatement.setInt(1, pProdId);
            return preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.desconectar();
        }

    }
}
