import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/*Listar numero de pedidos por cliente:*/
public class ListaPedidosPCliente {

	private static final  String LIST = "Select c.nomeCliente as Nome, COUNT(v.idVenda) as Compras From Cliente as c, Venda as v Where c.idCliente=v.idCliente Group By c.nomeCliente";
	
	public static void main(String[] args) throws SQLException {
		
		ConexaoMysql criarConexao = new ConexaoMysql();
		Connection connection = criarConexao.recupertarConexao();
	    
		Statement stm = connection.createStatement();
		stm.execute(LIST);
		
	    ResultSet rst = stm.getResultSet();
		
	    while(rst.next()) {
			String nome = rst.getString("Nome");
			System.out.println("Nome: "+nome);
			Integer compras = rst.getInt("Compras");
			System.out.println("Compras: "+ compras);
			System.out.println("________________________________");
		}
		connection.close();
	}

}
