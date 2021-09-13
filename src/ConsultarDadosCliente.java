import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*Cliente consultar todos os seus dados pessoais*/
public class ConsultarDadosCliente {
private static final  String LIST = "select c.nomeCliente as Nome, c.email as Email, e.rua as Rua, e.numero as N ,e.bairro as Bairro, e.cidade as Cidade ,e.cep as Cep from Cliente c inner  join Endereco e on c.idEnderecoFK = e.idEndereco where idCliente= 2;";
	
	public static void main(String[] args) throws SQLException {
		
		ConexaoMysql criarConexao = new ConexaoMysql();
		Connection connection = criarConexao.recupertarConexao();
	    
		Statement stm = connection.createStatement();
		stm.execute(LIST);
		
	    ResultSet rst = stm.getResultSet();
		
	    while(rst.next()) {
			String nome = rst.getString("Nome");
			System.out.println("Nome: "+nome);
			String email = rst.getString("Email");
			System.out.println("Email: "+ email);
			String rua = rst.getString("Rua");
			System.out.println("Rua: "+rua);
			Integer numero = rst.getInt("N");
			System.out.println("Numero: "+numero);
			String bairro = rst.getString("Bairro");
			System.out.println("Bairro: "+bairro);
			String cidade = rst.getString("Cidade");
			System.out.println("Nome: "+cidade);
			System.out.println("________________________________");
		}
		connection.close();
	}
}
