import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* Classe que ira criar e abrir a conexao com o banco*/
public class ConexaoMysql {
	
	public Connection recupertarConexao() throws SQLException {
		
		///Connection connection = DriverManager.getConnection(url, user, password);
		return DriverManager.getConnection("jdbc:mysql://localhost/lojaroupas?useTimezone=true&serverTimezone=UTC","root","");

	}
}
