/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import model.bean.TabelaConta;
import model.dao.TabelaDao;

/**
 *
 * @author Thiago Peres Bezerra
 */
public class View {

    public static void main(String[] args) {
        
        TabelaConta conta = new TabelaConta();
        TabelaDao dao = new TabelaDao();

        conta.setCpf_cnpj(0);
        conta.setNm_customer("");
        conta.setIs_active(true);
        conta.setVl_total(0);
    }
    
}