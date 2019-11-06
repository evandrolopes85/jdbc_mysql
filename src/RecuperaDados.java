import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class RecuperaDados{
	private FileInputStream fis = null;
	private ObjectInputStream ois = null;
	private Dados dados;

	public RecuperaDados(){
		

		try{
			fis = new FileInputStream("dados.ser");
			ois = new ObjectInputStream(fis);
			dados = (Dados)ois.readObject();
	
		}catch(Exception e){
			System.err.println("Erro");
		}finally{
			if(fis != null){
				try{
					fis.close();	
				}catch(IOException e){
					System.err.println("Erro ao ler/abrir o arquivo!");
				}
				
			}

			if(ois != null){
				try{
					ois.close();	
				}catch(IOException e){
					System.err.println("Erro ao fechar arquivo!");
				}
			}
		}
	}

	public Dados getDados(){
		return this.dados;
	}
}