package View;

import Controladores.ControladoresDAO.controladorClientesDAO;
import Controladores.ControladoresDAO.controladorProdutoDAO;
import Model.DAO.ClienteDAO;
import Model.Tabelas.ModeloTabelaProduto;
import Model.Produto;
import Model.Tabelas.ModeloTabelaCliente;
import View.Alterar.AlterarProduto;
import View.Cadastro.cadastroCliente;
import View.Cadastro.cadastroProduto;


public class View_Cliente extends javax.swing.JInternalFrame {
    private controladorProdutoDAO controladorprodutosdao;
    private cadastroProduto cadastroproduto;    
    private ModeloTabelaProduto modelotabelaproduto;
    
    public View_Cliente() {
         initComponents();            
         setarModeloTabela();
    }  
       
    public void setarModeloTabela(){       
        ModeloTabelaCliente modelotabelacliente=new ModeloTabelaCliente(ClienteDAO.getInstance().retornarTodos());
        tabela.setModel(modelotabelacliente);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        botaoPesquisar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        botaoCadastrar = new javax.swing.JButton();
        botaoAlterar = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        setPreferredSize(new java.awt.Dimension(755, 296));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabela);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lupa-icone-4.png"))); // NOI18N

        botaoPesquisar.setText("Pesquisar");

        jLabel2.setFont(new java.awt.Font("Dubai", 1, 12)); // NOI18N
        jLabel2.setText("*Para alterar um cliente, selecione um abaixo ");

        botaoCadastrar.setText("Cadastrar");
        botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarActionPerformed(evt);
            }
        });

        botaoAlterar.setText("Alterar");
        botaoAlterar.setEnabled(false);
        botaoAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoPesquisar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(botaoCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoAlterar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jLabel2)))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCadastrar)
                    .addComponent(botaoAlterar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoPesquisar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)))
                .addGap(0, 32, Short.MAX_VALUE))
        );

        setBounds(0, 0, 754, 659);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarActionPerformed
        cadastroCliente cadastro= new cadastroCliente(tabela);
        cadastro.setVisible(true);
    }//GEN-LAST:event_botaoCadastrarActionPerformed

    private void botaoAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAlterarActionPerformed
        modelotabelaproduto= new ModeloTabelaProduto(controladorprodutosdao.retornarProdutos());
        Produto produto= modelotabelaproduto.obterProduto(tabela.getSelectedRow());
        AlterarProduto alterarproduto= new AlterarProduto(closable, tabela);
        alterarproduto.setarNome(produto.getNome());
        alterarproduto.setarCodigo(produto.getCodigo());
        alterarproduto.setVisible(true);      
    }//GEN-LAST:event_botaoAlterarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAlterar;
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JButton botaoPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
