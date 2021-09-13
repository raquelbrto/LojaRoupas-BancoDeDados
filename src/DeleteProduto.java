import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*Deletar produto*/
public class DeleteProduto {

private static final  String DELETE = "DELETE FROM PRODUTO WHERE IDPRODUTO= 4";
	
	public static void main(String[] args) throws SQLException {
		
		ConexaoMysql criarConexao = new ConexaoMysql();
		Connection connection = criarConexao.recupertarConexao();
	    
		Statement stm = connection.createStatement();
		stm.execute(DELETE);
		
	  System.out.println("Produto deletado.");
		connection.close();
	}

}
