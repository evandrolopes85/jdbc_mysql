import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;

public class UsuarioDao implements GenericDao{
	private Connection connection;

	public UsuarioDao(Datasource datasource){
		connection = datasource.getConnection();
	}
	
	public void create(Object o){

		if(o instanceof Usuario){
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
		}else{
			throw new RuntimeException("Invalid Object");
		}
		
	}

	public Object read(Object o){
		if(o instanceof Usuario){
			Usuario incompleto = (Usuario) o;
			try{
				String sql = "select * from contatos where nome=? or email=?";
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, incompleto.getNome());
				stmt.setString(2, incompleto.getEmail());
				ResultSet rs = stmt.executeQuery();
			
				Usuario usuario = new Usuario();

				while(rs.next()){
					usuario.setId(rs.getInt("id"));
					usuario.setNome(rs.getString("nome"));
					usuario.setEmail(rs.getString("email"));
					usuario.setEndereco(rs.getString("endereco"));
					usuario.setDataNascimento(rs.getDate("dataNascimento").toLocalDate());
				}

				stmt.close();
				rs.close();
				return usuario; 
			}catch(SQLException e){
				System.err.println("Erro ao recuperar dados " + e.getMessage());
			}

		}else{
			throw new RuntimeException("Invalid Object");
		}

		return null;
	}

	public void update(Object o){
		Usuario incompleto = (Usuario) o;
		try{
			String sql = "update contatos set email=? where nome=?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, incompleto.getEmail());
			stmt.setString(2, incompleto.getNome());

			stmt.executeUpdate();

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