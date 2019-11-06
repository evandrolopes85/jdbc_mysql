import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;

public class UsuarioDao implements GenericDao{
	private Connection connection;

	public UsuarioDao(){
		connection = new Datasource().getConnection();
	}
	
	public void create(Object o){
		Usuario usuario = (Usuario)o;

		String sql = "insert into contatos (nome, email, endereco, dataNascimento) values (?,?,?,?)";
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getEndereco());
			stmt.setDate(4, java.sql.Date.valueOf(usuario.getDataNascimento()));
			stmt.execute();

			System.out.println("Usuario cadastrado!");
			stmt.close();
		}catch(SQLException e){
			System.err.println("Erro ao cadastrar!" + e.getMessage());
		}
	}

	public Object read(Object o){
		Usuario incompleto = (Usuario) o;
		try{
			String sql = "select * from contatos where nome=? or email=?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, incompleto.getNome());
			stmt.setString(2, incompleto.getEmail());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				incompleto.setId(rs.getInt("id"));
				incompleto.setNome(rs.getString("nome"));
				incompleto.setEmail(rs.getString("email"));
				incompleto.setEndereco(rs.getString("endereco"));
				incompleto.setDataNascimento(rs.getDate("dataNascimento").toLocalDate());
			}

			stmt.close();
			rs.close();
		}catch(SQLException e){
			System.err.println("Erro ao recuperar dados " + e.getMessage());
		}
		return incompleto;
	}

	public void update(Object o){
		Usuario incompleto = (Usuario) o;
		try{
			String sql = "update contatos set email=? where nome=?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, incompleto.getEmail());
			stmt.setString(2, incompleto.getNome());

			stmt.execute();

			stmt.close();
		}catch(SQLException e){
			System.err.println("Erro ao recuperar dados " + e.getMessage());
		}
	}
	
	public void delete(Object o){
		Usuario incompleto = (Usuario) o;
		try{
			String sql = "delete from contatos where nome=?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, incompleto.getNome());

			stmt.execute();

			stmt.close();
		}catch(SQLException e){
			System.err.println("Erro ao recuperar dados " + e.getMessage());
		}
	}
}