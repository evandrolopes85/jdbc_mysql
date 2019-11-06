import java.time.LocalDate;

public class Usuario{
	private int id;
	private String nome;
	private String email;
	private String endereco;
	private LocalDate dataNascimento;

	public int getId(){
		return this.id;
	}

	public void setId(int id){
		this.id = id;
	}

	public String getNome(){
		return this.nome;
	}

	public void setNome(String nome){
		this.nome = nome;
	}

	public String getEmail(){
		return this.email;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEndereco(){
		return this.endereco;
	}

	public void setEndereco(String endereco){
		this.endereco = endereco;
	}

	public LocalDate getDataNascimento(){
		return this.dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento){
		this.dataNascimento = dataNascimento;
	}
}