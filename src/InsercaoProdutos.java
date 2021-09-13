import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*Exemplo de insert na tabela produto*/
public class InsercaoProdutos {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		ConexaoMysql criarConexao = new ConexaoMysql();
		Connection connection = criarConexao.recupertarConexao();
	    
		Statement stm = connection.createStatement();
		stm.execute("insert into Produto(nomeProduto, descricao, preco) values ('Camisa MINAS club 2019','Camisa volei minas clube original, tamanho M',59.99),('Camisa praia club 2019','Camisa volei praia clube original, tamanho M',59.99),('Camisa volei osasco 2019','Camisa volei osasco original, tamanho G',59.99),('Camisa volei flamengo 2019','Camisa volei flamengo original, tamanho PP',79.99),('Camisa volei brasil vnl 2021','Camisa volei brasil vnl original, tamanho P',89.99)", Statement.RETURN_GENERATED_KEYS);
		
		ResultSet rst = stm.getGeneratedKeys();
		
		while(rst.next()) {
			Integer id_produto = rst.getInt(1);
			System.out.println("O id criado foi "+id_produto);
		
		}
		
		connection.close();
	}

}
