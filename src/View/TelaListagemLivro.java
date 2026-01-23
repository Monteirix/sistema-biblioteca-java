
package View;


import DAO.LivroDAO;
import View.TelaAdm;
import javax.swing.table.DefaultTableModel;
import model.Livro;
import javax.swing.JOptionPane;


public class TelaListagemLivro extends javax.swing.JFrame {
    
    
    /**
     * Creates new form TelaListagemLivro
     */
    public TelaListagemLivro() {
        initComponents();
        setLocationRelativeTo(null); // centraliza a janela
        carregarTabela(); // carrega livros do banco
    }

    /**
     * Método para carregar os livros na JTable
     */
    private void carregarTabela() {
        DefaultTableModel model = (DefaultTableModel) tblLivros.getModel();
        model.setRowCount(0); // limpa tabela

        LivroDAO dao = new LivroDAO();
        for (Livro livro : dao.listar()) {
            model.addRow(new Object[]{
                livro.getId(),
                livro.getTitulo(),
                livro.getAutor(),
                livro.getCategoria(),
                livro.getQuantidade()
            });
        }
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaListagemLivro().setVisible(true);
            }
        });
    }                         
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblLivros = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Titulo", "Autor", "Categoria", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblLivros);

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVoltar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnVoltar))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
         // TODO add your handling code here:
         new TelaAdm().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
            int linhaSelecionada = tblLivros.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um livro para excluir!");
            return;
        }
            
        int opcao = JOptionPane.showConfirmDialog(this,
            "Tem certeza que deseja deletar este livro?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION);

        if (opcao != JOptionPane.YES_OPTION) {
            return;
        }
        int idLivro = Integer.parseInt(tblLivros.getValueAt(linhaSelecionada, 0).toString());
        
        LivroDAO dao = new LivroDAO();
        boolean sucesso = dao.excluir(idLivro);
        
         if (sucesso) {
            JOptionPane.showMessageDialog(this, "Livro deletado com sucesso!");
            DefaultTableModel model = (DefaultTableModel) tblLivros.getModel();
            model.removeRow(linhaSelecionada);
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao deletar livro!");
        }
        
    }//GEN-LAST:event_btnExcluirActionPerformed

        
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLivros;
    // End of variables declaration//GEN-END:variables
}
