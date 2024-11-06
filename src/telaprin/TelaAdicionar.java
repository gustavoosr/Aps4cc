/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telaprin;
import java.sql.Connection;
import java.sql.PreparedStatement ;
import connection.DAO;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author gusta
 */
public class TelaAdicionar extends javax.swing.JFrame {
    DAO dao = new DAO();
    private PreparedStatement  pst;
    private Connection con;
    private FileInputStream fis;
    private int tamanho;
    private boolean ftCarregada = false;
    private String fileName;
    private String locImg;
    private String tipoImg;
    private int tamImg;
    
    public TelaAdicionar() {
        initComponents();
        InserirIcone(this);
        
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LtitAdd = new javax.swing.JLabel();
        bVoltar = new javax.swing.JButton();
        LfotoAdd = new javax.swing.JLabel();
        bCarregaImg = new javax.swing.JButton();
        bSalvar = new javax.swing.JButton();
        lnomeFoto = new javax.swing.JLabel();
        ltamanhoFoto = new javax.swing.JLabel();
        llocalFoto = new javax.swing.JLabel();
        ltipoImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adicionar Imagem");
        setLocation(new java.awt.Point(400, 85));
        setResizable(false);

        LtitAdd.setBackground(new java.awt.Color(204, 204, 204));
        LtitAdd.setFont(new java.awt.Font("DejaVu Math TeX Gyre", 2, 14)); // NOI18N
        LtitAdd.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LtitAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgProjeto/imgTelaAdicionar/adicionar-imagemTitulo.png"))); // NOI18N
        LtitAdd.setText("Adicionar Imagem");
        LtitAdd.setToolTipText("Adicionar Imagem");
        LtitAdd.setName("Tela Adicionar"); // NOI18N
        LtitAdd.setOpaque(true);

        bVoltar.setBackground(new java.awt.Color(204, 204, 204));
        bVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgProjeto/imgTelaAdicionar/voltar.png"))); // NOI18N
        bVoltar.setText("Voltar");
        bVoltar.setToolTipText("Voltar ao Menu Principal");
        bVoltar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        bVoltar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        bVoltar.setRolloverEnabled(false);
        bVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVoltarActionPerformed(evt);
            }
        });

        LfotoAdd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LfotoAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgProjeto/imgTelaAdicionar/fotoTelaAdd.png"))); // NOI18N
        LfotoAdd.setToolTipText("Imagem");
        LfotoAdd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        bCarregaImg.setBackground(new java.awt.Color(204, 204, 204));
        bCarregaImg.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        bCarregaImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgProjeto/imgTelaAdicionar/carregar.png"))); // NOI18N
        bCarregaImg.setText("Carregar Imagem");
        bCarregaImg.setToolTipText("Carregar Imagem");
        bCarregaImg.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(153, 153, 153)));
        bCarregaImg.setRolloverEnabled(false);
        bCarregaImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCarregaImgActionPerformed(evt);
            }
        });

        bSalvar.setBackground(new java.awt.Color(204, 204, 204));
        bSalvar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        bSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgProjeto/imgTelaAdicionar/disquete.png"))); // NOI18N
        bSalvar.setText("Salvar");
        bSalvar.setToolTipText("Salvar Imagem");
        bSalvar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        bSalvar.setRolloverEnabled(false);
        bSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalvarActionPerformed(evt);
            }
        });

        lnomeFoto.setBackground(new java.awt.Color(204, 204, 204));
        lnomeFoto.setFont(new java.awt.Font("Segoe UI Historic", 1, 10)); // NOI18N
        lnomeFoto.setText("Nome Arquivo:");
        lnomeFoto.setToolTipText("Nome Arquivo");

        ltamanhoFoto.setFont(new java.awt.Font("Segoe UI Historic", 1, 10)); // NOI18N
        ltamanhoFoto.setText("Tamanho:");
        ltamanhoFoto.setToolTipText("Tamanho");

        llocalFoto.setFont(new java.awt.Font("Segoe UI Historic", 1, 10)); // NOI18N
        llocalFoto.setText("Local:");
        llocalFoto.setToolTipText("Local");

        ltipoImg.setFont(new java.awt.Font("Segoe UI Historic", 1, 10)); // NOI18N
        ltipoImg.setText("Tipo Arquivo:");
        ltipoImg.setToolTipText("Tipo Arquivo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LtitAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bCarregaImg, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LfotoAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(lnomeFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ltamanhoFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(llocalFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ltipoImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LtitAdd)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(LfotoAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(bCarregaImg, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addComponent(ltipoImg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lnomeFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ltamanhoFoto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(llocalFoto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        LfotoAdd.getAccessibleContext().setAccessibleDescription("");

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVoltarActionPerformed
        TelaMenu telaMenu = new TelaMenu();
        telaMenu.setVisible(true);
        dispose();
    }//GEN-LAST:event_bVoltarActionPerformed

    private void bCarregaImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCarregaImgActionPerformed
             carregarFoto();
    }//GEN-LAST:event_bCarregaImgActionPerformed

    private void bSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalvarActionPerformed
        Status();
        Salvar();
    }//GEN-LAST:event_bSalvarActionPerformed
     

// metodo para carregar a foto
    
    private void carregarFoto(){
        JFileChooser jfc = new JFileChooser();
        jfc.setDialogTitle("Abrir Arquivo");
        jfc.setFileFilter(new FileNameExtensionFilter("Arquivo de Imagem (*.PNG,*.JPG,*.JPEG)", "png", "jpg", "jpeg"));
        int result = jfc.showOpenDialog(this);
        if(result == JFileChooser.APPROVE_OPTION){
          try{
              File selectedFile = jfc.getSelectedFile();
              fis = new FileInputStream(jfc.getSelectedFile());
              tamanho =  (int) jfc.getSelectedFile().length();
              Image foto = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(LfotoAdd.getWidth(), LfotoAdd.getHeight(), Image.SCALE_SMOOTH);
              LfotoAdd.setIcon(new ImageIcon(foto));
              LfotoAdd.updateUI();
              fileName = selectedFile.getName();
              tamImg = (int) selectedFile.length();
              locImg = selectedFile.getPath();
              tipoImg = fileName.substring(fileName.lastIndexOf(".") + 1);
              fis = new FileInputStream(selectedFile);
              bSalvar.setEnabled(true);
              
              //formatando o tamanho da IMG
              DecimalFormat df = new DecimalFormat("##.#");
              
              
              lnomeFoto.setText("Nome Arquivo: " + fileName );
              ltamanhoFoto.setText("Tamanho: " + df.format(tamImg) + " bytes" );
              llocalFoto.setText("Local: " + locImg);
              ltipoImg.setText("Tipo Arquivo:  " + tipoImg);
              ftCarregada = true;
          }catch(Exception e){
              JOptionPane.showMessageDialog(null, "Erro ao subir o arquivo, tente novamente!!");
          } 
        }
            
    }
    
    public void InserirIcone (JFrame frm){
        try{
            frm.setIconImage(Toolkit.getDefaultToolkit().getImage("src/imgProjeto/imgTelaPrin/iconetelaprin.png"));
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
    public void Status(){
        try {
            con = dao.conectar();
            if (con == null) {
                System.out.println("Erro de conexão");
            } else {
                System.out.println("Banco de dados conectado");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private void Salvar() {
        if (fis == null) {
            bSalvar.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Selecione uma imagem primeiro!!");
            return; // Sai do método se fis for nulo
        }
        String insert = "insert into iup_picture (imagem, nome_arquivo) values (?,?)";
        try {

            con = dao.conectar();
            pst = con.prepareStatement(insert);
            pst.setBlob(1, fis, tamanho);
            pst.setString(2, fileName);
            int confirma = pst.executeUpdate();
            if (confirma == 1) {
                JOptionPane.showMessageDialog(null, "Imagem Salva no banco de dados!!");
                resetar();
            } else {
                JOptionPane.showMessageDialog(null, "Erro! Não foi possível salvar a imagem.");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private void resetar(){
        lnomeFoto.setText("Nome Arquivo: ");
        ltamanhoFoto.setText("Tamanho: ");
        llocalFoto.setText("Local: ");
        ltipoImg.setText("Tipo Arquivo:  ");
        LfotoAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgProjeto/imgTelaAdicionar/fotoTelaAdd.png")));
        fis = null;
        
    }
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LfotoAdd;
    private javax.swing.JLabel LtitAdd;
    private javax.swing.JButton bCarregaImg;
    private javax.swing.JButton bSalvar;
    private javax.swing.JButton bVoltar;
    private javax.swing.JLabel llocalFoto;
    private javax.swing.JLabel lnomeFoto;
    private javax.swing.JLabel ltamanhoFoto;
    private javax.swing.JLabel ltipoImg;
    // End of variables declaration//GEN-END:variables

}
