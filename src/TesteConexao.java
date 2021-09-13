import java.sql.Connection;

import java.sql.SQLException;

/*Classe para testar se a conexão esta ocorrendo sem erros*/
public class TesteConexao {
	
	public static void main(String[] args) throws SQLException {
	ConexaoMysql criarConexao = new ConexaoMysql();
	Connection   connection =    criarConexao.recupertarConexao();
	
	System.out.println("Conexao aberta");
	
	connection.close();
	
	System.out.println("Conexao fechada");
	}
}
