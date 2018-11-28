/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.TabelaConta;

/**
 *
 * @author Thiago Peres Bezerra
 */
public class TabelaDao {
    public void create(TabelaConta conta){
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement("insert into tb_customer_account (cpf_cnpj, nm_customer, is_active, vl_total)values(?,?,?,?)");
            statement.setInt(1, conta.getCpf_cnpj());
            statement.setString(2, conta.getNm_customer());
            statement.setBoolean(3, conta.isIs_active());
            statement.setInt(4, conta.getVl_total());
            
            statement.executeLargeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar." +ex);
        }
        finally{
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
    public void calculomedia(TabelaConta conta){
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement("select avg (vl_total > '560') from tb_customer_account where between vl_total 1500 and 2700 order by desc;");
            statement.setInt(1, conta.getCpf_cnpj());
            statement.setString(2, conta.getNm_customer());
            statement.setBoolean(3, conta.isIs_active());
            statement.setInt(4, conta.getVl_total());
            
            statement.executeLargeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar." +ex);
        }
        finally{
            ConnectionFactory.closeConnection(connection, statement);
        }
    }   
}