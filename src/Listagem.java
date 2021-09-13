import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*Exemplo listagem de produtos*/
public class Listagem {
	private static final  String SELECTP = "SELECT IDPRODUTO, NOMEPRODUTO, PRECO, DESCRICAO FROM PRODUTO";
	
	public static void main(String[] args) throws SQLException {
		
		ConexaoMysql criarConexao = new ConexaoMysql();
		Connection connection = criarConexao.recupertarConexao();
	    
		Statement stm = connection.createStatement();
		stm.execute(SELECTP);
		
	    ResultSet rst = stm.getResultSet();
		
		while(rst.next()) {
			Integer id_produto = rst.getInt("IDPRODUTO");
			System.out.println("id " + id_produto);
			String nome = rst.getString("NOMEPRODUTO");
			System.out.println("Nome "+nome);
			String descricao = rst.getString("DESCRICAO");
			System.out.println(descricao);
			Float preco = rst.getFloat("PRECO");
			System.out.println("Preço "+ preco);
			System.out.println("________________________________");
		}
		connection.close();
	}
}
