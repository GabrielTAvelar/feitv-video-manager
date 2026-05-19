package com.mycompany.projecttv.view;

import com.mycompany.projecttv.controller.PlaylistController;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PlaylistScreen extends javax.swing.JFrame {
    
    public PlaylistScreen() {
        initComponents();
        atualizarListaNaTela();
    }
    
    private void atualizarListaNaTela(){
        controller.atualizarLista();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaStatus = new javax.swing.JTextArea();
        txtNomeLista = new javax.swing.JTextField();
        txtNomeVideo = new javax.swing.JTextField();
        btnCriarPlaylist = new javax.swing.JButton();
        btnApagarPlaylist = new javax.swing.JButton();
        btnAdicionarVideo = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        btnRemoverVideo = new javax.swing.JButton();
        btnMostrarTudo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtAreaStatus.setColumns(20);
        txtAreaStatus.setRows(5);
        jScrollPane1.setViewportView(txtAreaStatus);

        txtNomeVideo.addActionListener(this::txtNomeVideoActionPerformed);

        btnCriarPlaylist.setText("Criar Playlist");
        btnCriarPlaylist.addActionListener(this::btnCriarPlaylistActionPerformed);

        btnApagarPlaylist.setText("Apagar Playlist");
        btnApagarPlaylist.addActionListener(this::btnApagarPlaylistActionPerformed);

        btnAdicionarVideo.setText("Adicionar vídeo");
        btnAdicionarVideo.addActionListener(this::btnAdicionarVideoActionPerformed);

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(this::btnVoltarActionPerformed);

        btnRemoverVideo.setText("Remover vídeo");
        btnRemoverVideo.addActionListener(this::btnRemoverVideoActionPerformed);

        btnMostrarTudo.setText("Mostrar todas as playlists criadas");
        btnMostrarTudo.addActionListener(this::btnMostrarTudoActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNomeLista)
                            .addComponent(txtNomeVideo, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnVoltar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCriarPlaylist, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAdicionarVideo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnApagarPlaylist, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRemoverVideo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnMostrarTudo)
                        .addGap(83, 83, 83))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnVoltar)
                        .addGap(96, 96, 96)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(btnApagarPlaylist)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCriarPlaylist))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(txtNomeLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(btnAdicionarVideo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRemoverVideo))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(txtNomeVideo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnMostrarTudo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 29, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();        
    // ----------- botão para retornar a área de videos
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnCriarPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarPlaylistActionPerformed
        controller.criarPlaylist();
        // --------------- botao de criar playlist     
    }//GEN-LAST:event_btnCriarPlaylistActionPerformed

    private void btnApagarPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarPlaylistActionPerformed
        controller.apagarPlaylist();
       // -------------------- botão de apagar playlist
    }//GEN-LAST:event_btnApagarPlaylistActionPerformed

    private void btnAdicionarVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarVideoActionPerformed
        controller.adicionarVideo();
        //------------ Botão de Adicionar vídeos na playlist
    }//GEN-LAST:event_btnAdicionarVideoActionPerformed

    private void btnRemoverVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverVideoActionPerformed
        controller.removerVideo();
        // ------------------ Botão de remover video
    }//GEN-LAST:event_btnRemoverVideoActionPerformed

    private void txtNomeVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeVideoActionPerformed
        
    }//GEN-LAST:event_txtNomeVideoActionPerformed

    private void btnMostrarTudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTudoActionPerformed
        controller.mostrarPlaylist();
        //------------ Botão que mostra todas as playlists
    }//GEN-LAST:event_btnMostrarTudoActionPerformed

    public static void main(String args[]) {


        java.awt.EventQueue.invokeLater(() -> new PlaylistScreen().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarVideo;
    private javax.swing.JButton btnApagarPlaylist;
    private javax.swing.JButton btnCriarPlaylist;
    private javax.swing.JButton btnMostrarTudo;
    private javax.swing.JButton btnRemoverVideo;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAreaStatus;
    private javax.swing.JTextField txtNomeLista;
    private javax.swing.JTextField txtNomeVideo;
    // End of variables declaration//GEN-END:variables
    private PlaylistController controller = new PlaylistController(this);

    public JTextArea getTxtAreaStatus() {
        return txtAreaStatus;
    }

    public JTextField getTxtNomeLista() {
        return txtNomeLista;
    }

    public JTextField getTxtNomeVideo() {
        return txtNomeVideo;
    }
    
    
}