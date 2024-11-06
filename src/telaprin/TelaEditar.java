/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telaprin;

import java.sql.Connection;
import connection.DAO;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.JFrame;
import java.sql.*;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import telaprin.TelaMenu;

/**
 *
 * @author gusta
 */
public class TelaEditar extends javax.swing.JFrame {

    DAO dao = new DAO();
    private PreparedStatement pst;
    private Connection con;
    private FileInputStream fis;
    private ResultSet rs;
    private int tamanho;
    private boolean ftCarregada = false;
    private String fileName;
    private String locImg;
    private String tipoImg;
    private int tamImg;

    public TelaEditar() {
        initComponents();
        InserirIcone(this);
        desativaBotao();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        LtitEditar = new javax.swing.JLabel();
        bVoltar = new javax.swing.JButton();
        bExcluir = new javax.swing.JButton();
        bEditar = new javax.swing.JButton();
        painelPrin = new javax.swing.JPanel();
        lblFoto = new javax.swing.JLabel();
        caixaTxtId = new javax.swing.JTextField();
        caixaTxtNome = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableResult = new javax.swing.JTable();
        lblID = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        txtcaixaData = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        bSalvarAlteracao = new javax.swing.JButton();
        bPesquisar = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Imagem");
        setLocation(new java.awt.Point(400, 45));
        setName("Editar Imagem"); // NOI18N
        setResizable(false);

        LtitEditar.setBackground(new java.awt.Color(204, 204, 204));
        LtitEditar.setFont(new java.awt.Font("DejaVu Math TeX Gyre", 2, 14)); // NOI18N
        LtitEditar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LtitEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgProjeto/imgTelaEditar/editar-titulo.png"))); // NOI18N
        LtitEditar.setText("Editar Imagem");
        LtitEditar.setToolTipText("Editar imagem");
        LtitEditar.setMaximumSize(new java.awt.Dimension(182, 50));
        LtitEditar.setMinimumSize(new java.awt.Dimension(182, 50));
        LtitEditar.setOpaque(true);
        LtitEditar.setPreferredSize(new java.awt.Dimension(182, 50));

        bVoltar.setBackground(new java.awt.Color(204, 204, 204));
        bVoltar.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        bVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgProjeto/imgTelaEditar/voltar.png"))); // NOI18N
        bVoltar.setText("Voltar");
        bVoltar.setToolTipText("Voltar a tela inicial");
        bVoltar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        bVoltar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bVoltar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVoltarActionPerformed(evt);
            }
        });

        bExcluir.setBackground(new java.awt.Color(204, 204, 204));
        bExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgProjeto/imgTelaEditar/lixeira.png"))); // NOI18N
        bExcluir.setToolTipText("Excluir");
        bExcluir.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        bExcluir.setRolloverEnabled(false);
        bExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExcluirActionPerformed(evt);
            }
        });

        bEditar.setBackground(new java.awt.Color(204, 204, 204));
        bEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgProjeto/imgTelaEditar/editar-telaEdit(1).png"))); // NOI18N
        bEditar.setToolTipText("Editar");
        bEditar.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(204, 204, 204)));
        bEditar.setRolloverEnabled(false);
        bEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditarActionPerformed(evt);
            }
        });

        painelPrin.setBackground(new java.awt.Color(102, 102, 102));

        lblFoto.setBackground(new java.awt.Color(102, 102, 102));
        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgProjeto/imgTelaEditar/fotoTelaEdit.png"))); // NOI18N
        lblFoto.setToolTipText("Imagem");
        lblFoto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblFoto.setOpaque(true);

        caixaTxtId.setBackground(new java.awt.Color(204, 204, 204));
        caixaTxtId.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        caixaTxtId.setToolTipText("ID Imagem");
        caixaTxtId.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        caixaTxtId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                caixaTxtIdFocusGained(evt);
            }
        });
        caixaTxtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caixaTxtIdActionPerformed(evt);
            }
        });
        caixaTxtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caixaTxtIdKeyTyped(evt);
            }
        });

        caixaTxtNome.setBackground(new java.awt.Color(204, 204, 204));
        caixaTxtNome.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        caixaTxtNome.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        caixaTxtNome.setToolTipText("Nome do Arquivo");
        caixaTxtNome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        caixaTxtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caixaTxtNomeActionPerformed(evt);
            }
        });
        caixaTxtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caixaTxtNomeKeyTyped(evt);
            }
        });

        jTableResult.setBackground(new java.awt.Color(204, 204, 204));
        jTableResult.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jTableResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Imagem", "Nome arquivo", "Data Cadastro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableResult.setToolTipText("Resultados da busca");
        jTableResult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableResultMouseClicked(evt);
            }
        });
        jTableResult.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableResultKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(jTableResult);

        lblID.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        lblID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblID.setText("ID Imagem");

        lblNome.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        lblNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNome.setText("Nome Arquivo");

        lblData.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        lblData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblData.setText("Data Cadastro");

        txtcaixaData.setBackground(new java.awt.Color(204, 204, 204));
        txtcaixaData.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            txtcaixaData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtcaixaData.setToolTipText("Data Cadastro");
        txtcaixaData.setActionCommand("<Not Set>");
        txtcaixaData.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtcaixaData.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        txtcaixaData.setOpaque(true);
        txtcaixaData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcaixaDataActionPerformed(evt);
            }
        });
        txtcaixaData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcaixaDataKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ano/mês/dia");

        bSalvarAlteracao.setBackground(new java.awt.Color(204, 204, 204));
        bSalvarAlteracao.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        bSalvarAlteracao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgProjeto/imgTelaAdicionar/disquete.png"))); // NOI18N
        bSalvarAlteracao.setToolTipText("Salvar");
        bSalvarAlteracao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bSalvarAlteracao.setRequestFocusEnabled(false);
        bSalvarAlteracao.setRolloverEnabled(false);
        bSalvarAlteracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalvarAlteracaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelPrinLayout = new javax.swing.GroupLayout(painelPrin);
        painelPrin.setLayout(painelPrinLayout);
        painelPrinLayout.setHorizontalGroup(
            painelPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrinLayout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPrinLayout.createSequentialGroup()
                .addGroup(painelPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPrinLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(painelPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(caixaTxtId)
                            .addComponent(lblID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(100, 100, 100)
                        .addGroup(painelPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(caixaTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(painelPrinLayout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(bSalvarAlteracao)
                        .addGap(18, 18, 18)
                        .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(painelPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtcaixaData)
                    .addComponent(lblData, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(63, 63, 63))
        );
        painelPrinLayout.setVerticalGroup(
            painelPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrinLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(painelPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(lblNome)
                    .addComponent(lblData))
                .addGap(18, 18, 18)
                .addGroup(painelPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(caixaTxtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(caixaTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcaixaData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(painelPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPrinLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel1))
                    .addGroup(painelPrinLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(painelPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bSalvarAlteracao)
                            .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                .addContainerGap())
        );

        bPesquisar.setBackground(new java.awt.Color(204, 204, 204));
        bPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgProjeto/imgTelaEditar/lupaTelaedit.png"))); // NOI18N
        bPesquisar.setToolTipText("Pesquisar");
        bPesquisar.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(204, 204, 204)));
        bPesquisar.setRolloverEnabled(false);
        bPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LtitEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(painelPrin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(bExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LtitEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelPrin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(bPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(bVoltar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVoltarActionPerformed
        TelaMenu telaMenu = new TelaMenu();
        telaMenu.setVisible(true);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_bVoltarActionPerformed

    private void caixaTxtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caixaTxtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caixaTxtIdActionPerformed

    private void bPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPesquisarActionPerformed
        BuscarIMG();        // TODO add your handling code here:
    }//GEN-LAST:event_bPesquisarActionPerformed

    private void caixaTxtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caixaTxtIdKeyTyped
        String caracteres = "0123456789";
        int limite = 8;
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
        if (caixaTxtId.getText().length() > limite) {
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_caixaTxtIdKeyTyped

    private void txtcaixaDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcaixaDataActionPerformed

    }//GEN-LAST:event_txtcaixaDataActionPerformed

    private void txtcaixaDataKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcaixaDataKeyTyped

    }//GEN-LAST:event_txtcaixaDataKeyTyped

    private void caixaTxtIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_caixaTxtIdFocusGained

    }//GEN-LAST:event_caixaTxtIdFocusGained

    private void caixaTxtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caixaTxtNomeActionPerformed

    }//GEN-LAST:event_caixaTxtNomeActionPerformed

    private void caixaTxtNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caixaTxtNomeKeyTyped

    }//GEN-LAST:event_caixaTxtNomeKeyTyped

    private void jTableResultKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableResultKeyPressed
    }//GEN-LAST:event_jTableResultKeyPressed

    private void jTableResultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableResultMouseClicked
        if (jTableResult.getSelectedRow() != -1) {
            MostraImg();
        }

    }//GEN-LAST:event_jTableResultMouseClicked

    private void bSalvarAlteracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalvarAlteracaoActionPerformed
        Salvar();
    }//GEN-LAST:event_bSalvarAlteracaoActionPerformed

    private void bEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditarActionPerformed
        carregarIMG();
    }//GEN-LAST:event_bEditarActionPerformed

    private void bExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExcluirActionPerformed

        Deletar();
    }//GEN-LAST:event_bExcluirActionPerformed
   
    private void Deletar() {
        int confirmaExcluir = JOptionPane.showConfirmDialog(null, "Você confirma a exclusão dessa imagem?", "Atenção!!", JOptionPane.YES_NO_OPTION);
        if (confirmaExcluir == JOptionPane.YES_OPTION) {
            int linhaSelecionada = jTableResult.getSelectedRow();
            String id = jTableResult.getValueAt(linhaSelecionada, 0).toString();
            String delete = "delete from iup_picture where id = ?";
            try {
                con = DAO.conectar();
                pst = con.prepareStatement(delete);
                pst.setInt(1, Integer.parseInt(id));
                int confirma = pst.executeUpdate();
                if (confirma == 1) {
                    limpaTabela();
                    resetar();
                    JOptionPane.showMessageDialog(null, "Item removido com sucessso!");
                }
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    private void Salvar() {
        if (fis == null) {
            bSalvarAlteracao.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Selecione uma imagem primeiro!!");
            return; // Sai do método se fis for nulo
        }
        String update = "update iup_picture set imagem = ?, nome_arquivo = ? where id = ?";
        int linhaSelecionada = jTableResult.getSelectedRow();
        String id = jTableResult.getValueAt(linhaSelecionada, 0).toString();
        try {
            con = dao.conectar();
            pst = con.prepareStatement(update);
            pst.setBlob(1, fis, tamanho);
            pst.setString(2, caixaTxtNome.getText());
            pst.setInt(3, Integer.parseInt(id) );
            int confirma = pst.executeUpdate();
            if (confirma == 1) {
                JOptionPane.showMessageDialog(null, "Alteração feita com sucessso!");
                
            } else {
                JOptionPane.showMessageDialog(null, "Erro! Não foi possível alterar a imagem.");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        limpaTabela();
        resetar();
    }
    
    private void carregarIMG(){
    JFileChooser jfc = new JFileChooser();
        jfc.setDialogTitle("Abrir Arquivo");
        jfc.setFileFilter(new FileNameExtensionFilter("Arquivo de Imagem (*.PNG,*.JPG,*.JPEG)", "png", "jpg", "jpeg"));
        int result = jfc.showOpenDialog(this);
        if(result == JFileChooser.APPROVE_OPTION){
          try{
              File selectedFile = jfc.getSelectedFile();
              fis = new FileInputStream(jfc.getSelectedFile());
              tamanho =  (int) jfc.getSelectedFile().length();
              Image foto = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH);
              lblFoto.setIcon(new ImageIcon(foto));
              lblFoto.updateUI();
              fileName = selectedFile.getName();
              tamImg = (int) selectedFile.length();
              locImg = selectedFile.getPath();
              tipoImg = fileName.substring(fileName.lastIndexOf(".") + 1);
              fis = new FileInputStream(selectedFile);
              caixaTxtNome.setText(fileName);
              bSalvarAlteracao.setEnabled(true);
              
          }catch(Exception e){
               JOptionPane.showMessageDialog(null, "Erro ao subir o arquivo, tente novamente!!");

          }
        }
    }
    
    private void BuscarIMG() {
        if (caixaTxtId.getText().isEmpty() && caixaTxtNome.getText().isEmpty() && "    -  -  ".equals(txtcaixaData.getText())) {
            JOptionPane.showMessageDialog(null, "Preencha alguma informação para realizar a busca!");
        } else {
            limpaTabela();
            if (caixaTxtId.getText() != null) {
                String readID = "select id, nome_arquivo, data_cadastro from iup_picture where id = ? ";
                try {
                    con = DAO.conectar();
                    pst = con.prepareStatement(readID);
                    pst.setString(1, caixaTxtId.getText());
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        String id = rs.getString("id");
                        String nome_arquivo = rs.getString("nome_arquivo");
                        String data_cadastro = rs.getString("data_cadastro");
                        DefaultTableModel jtableResultado = (DefaultTableModel) jTableResult.getModel();
                        Object[] dados = {id, nome_arquivo, data_cadastro};
                        jtableResultado.addRow(dados);
                    }
                    con.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Imagem não cadastrada! Não foi possível obter o ID");
                    System.out.println(e);
                }
            }
            if (!caixaTxtNome.getText().isEmpty() && caixaTxtId.getText().isEmpty()) {

                String readNome = "select id, nome_arquivo, data_cadastro from iup_picture where nome_arquivo like ? ";
                limpaTabela();
                try {
                    con = DAO.conectar();
                    pst = con.prepareStatement(readNome);
                    pst.setString(1, "%" + caixaTxtNome.getText() + "%");
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        String id = rs.getString("id");
                        String nome_arquivo = rs.getString("nome_arquivo");
                        String data_cadastro = rs.getString("data_cadastro");
                        DefaultTableModel jtableResultado = (DefaultTableModel) jTableResult.getModel();
                        Object[] dados = {id, nome_arquivo, data_cadastro};
                        jtableResultado.addRow(dados);
                    }
                    con.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Imagem não cadastrada! Não foi possível obter o nome da imagem!");
                    System.out.println(e);
                }
            }
            if (caixaTxtId.getText().isEmpty() && caixaTxtNome.getText().isEmpty()) {
                String readData = "select id, nome_arquivo, data_cadastro from iup_picture where data_cadastro like ? ";
                limpaTabela();
                try {
                    con = DAO.conectar();
                    pst = con.prepareStatement(readData);
                    pst.setString(1, "%" + txtcaixaData.getText() + "%");
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        String id = rs.getString("id");
                        String nome_arquivo = rs.getString("nome_arquivo");
                        String data_cadastro = rs.getString("data_cadastro");
                        DefaultTableModel jtableResultado = (DefaultTableModel) jTableResult.getModel();
                        Object[] dados = {id, nome_arquivo, data_cadastro};
                        jtableResultado.addRow(dados);
                    }
                    con.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Imagem não cadastrada! Não foi possível obter a data da imagem!");
                    System.out.println(e);
                }
            }
        }
        desativaBotao();
    }
    
    private void limpaTabela() {
        DefaultTableModel jtableResultado = (DefaultTableModel) jTableResult.getModel();
        jtableResultado.setRowCount(0);
    }
    
    private void resetar(){
        caixaTxtId.setText("");
        caixaTxtNome.setText("");
        txtcaixaData.setText("");
        lblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgProjeto/imgTelaEditar/fotoTelaEdit.png")));
        fis = null;
        
    }
    
    private void InserirIcone(JFrame frm) {
        try {
            frm.setIconImage(Toolkit.getDefaultToolkit().getImage("src/imgProjeto/imgTelaPrin/iconetelaprin.png"));
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
    
    private void MostraImg(){
        ativaBotao();
        int linhaSelecionada = jTableResult.getSelectedRow();
        String id = jTableResult.getValueAt(linhaSelecionada, 0).toString();
        String nome = jTableResult.getValueAt(linhaSelecionada, 1).toString();
        String dataCadastro = jTableResult.getValueAt(linhaSelecionada, 2).toString();
        String readImg = "select imagem from iup_picture where id = ?";
        try {
            con = DAO.conectar();
            pst = con.prepareStatement(readImg);
            pst.setInt(1, Integer.parseInt(id));
            rs = pst.executeQuery();
            if (rs.next()) {
                Blob blob = (Blob) rs.getBlob("imagem");
                byte[] img = blob.getBytes(1, (int) blob.length());
                BufferedImage Imagem = null;
                try {
                    Imagem = ImageIO.read(new ByteArrayInputStream(img));
                } catch (Exception e) {
                    System.out.println(e);
                }
                ImageIcon icone = new ImageIcon(Imagem);
                Icon foto = new ImageIcon(icone.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH));
                lblFoto.setIcon(foto);
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível carragar a imagem");
            }
            con.close();
        } catch (Exception e) {
        }
        
        caixaTxtId.setText(id);
        caixaTxtNome.setText(nome);
        txtcaixaData.setText(dataCadastro);
    }
    
    private void desativaBotao(){
    bEditar.setEnabled(false);
    bExcluir.setEnabled(false);
    bSalvarAlteracao.setEnabled(false);
    }
    
    private void ativaBotao(){
    bEditar.setEnabled(true);
    bExcluir.setEnabled(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LtitEditar;
    private javax.swing.JButton bEditar;
    private javax.swing.JButton bExcluir;
    private javax.swing.JButton bPesquisar;
    private javax.swing.JButton bSalvarAlteracao;
    private javax.swing.JButton bVoltar;
    private javax.swing.JTextField caixaTxtId;
    private javax.swing.JTextField caixaTxtNome;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTableResult;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNome;
    private javax.swing.JPanel painelPrin;
    private javax.swing.JFormattedTextField txtcaixaData;
    // End of variables declaration//GEN-END:variables
}
