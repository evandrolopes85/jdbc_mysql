import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Datasource{
	private String host;
	private String port;
	private String banco;
	private String user;
	private String password;
	private Connection connection;

	public Datasource(){

		try{

			//String[] dados  = new Dados().getDados();
			Dados dados  = new RecuperaDados().getDados();
			host     = dados.getHost();
			port     = dados.getPort();
			banco 	 = dados.getDb();
			user  	 = dados.getUser();
			password = dados.getPassword();

			/*host     = dados[0];
			port     = dados[1];
			banco 	 = dados[2];
			user  	 = dados[3];
			password = dados[4];*/


			String url = "jdbc:mysql://" + host + "/" + banco;

			connection = DriverManager.getConnection(url,user, password);

			System.out.println("Conexao Realizada!!");

		}catch(SQLException e){
			System.err.println("Erro de conexao!");
		}
	}

	public Connection getConnection(){
		return this.connection;
	}]
}