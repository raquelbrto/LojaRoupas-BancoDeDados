import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*Funcionário consultar quantidade de vendas mensais e total ganho nesse periodo: ex.mes de julho*/
public class RelatorioMensalVendas {
private static final  String RELATORIO = "SELECT COUNT(v.idVenda) as Vendas_Realizadas, SUM(v.valorTotal) as Total FROM Venda as v WHERE  v.dataVenda BETWEEN  '2021-07-01' AND '2021-07-31'";
	
	public static void main(String[] args) throws SQLException {
		
		ConexaoMysql criarConexao = new ConexaoMysql();
		Connection connection = criarConexao.recupertarConexao();
	    
		Statement stm = connection.createStatement();
		stm.execute(RELATORIO);
		
	    ResultSet rst = stm.getResultSet();
		
	    while(rst.next()) {
			String vendas_realizadas = rst.getString("Vendas_Realizadas");
			System.out.println("Vendas realizadas: "+ vendas_realizadas);
			Integer total = rst.getInt("Total");
			System.out.println("Total: "+ total);
			System.out.println("________________________________");
		}
		connection.close();
	}
}
