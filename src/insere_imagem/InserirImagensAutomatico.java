/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package insere_imagem;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author gusta
 */
public class InserirImagensAutomatico {
     private static final String URL = "jdbc:mysql://localhost:3306/aps_4cc";  // Alterar para o seu banco
    private static final String USER = "root";  // Usuário do banco de dados
    private static final String PASSWORD = "sucodeuva12";  // Senha do banco

    // Método que insere a imagem no banco de dados
    public void inserirImagem(File arquivoImagem) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Conexão com o banco de dados
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Query de inserção
            String sql = "INSERT INTO iup_picture (nome_arquivo, imagem) VALUES (?, ?)";

            // Preparando a query
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, arquivoImagem.getName());

            // Lendo o arquivo de imagem
            FileInputStream fis = new FileInputStream(arquivoImagem);
            pstmt.setBinaryStream(2, fis, (int) arquivoImagem.length());

            // Executando a query
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Imagem inserida: " + arquivoImagem.getName() + " - Linhas afetadas: " + rowsAffected);

            // Fechando a entrada de dados da imagem
            fis.close();

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            // Fechar a conexão e o statement
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para percorrer um diretório e inserir todas as imagens no banco
    public void inserirImagensDoDiretorio(String caminhoDiretorio) {
        File diretorio = new File(caminhoDiretorio);

        // Verifica se o caminho é um diretório
        if (diretorio.isDirectory()) {
            // Lista todos os arquivos no diretório
            File[] arquivos = diretorio.listFiles();

            if (arquivos != null) {
                for (File arquivo : arquivos) {
                    // Verifica se é um arquivo de imagem (você pode adaptar para verificar tipos específicos, como .jpg, .png)
                    if (arquivo.isFile() && arquivo.getName().matches(".*\\.(jpg|jpeg|png|gif)$")) {
                        // Insere a imagem no banco de dados
                        inserirImagem(arquivo);
                    }
                }
            }
        } else {
            System.out.println("O caminho fornecido não é um diretório válido.");
        }
    }

    public static void main(String[] args) {
        InserirImagensAutomatico app = new InserirImagensAutomatico();
        
        // Caminho do diretório com as imagens
        String caminhoDiretorio = "C:\\Users\\gusta\\OneDrive\\Documentos\\ImagensCerrado\\imagem2";

        // Iniciar o processo de inserção automática
        app.inserirImagensDoDiretorio(caminhoDiretorio);
    }
}
