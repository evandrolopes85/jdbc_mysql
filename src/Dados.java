import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Serializable;

public class Dados implements Serializable{
	private String host;
	private String port;
	private String db;
	private String user;
	private String password;

	public Dados(){

	}

	public Dados(String host, String port, String db, String user, String password){
		this.host     = host;
		this.port     = port;
		this.db       = db;
		this.user 	  = user;
		this.password = password;
	}


	public String getHost(){
		return this.host;
	}

	public void setHost(String host){
		this.host = host;
	}

	public String getPort(){
		return this.port;
	}

	public void setPort(String port){
		this.port = port;
	}

	public String getDb(){
		return this.db;
	}

	public void setDb(String db){
		this.db = db;
	}

	public String getUser(){
		return this.user;
	}

	public void setUser(String user){
		this.user = user;
	}

	public String getPassword(){
		return this.password;
	}

	public void setPassword(String password){
		this.password = password;
	}
	/*private String[] dados;

	public Dados(){
		try{
			BufferedReader br = new BufferedReader(new FileReader(new File("dados.txt")));
			this.dados =	br.readLine().split(",");	
		}catch(Exception e){
			System.out.println("Erro ao recuperar dados!" + e.getMessage());
		}
		
	}

	public String[] getDados(){
		return this.dados;
	}*/
} 