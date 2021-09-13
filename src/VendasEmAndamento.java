import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*Cliente Listar vendas em andamento dependendo do id do cliente*/
public class VendasEmAndamento {
private static final  String LIST = "select p.nomeProduto, v.valorTotal as Total from Venda v inner  join Produto p on v.idProduto = p.idProduto inner join Cliente c on v.idCliente=c.idCliente where v.situacao = 'Em andamento' AND c.idCliente =2";
	
	public static void main(String[] args) throws SQLException {
		
		ConexaoMysql criarConexao = new ConexaoMysql();
		Connection connection = criarConexao.recupertarConexao();
	    
		Statement stm = connection.createStatement();
		stm.execute(LIST);
		
	    ResultSet rst = stm.getResultSet();
		
	    while(rst.next()) {
			String nome = rst.getString("nomeProduto");
			System.out.println("Produto: "+nome);
			Integer total = rst.getInt("Total");
			System.out.println("Total: "+ total);
			System.out.println("________________________________");
		}
		connection.close();
	}
}

