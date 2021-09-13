import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*Funcionário listar produtos e quantidade disponível no estoque:*/
public class ListarProdutosEquantidade {
	private static final  String LIST = "select p.nomeProduto as Nome , p.descricao as Descricao, e.quantidade as Estoque from Estoque e inner  join Produto p on p.idProduto = e.idProdutoFK group by nomeProduto";
	
	public static void main(String[] args) throws SQLException {
		
		ConexaoMysql criarConexao = new ConexaoMysql();
		Connection connection = criarConexao.recupertarConexao();
	    
		Statement stm = connection.createStatement();
		stm.execute(LIST);
		
	    ResultSet rst = stm.getResultSet();
		
	    while(rst.next()) {
			String nome = rst.getString("Nome");
			System.out.println("Nome: "+nome);
			String descricao = rst.getString("DESCRICAO");
			System.out.println("Descricao: " + descricao);
			Integer estoque = rst.getInt("Estoque");
			System.out.println("Estoque: "+ estoque);
			System.out.println("________________________________");
		}
		connection.close();
	}
}


