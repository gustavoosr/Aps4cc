/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telaprin;

import connection.DAO;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import  threads.*;

/**
 *
 * @author gusta
 */

public class TelaOrdenar extends javax.swing.JFrame {
    DAO dao = new DAO();
    private PreparedStatement pst;
    private Connection con;
    private FileInputStream fis;
    private ResultSet rs;
    private List<Imagem> img;
    public boolean Cronometropausado= true;
    private static int minutoAtual, segundoAtual, milessimoAtual;
    Thread tMil, tSeg, tMin;
    
    public TelaOrdenar() {
        initComponents();
        InserirIcone(this);
        
    }
    public void InserirIcone (JFrame frm){
        try{
            frm.setIconImage(Toolkit.getDefaultToolkit().getImage("src/imgProjeto/imgTelaPrin/iconetelaprin.png"));
        }catch(Exception ex){
            System.out.println(ex.toString());         
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        painelPrin = new javax.swing.JPanel();
        bOrdemQuicksort = new javax.swing.JButton();
        bOrdemMergesort = new javax.swing.JButton();
        bOrdemHeapsort = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaResultado = new javax.swing.JTable();
        lblFoto = new javax.swing.JLabel();
        bVoltar = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ordenar Imagem");
        setBackground(new java.awt.Color(204, 204, 204));
        setLocation(new java.awt.Point(400, 85));
        setPreferredSize(new java.awt.Dimension(648, 600));
        setResizable(false);

        lblTitulo.setBackground(new java.awt.Color(204, 204, 204));
        lblTitulo.setFont(new java.awt.Font("DejaVu Math TeX Gyre", 2, 14)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgProjeto/imgTelaOrdenar/pesquisa-de-imagens.png"))); // NOI18N
        lblTitulo.setText("Ordenar Imagem");
        lblTitulo.setOpaque(true);

        painelPrin.setBackground(new java.awt.Color(102, 102, 102));

        bOrdemQuicksort.setBackground(new java.awt.Color(153, 153, 153));
        bOrdemQuicksort.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        bOrdemQuicksort.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgProjeto/imgTelaOrdenar/estrutura-hierarquica (2).png"))); // NOI18N
        bOrdemQuicksort.setToolTipText("O algoritmo quicksort é um método de ordenação muito rápido e eficiente. Recomendado para grande volume de dados");
        bOrdemQuicksort.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Quicksort", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("DejaVu Sans Condensed", 3, 14))); // NOI18N
        bOrdemQuicksort.setFocusable(false);
        bOrdemQuicksort.setRequestFocusEnabled(false);
        bOrdemQuicksort.setRolloverEnabled(false);
        bOrdemQuicksort.setVerifyInputWhenFocusTarget(false);
        bOrdemQuicksort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOrdemQuicksortActionPerformed(evt);
            }
        });

        bOrdemMergesort.setBackground(new java.awt.Color(153, 153, 153));
        bOrdemMergesort.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgProjeto/imgTelaOrdenar/estrutura-hierarquica (2).png"))); // NOI18N
        bOrdemMergesort.setToolTipText("Merge Sort é um algoritmo eficiente de ordenação por divisão e conquista.");
        bOrdemMergesort.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Mergesort ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("DejaVu Sans Condensed", 3, 14))); // NOI18N
        bOrdemMergesort.setFocusPainted(false);
        bOrdemMergesort.setRequestFocusEnabled(false);
        bOrdemMergesort.setRolloverEnabled(false);
        bOrdemMergesort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOrdemMergesortActionPerformed(evt);
            }
        });

        bOrdemHeapsort.setBackground(new java.awt.Color(153, 153, 153));
        bOrdemHeapsort.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgProjeto/imgTelaOrdenar/estrutura-hierarquica (2).png"))); // NOI18N
        bOrdemHeapsort.setToolTipText("Heapsort é um método de ordenação cujo princípio de funcionamento é o mesmo utilizado para a ordenação por seleção.");
        bOrdemHeapsort.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Heapsort", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("DejaVu Sans Condensed", 3, 14))); // NOI18N
        bOrdemHeapsort.setFocusPainted(false);
        bOrdemHeapsort.setRequestFocusEnabled(false);
        bOrdemHeapsort.setRolloverEnabled(false);
        bOrdemHeapsort.setVerifyInputWhenFocusTarget(false);
        bOrdemHeapsort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOrdemHeapsortActionPerformed(evt);
            }
        });

        tabelaResultado.setBackground(new java.awt.Color(153, 153, 153));
        tabelaResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ordem", "Nome Arquivo", "Data Cadastro", "ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaResultado.setToolTipText("Resultado");
        tabelaResultado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaResultadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaResultado);

        lblFoto.setBackground(new java.awt.Color(102, 102, 102));
        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgProjeto/imgTelaEditar/fotoTelaEdit.png"))); // NOI18N
        lblFoto.setToolTipText("Imagem");
        lblFoto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblFoto.setOpaque(true);

        javax.swing.GroupLayout painelPrinLayout = new javax.swing.GroupLayout(painelPrin);
        painelPrin.setLayout(painelPrinLayout);
        painelPrinLayout.setHorizontalGroup(
            painelPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPrinLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(185, 185, 185))
            .addGroup(painelPrinLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(painelPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(painelPrinLayout.createSequentialGroup()
                        .addComponent(bOrdemQuicksort, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(bOrdemHeapsort, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(bOrdemMergesort, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        painelPrinLayout.setVerticalGroup(
            painelPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPrinLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painelPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bOrdemMergesort, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bOrdemHeapsort, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bOrdemQuicksort, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        bVoltar.setBackground(new java.awt.Color(153, 153, 153));
        bVoltar.setFont(new java.awt.Font("DejaVu Sans Condensed", 3, 14)); // NOI18N
        bVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgProjeto/imgTelaEditar/voltar.png"))); // NOI18N
        bVoltar.setToolTipText("Voltar");
        bVoltar.setFocusPainted(false);
        bVoltar.setFocusable(false);
        bVoltar.setRequestFocusEnabled(false);
        bVoltar.setRolloverEnabled(false);
        bVoltar.setVerifyInputWhenFocusTarget(false);
        bVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(painelPrin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bVoltar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bVoltar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelPrin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVoltarActionPerformed
        TelaMenu telaMenu = new TelaMenu();
        telaMenu.setVisible(true);
        dispose();
    }//GEN-LAST:event_bVoltarActionPerformed

    private void bOrdemQuicksortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOrdemQuicksortActionPerformed
        loadImg();
        QuickSortThread quickSortThread = new QuickSortThread(img, 0, img.size() -1);
        quickSortThread.start();
        iniciarCronometro();
        try {
            quickSortThread.join();
            DefaultTableModel jTableResultado = (DefaultTableModel) tabelaResultado.getModel();
            jTableResultado.setRowCount(0);
            
            for(Imagem img : quickSortThread.getSortedPhotos()){
               jTableResultado.addRow(new Object[]{img.getOrdem(), img.getNome(), img.getData(), img.getid()});
            }
            encerrarCronometro();
            String tempProcessamento = String.format("%02d:%02d:%03d", minutoAtual, segundoAtual, milessimoAtual);
            JOptionPane.showMessageDialog(null, "Tempo de processamento do algoritmo QuickSort: "+ tempProcessamento);
            JOptionPane.showMessageDialog(null, "Para realizar uma nova consulta, reinicie a aplicação!");
            bOrdemHeapsort.setEnabled(false);
            bOrdemMergesort.setEnabled(false);
            bOrdemQuicksort.setEnabled(false);

       } catch (Exception e) {
            System.out.println(e);
        }
         ZerarCronometro();
         img.clear();
    }//GEN-LAST:event_bOrdemQuicksortActionPerformed

    private void bOrdemHeapsortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOrdemHeapsortActionPerformed
        loadImg();
        HeapSortThread heapSortThread = new HeapSortThread(img);
        heapSortThread.start();
        iniciarCronometro();
        try {
            heapSortThread.join();
            
            DefaultTableModel jTableResultado = (DefaultTableModel) tabelaResultado.getModel();
            jTableResultado.setRowCount(0);
            for(Imagem img : heapSortThread.getSortedPhotos()){
                   jTableResultado.addRow(new Object[]{img.getOrdem(), img.getNome(), img.getData(), img.getid()});
            }
            encerrarCronometro();
            String tempProcessamento = String.format("%02d:%02d:%03d", minutoAtual, segundoAtual, milessimoAtual);
            JOptionPane.showMessageDialog(null, "Tempo de processamento do Algoritmo HeapSort: "+ tempProcessamento);
            JOptionPane.showMessageDialog(null, "Para realizar uma nova consulta, reinicie a aplicação!");
            bOrdemHeapsort.setEnabled(false);
            bOrdemMergesort.setEnabled(false);
            bOrdemQuicksort.setEnabled(false);
            
        } catch (Exception e) {
                System.out.println(e);
        }
        ZerarCronometro();
         img.clear();
    }//GEN-LAST:event_bOrdemHeapsortActionPerformed

    private void bOrdemMergesortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOrdemMergesortActionPerformed
        
        loadImg();
        MergeThread mergeThread = new MergeThread(img);
        mergeThread.start();
        iniciarCronometro();
        try {
            mergeThread.join();
            DefaultTableModel jTableResultado = (DefaultTableModel) tabelaResultado.getModel();
            jTableResultado.setRowCount(0);
            for (Imagem img : mergeThread.getSortedPhotos()){
                jTableResultado.addRow(new Object[]{img.getOrdem(), img.getNome(), img.getData(), img.getid()});
            }
            encerrarCronometro();
            String tempProcessamento = String.format("%02d:%02d:%03d", minutoAtual, segundoAtual, milessimoAtual);
            JOptionPane.showMessageDialog(null, "Tempo de processamento do Algoritmo MergeSort: "+ tempProcessamento);
            JOptionPane.showMessageDialog(null, "Para realizar uma nova consulta, reinicie a aplicação!");
            bOrdemHeapsort.setEnabled(false);
            bOrdemMergesort.setEnabled(false);
            bOrdemQuicksort.setEnabled(false);
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        ZerarCronometro();
         img.clear();
    }//GEN-LAST:event_bOrdemMergesortActionPerformed

    private void tabelaResultadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaResultadoMouseClicked
        if (tabelaResultado.getSelectedRow() != -1) {
            MostrarImg();
        }
                
    }//GEN-LAST:event_tabelaResultadoMouseClicked
    
    public void iniciarCronometro(){
    tMil = new Thread(new Milesimo(this));
    tSeg = new Thread(new Segundo(this));
    tMin = new Thread(new Minuto(this));
    
    tMil.start();
    tSeg.start();
    tMin.start();
    }
    
    private void encerrarCronometro(){
        Milesimo.pausar();
        Segundo.pausar();
        Minuto.pausar();   
    }
    
    
    private void ZerarCronometro(){
        Milesimo.pausar();
        Segundo.pausar();
        Minuto.pausar();
        
        setMinuto(0);
        setMilessimo(0);
        setSegundo(0);
        
    }
    public static  void setMinuto(int minuto) {
        TelaOrdenar.minutoAtual = minuto;
    }

    public static void setSegundo(int segundo) {
        TelaOrdenar.segundoAtual = segundo;
    }

    public static void setMilessimo(int milessimo) {
        TelaOrdenar.milessimoAtual = milessimo;
    }
    
    private void loadImg(){
     String readImg = "select ordenar,id,nome_arquivo,data_cadastro from iup_picture";
        try {
            con = DAO.conectar();
            pst = con.prepareStatement(readImg);
            rs = pst.executeQuery();
            
            img = new ArrayList<>();
            while(rs.next()){
            int id = rs.getInt("id");
            int ordem = rs.getInt("ordenar");
            String nome = rs.getString("nome_arquivo");
            String data = rs.getString("data_cadastro");
            
            img.add( new Imagem(ordem,id,nome,data));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }    
    
   private  void MostrarImg(){
       int linhaselecionada = tabelaResultado.getSelectedRow();
       String id = tabelaResultado.getValueAt(linhaselecionada, 3).toString();
       String readImg = "select imagem from iup_picture where id = ?";
       try {
           con = DAO.conectar();
           pst = con.prepareStatement(readImg);
           pst.setInt(1,Integer.parseInt(id));
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
       
   }
   
    private void resetar(){
        lblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgProjeto/imgTelaEditar/fotoTelaEdit.png")));
        fis = null;
        
    }
    
    private void limpaTabela() {
        resetar();
        DefaultTableModel jtableResultado = (DefaultTableModel) tabelaResultado.getModel();
        jtableResultado.setRowCount(0);
    }
    
    public class Imagem{
        
        private final int ordenar;
        private final int id;
        private final String nomeFile;
        private final String data;
 
        public Imagem(int ordenar,int id, String nome, String data){
            this.ordenar = ordenar;
            this.id = id;
            this.nomeFile = nome;
            this.data = data;
        }
         public int getOrdem() {
            return ordenar;
        }
         public int getid(){
             return id;
         }
         public String getNome(){
             return nomeFile;
         }
         public String getData(){
         return data;
         }

        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bOrdemHeapsort;
    private javax.swing.JButton bOrdemMergesort;
    private javax.swing.JButton bOrdemQuicksort;
    private javax.swing.JButton bVoltar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel painelPrin;
    private javax.swing.JTable tabelaResultado;
    // End of variables declaration//GEN-END:variables
}
