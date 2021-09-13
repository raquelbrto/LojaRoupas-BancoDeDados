import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*Exemplo update na tabela estoque adicionando ao produto*/
public class UpdateEstoque {
	private static final  String UPDATE = "UPDATE ESTOQUE SET QUANTIDADE = QUANTIDADE + 50 WHERE IDPRODUTOFK = 1;";
	
	public static void main(String[] args) throws SQLException {
		
		ConexaoMysql criarConexao = new ConexaoMysql();
		Connection connection = criarConexao.recupertarConexao();
	    
		Statement stm = connection.createStatement();
		stm.execute(UPDATE);
		
	    //ResultSet rst = stm.getResultSet();
		System.out.println("Quantidade atulizada.");
		
		connection.close();
	}
}


