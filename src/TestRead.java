public class TestRead{
	public static void main(String[] args){
		UsuarioDao dao = new UsuarioDao();

		Usuario u = new Usuario();
		u.setNome("Nete");
		u.setEmail("pequenaluzi@hotmail.com");
		u.setEndereco("R. Leandro Campanario, 3A");
		u.setDataNascimento(java.time.LocalDate.of(2019,01,22));
		dao.create(u);
		
		Usuario incompleto = new Usuario();
		incompleto.setNome("Nete");

		//incompleto.setEmail("evandrocwd@gmail.com");

		//dao.delete(incompleto);


		Usuario usuario = (Usuario) dao.read(incompleto);

		System.out.println(usuario.getNome());
		System.out.println(usuario.getEmail());
		System.out.println(usuario.getEndereco());
		System.out.println(usuario.getDataNascimento());
	}
}