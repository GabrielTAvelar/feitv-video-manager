package com.mycompany.projecttv.view;

public class MainScreen extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainScreen.class.getName());

    /**
     * Creates new form MainScreen
     */
    public MainScreen() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtBusca = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaVideos = new javax.swing.JTextArea();
        btnCurtir = new javax.swing.JButton();
        txtVideoSelecionado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnMenuPlaylists = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        txtAreaVideos.setColumns(20);
        txtAreaVideos.setRows(5);
        jScrollPane1.setViewportView(txtAreaVideos);

        btnCurtir.setText("Like");
        btnCurtir.addActionListener(this::btnCurtirActionPerformed);

        jLabel1.setText("Digite o nome do vídeo para curtir/descurtir:");

        btnMenuPlaylists.setText("Ver playlists");
        btnMenuPlaylists.addActionListener(this::btnMenuPlaylistsActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtBusca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addGap(82, 82, 82))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnMenuPlaylists, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtVideoSelecionado, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(22, 22, 22))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addContainerGap()))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCurtir)
                                .addContainerGap())))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVideoSelecionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCurtir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
                        .addComponent(btnMenuPlaylists, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String termo = txtBusca.getText();
        
        com.mycompany.projecttv.controller.VideoController videoController = new com.mycompany.projecttv.controller.VideoController();
        java.util.List<com.mycompany.projecttv.model.Video> resultados = videoController.buscar(termo);
        
        txtAreaVideos.setText("");
        if (resultados.isEmpty()) {
            txtAreaVideos.setText("Nenhum vídeo encontrado");
        } else {
            for (com.mycompany.projecttv.model.Video v : resultados) {
                txtAreaVideos.append("Título: " + v.getTitulo() + "\n");
            }
        }
     //--------------------------------- Botão de Buscar
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCurtirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCurtirActionPerformed
        String titulo = txtVideoSelecionado.getText();
    
        com.mycompany.projecttv.controller.VideoController vc = new com.mycompany.projecttv.controller.VideoController();
        com.mycompany.projecttv.model.Video videoSelecionado = vc.buscarPorTitulo(titulo);
    
        if (videoSelecionado != null) {
            int usuarioId = com.mycompany.projecttv.model.Sessao.getUsuario().getId();
            int videoId = videoSelecionado.getId();
        
            com.mycompany.projecttv.dao.VotoDAO vDao = new com.mycompany.projecttv.dao.VotoDAO();
        
            vDao.alternarLike(usuarioId, videoId);
        
            int totalLikes = vDao.contarLikes(videoId);
            javax.swing.JOptionPane.showMessageDialog(this, titulo + " agora possui " + totalLikes + " curtida(s)!");
        
        } 
        else {
            javax.swing.JOptionPane.showMessageDialog(this, "Vídeo não encontrado. Verifique o nome digitado.");
        }  
    }//GEN-LAST:event_btnCurtirActionPerformed

    private void btnMenuPlaylistsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuPlaylistsActionPerformed
       PlaylistScreen telaPlaylists = new PlaylistScreen();
       
       telaPlaylists.setVisible(true);
    }//GEN-LAST:event_btnMenuPlaylistsActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new MainScreen().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCurtir;
    private javax.swing.JButton btnMenuPlaylists;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAreaVideos;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JTextField txtVideoSelecionado;
    // End of variables declaration//GEN-END:variables
}
