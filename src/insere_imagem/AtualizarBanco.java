/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package insere_imagem;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author gusta
 */
public class AtualizarBanco {
     public static void atualizarNomes(String arquivoTexto) {
        // Conexão com o banco de dados
        String url = "jdbc:mysql://localhost:3306/aps_4cc";
        String usuario = "root";
        String senha = "sucodeuva12";
        
        try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {
            // Lendo o arquivo de texto
            BufferedReader reader = new BufferedReader(new FileReader(arquivoTexto));
            String nome;

            // Preparar o comando SQL para atualizar
            String sql = "UPDATE iup_picture SET nome_arquivo = ? WHERE id = ?";  // Adapte o campo e a condição conforme seu caso
            PreparedStatement stmt = conexao.prepareStatement(sql);

            int id = 1; // Ajuste de acordo com sua lógica de busca ou identificação no banco
            
            // Ler os nomes do arquivo
            while ((nome = reader.readLine()) != null) {
                // Definir os parâmetros do SQL
                stmt.setString(1, nome);  // Atualiza o campo com o nome lido
                stmt.setInt(2, id);       // Usa o ID ou outra condição para identificar a linha
                
                // Executa a atualização
                stmt.executeUpdate();
                id++; // Incrementa o ID ou ajuste para o critério de atualização necessário
            }
            reader.close();
            System.out.println("Atualização concluída.");
            
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Chame o método e passe o caminho do arquivo de texto
        atualizarNomes("C:\\Users\\gusta\\OneDrive\\Documentos\\geolocalizacao_cerrado_completo.txt");

    }
}
