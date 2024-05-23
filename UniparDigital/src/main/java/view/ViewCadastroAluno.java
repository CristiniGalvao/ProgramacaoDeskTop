/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dao.AlunoDAO;
import dto.EnderecoDTO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import modelo.Aluno;
import service.EnderecoService;

/**
 *
 * @author aluno
 */
public class ViewCadastroAluno extends javax.swing.JFrame {

    private AlunoDAO alunoDao = new AlunoDAO();
    private boolean alunoPesquisado;
    private ArrayList<Aluno>lista;
    
    public ViewCadastroAluno() {
        initComponents();
        atualizaGrid();
    }
    public void atualizaGrid(){
        try{
            String sql = "SELECT * FROM public.\"Aluno\" ORDER BY \"RA_ALUNO\";";
            lista = new ArrayList<>();
            lista = alunoDao.retornaLista(sql);
            
           //Manipulação da tabela
           tbAlunos.removeAll();
           
           DefaultTableModel tableModel = new DefaultTableModel(new Object[][]{},new String[]{"RA","Nome","Dt.Nascimento"}){
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
               
           };
           
           //Cria as colunas
           tbAlunos.setModel(tableModel);
           
           //Adiciona as linhas a tabela com os dados dos alunos
           DefaultTableModel dm = (DefaultTableModel)tbAlunos.getModel();
           for(Aluno aluno : lista){
               dm.addRow(new Object[]{aluno.getRaAluno(),aluno.getNomeAluno(),aluno.getDtNascAluno()});
           }
           
           tbAlunos.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
               int linhaSelecionada = tbAlunos.getSelectedRow();
               if(linhaSelecionada != -1)
                   mostrarAluno(lista.get(linhaSelecionada));
           }
        });
           
        }catch(Exception ex){
            
        }
    }
    public void limparCampo(){
        tfRA.setText(" ");
        tfNome.setText(" ");
        ftfDTNasc.setText(" ");
        tfRA.setEditable(true);
        btSalvar.setEnabled(true);
    }
    private void mostrarAluno(Aluno aluno){
        tfRA.setText(String.valueOf(aluno.getRaAluno()));
        tfNome.setText(aluno.getNomeAluno());
        ftfDTNasc.setText(aluno.getDtNascAluno());
        tfRA.setEditable(false);
        btSalvar.setEnabled(false);
        alunoPesquisado = true;
    }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        lbTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbRA = new javax.swing.JLabel();
        tfRA = new javax.swing.JTextField();
        lbNome = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        lbNasc = new javax.swing.JLabel();
        btAtualizar = new javax.swing.JButton();
        btRemover = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btPesquisar = new javax.swing.JButton();
        ftfDTNasc = new javax.swing.JFormattedTextField();
        lbCep = new javax.swing.JLabel();
        lbCidadeUf = new javax.swing.JLabel();
        lbBairro = new javax.swing.JLabel();
        tfCep = new javax.swing.JTextField();
        tfCidadeUf = new javax.swing.JTextField();
        tfBairro = new javax.swing.JTextField();
        lbNumero = new javax.swing.JLabel();
        tfNumero = new javax.swing.JTextField();
        lbLogradouro = new javax.swing.JLabel();
        tfLogradouro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAlunos = new javax.swing.JTable();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbTitulo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setText("CADASTRO DE ALUNOS");

        lbRA.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbRA.setText("R.A:");

        lbNome.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNome.setText("Nome:");

        lbNasc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNasc.setText("Data Nascimento:");

        btAtualizar.setText("Atualizar");
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        btRemover.setText("Remover");
        btRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverActionPerformed(evt);
            }
        });

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        ftfDTNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        lbCep.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbCep.setText("Cep");

        lbCidadeUf.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbCidadeUf.setText("Cidade/Uf");

        lbBairro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbBairro.setText("Bairro");

        tfCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCepActionPerformed(evt);
            }
        });
        tfCep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfCepKeyPressed(evt);
            }
        });

        lbNumero.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNumero.setText("N°");

        tfNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNumeroActionPerformed(evt);
            }
        });

        lbLogradouro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbLogradouro.setText("Logradouro");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(btPesquisar)
                        .addGap(18, 18, 18)
                        .addComponent(btSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btAtualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btRemover)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tfRA, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                        .addComponent(lbCep)
                                        .addComponent(tfCep))
                                    .addComponent(lbBairro))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(lbNasc)
                                                        .addGap(0, 0, Short.MAX_VALUE))
                                                    .addComponent(ftfDTNasc)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(tfLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbLogradouro))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbNumero)
                                                    .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(93, 93, 93)
                                        .addComponent(lbCidadeUf))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(lbRA, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(48, 48, 48)
                                        .addComponent(lbNome))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfCidadeUf, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(98, 98, 98)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbRA)
                    .addComponent(lbNome)
                    .addComponent(lbNasc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfRA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftfDTNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbLogradouro)
                    .addComponent(lbCep)
                    .addComponent(lbNumero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCidadeUf)
                    .addComponent(lbBairro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCidadeUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btRemover)
                    .addComponent(btSalvar)
                    .addComponent(btPesquisar)
                    .addComponent(btAtualizar))
                .addGap(35, 35, 35))
        );

        tbAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbAlunos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 13, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverActionPerformed
        if(alunoPesquisado){
            alunoDao.delete(Integer.parseInt(tfRA.getText()), "Aluno", "RA_ALUNO");
            JOptionPane.showMessageDialog(this, "Aluno removido com sucesso!");
            limparCampo();
            atualizaGrid();
        }else{
            JOptionPane.showMessageDialog(this, "Selecione um aluno para remover","Atenção",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btRemoverActionPerformed

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        if(alunoPesquisado){
            
            Aluno aluno = new Aluno();
            aluno.setRaAluno(Integer.parseInt(tfRA.getText()));
            aluno.setNomeAluno(tfNome.getText());
            aluno.setDtNascAluno(ftfDTNasc.getText());
            
            if(alunoDao.atualizar(aluno)){
                JOptionPane.showMessageDialog(this, "Aluno atualizado com sucesso!");
                limparCampo();
                atualizaGrid();
            }else{
                JOptionPane.showMessageDialog(this, "Erro ao atualizar o aluno, Solicite suporte técnico","Erro",JOptionPane.ERROR_MESSAGE);
            }
        }else{
                JOptionPane.showMessageDialog(this, "Selecione um aluno para atualizar","Atenção",JOptionPane.WARNING_MESSAGE);
            }
        
    }//GEN-LAST:event_btAtualizarActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        Aluno novoAluno = new Aluno();
        novoAluno.setRaAluno(Integer.parseInt(tfRA.getText()));
        novoAluno.setNomeAluno(tfNome.getText());
        novoAluno.setDtNascAluno(ftfDTNasc.getText());
        
        if(alunoDao.salvar(novoAluno)){
            JOptionPane.showMessageDialog(this, "Aluno salvo com Sucesso!","Sucesso",JOptionPane.PLAIN_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Erro ao salvar aluno,solicite suporte técnico!","ERRO",JOptionPane.ERROR_MESSAGE);
        }
        atualizaGrid();
        limparCampo();
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void tfCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCepActionPerformed

    private void tfNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNumeroActionPerformed

    private void tfCepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCepKeyPressed
       if(evt.getKeyCode()==evt.VK_ENTER){
           if(!tfCep.getText().equals("")){
               try {
                   EnderecoDTO endereco = EnderecoService.buscaEndereco(tfCep.getText());
                   
                   tfLogradouro.setText(endereco.getLogradouro());
                   tfBairro.setText(endereco.getBairro());
                   tfCidadeUf.setText(endereco.getLocalidade()+"/"+endereco.getUf());
               } catch (Exception ex) {
                   Logger.getLogger(ViewCadastroAluno.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       }
    }//GEN-LAST:event_tfCepKeyPressed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btRemover;
    private javax.swing.JButton btSalvar;
    private javax.swing.JFormattedTextField ftfDTNasc;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbBairro;
    private javax.swing.JLabel lbCep;
    private javax.swing.JLabel lbCidadeUf;
    private javax.swing.JLabel lbLogradouro;
    private javax.swing.JLabel lbNasc;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbNumero;
    private javax.swing.JLabel lbRA;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JTable tbAlunos;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JTextField tfCep;
    private javax.swing.JTextField tfCidadeUf;
    private javax.swing.JTextField tfLogradouro;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfRA;
    // End of variables declaration//GEN-END:variables
}
