/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unioeste.controle.juridico.view;

import br.dados.endereco.Endereco;
import br.unioeste.controle.juridico.start.ejb.StartAdvogadoBean;
import br.unioeste.controle.juridico.start.ejb.StartEnderecoBean;
import br.unioeste.controle.juridico.start.ejb.StartProcessoBean;
import br.uniotes.controle.juridico.advogado.Advogado;
import br.uniotes.controle.juridico.cliente.Cliente;
import br.uniotes.controle.juridico.forum.Forum;
import br.uniotes.controle.juridico.processo.Processo;
import br.uniotes.controle.juridico.processo.TipoProcesso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author hismahil
 */
public class CadastroProcesso extends javax.swing.JPanel {

    private Advogado adv;
    private Integer idCliente;
    private Integer idForum;
    
    public CadastroProcesso() {
        initComponents();
        
        btnPesquisarForum.addActionListener(new PesquisarForum());
        btnPesquisarCliente.addActionListener(new PesquisarCliente());
        btnPesquisarAdvogado.addActionListener(new PesquisarAdvogado());
        btnSalvar.addActionListener(new SalvarProcesso());
    }

    private class PesquisarForum implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(txtIDForum.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Digite o ID", "ID", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                String str = obterForum(Integer.parseInt(txtIDForum.getText()));//pelo WS
                txtDadosForum.setText(str);
                
                String[] split = str.split(",");
                
                idForum = Integer.parseInt(split[0]); //pega o ID do forum
                
                //pega o endereco pelo EJB
                Endereco end = StartEnderecoBean.getRemote().obterEnderecoPorID(Integer.parseInt(split[4]));
                
                StringBuilder build = new StringBuilder();
                build.append(end.getRua().getTipo().getTipo() + " ");
                build.append(end.getRua().getNome() + ",");
                build.append(end.getBairro().getNome() + ",");
                build.append(end.getCidade().getNome());
                
                txtEndForum.setText(build.toString());
            }
        }
    }
    
    private class PesquisarCliente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(txtIDCliente.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Digite o ID", "ID", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                String str = obterClientePeloID(Integer.parseInt(txtIDCliente.getText()));
                txtDadosCliente.setText(str);
                
                String[] split = str.split(",");
                
                idCliente = Integer.parseInt(split[0]); //ID do cliente
                
                //endereco pelo EJB
                Endereco end = StartEnderecoBean.getRemote().obterEnderecoPorID(Integer.parseInt(split[4]));
                
                StringBuilder build = new StringBuilder();
                build.append(end.getRua().getTipo().getTipo() + " ");
                build.append(end.getRua().getNome() + ",");
                build.append(end.getBairro().getNome() + ",");
                build.append(end.getCidade().getNome());
                
                txtEndCliente.setText(build.toString());
            }
        }   
    }
    
    private class PesquisarAdvogado implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(txtIDAdv.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Digite o ID", "ID", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                adv = StartAdvogadoBean.getRemote().obterAdvogado(Integer.parseInt(txtIDAdv.getText()));
                
                StringBuilder a = new StringBuilder();
                a.append(adv.getNome() + ",");
                a.append(adv.getSobreNome() + ",");
                a.append(adv.getNroOAB());
                
                txtDadosAdv.setText(a.toString());
                
                Endereco end = StartEnderecoBean.getRemote().obterEnderecoPorID(adv.getEnd().getCodEnd());
                
                StringBuilder build = new StringBuilder();
                build.append(end.getRua().getTipo().getTipo() + " ");
                build.append(end.getRua().getNome() + ",");
                build.append(end.getBairro().getNome() + ",");
                build.append(end.getCidade().getNome());
                
                txtEndAdv.setText(build.toString());
            }
        }   
    }
    
    private class SalvarProcesso implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            Processo proc = new Processo();
            proc.setDtAbertura(sdf.format(new Date(System.currentTimeMillis())));
            proc.setDescricao(txtAreaDescricao.getText());
            proc.setNroProcesso(txtNroProc.getText());
            proc.setSituacao(0);

            proc.setAdvogado(adv);

            Cliente cli = new Cliente();
            cli.setCodCli(idCliente);
            proc.setCliente(cli);

            Forum forum = new Forum();
            forum.setCodForum(idForum);
            proc.setForum(forum);

            TipoProcesso tipo = new TipoProcesso();
            tipo.setCodTipoProcesso(cbTipoProc.getSelectedIndex() + 1);
            tipo.setTipo(getTipoProcesso(cbTipoProc.getSelectedIndex()));
            proc.setTipo(tipo);
            
            proc = StartProcessoBean.getRemote().insertProcesso(proc);
        }
    }
    
    private String getTipoProcesso(int i){
        switch(i){
            case 0: return "Processo Civel";
            case 1: return "Processo Penal";
            case 2: return "Ação Trabalhista";
            case 3: return "Ação Tributária";
        }
        return null;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNroProc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDtAbertura = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbTipoProc = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaDescricao = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtIDForum = new javax.swing.JTextField();
        btnPesquisarForum = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtDadosForum = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEndForum = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtIDCliente = new javax.swing.JTextField();
        btnPesquisarCliente = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtDadosCliente = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtEndCliente = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtIDAdv = new javax.swing.JTextField();
        btnPesquisarAdvogado = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtDadosAdv = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtEndAdv = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dados do processo"));

        jLabel1.setText("Nro. Processo:");

        jLabel2.setText("Data abertura:");

        jLabel3.setText("Tipo de processo:");

        cbTipoProc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Processo Civel", "Processo Penal", "Ação Trabalhista", "Ação Tributária" }));

        jLabel4.setText("Descrição:");

        txtAreaDescricao.setColumns(20);
        txtAreaDescricao.setRows(5);
        jScrollPane1.setViewportView(txtAreaDescricao);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Forum"));

        jLabel5.setText("Pesquisar por ID:");

        btnPesquisarForum.setText("Pesquisar");

        jLabel6.setText("Dados:");

        jLabel7.setText("Endereco:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtIDForum, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisarForum))
                    .addComponent(txtDadosForum, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                    .addComponent(txtEndForum))
                .addGap(176, 176, 176))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtIDForum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisarForum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDadosForum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtEndForum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do cliente"));

        jLabel8.setText("Pesquisar por ID:");

        btnPesquisarCliente.setText("Pesquisar");

        jLabel9.setText("Dados:");

        jLabel10.setText("Endereço:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisarCliente))
                    .addComponent(txtDadosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                    .addComponent(txtEndCliente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtDadosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtEndCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Advogado"));

        jLabel11.setText("Pesquisar por ID:");

        btnPesquisarAdvogado.setText("Pesquisar");

        jLabel12.setText("Dados:");

        jLabel13.setText("Endereço:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtIDAdv, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisarAdvogado))
                    .addComponent(txtDadosAdv, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(txtEndAdv))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtIDAdv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisarAdvogado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtDadosAdv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtEndAdv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 29, Short.MAX_VALUE))
        );

        btnSalvar.setText("Salvar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(51, 51, 51)
                        .addComponent(txtNroProc, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDtAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbTipoProc, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNroProc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtDtAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbTipoProc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnSalvar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisarAdvogado;
    private javax.swing.JButton btnPesquisarCliente;
    private javax.swing.JButton btnPesquisarForum;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbTipoProc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAreaDescricao;
    private javax.swing.JTextField txtDadosAdv;
    private javax.swing.JTextField txtDadosCliente;
    private javax.swing.JTextField txtDadosForum;
    private javax.swing.JTextField txtDtAbertura;
    private javax.swing.JTextField txtEndAdv;
    private javax.swing.JTextField txtEndCliente;
    private javax.swing.JTextField txtEndForum;
    private javax.swing.JTextField txtIDAdv;
    private javax.swing.JTextField txtIDCliente;
    private javax.swing.JTextField txtIDForum;
    private javax.swing.JTextField txtNroProc;
    // End of variables declaration//GEN-END:variables

    private static String obterClientePeloID(int id) {
        br.unioeste.controle.juridico.ws.cliente.ClienteWS_Service service = new br.unioeste.controle.juridico.ws.cliente.ClienteWS_Service();
        br.unioeste.controle.juridico.ws.cliente.ClienteWS port = service.getClienteWSPort();
        return port.obterClientePeloID(id);
    }

    private static String obterForum(int id) {
        br.unioeste.controle.juridico.ws.forum.ForumWS_Service service = new br.unioeste.controle.juridico.ws.forum.ForumWS_Service();
        br.unioeste.controle.juridico.ws.forum.ForumWS port = service.getForumWSPort();
        return port.obterForum(id);
    }
}
