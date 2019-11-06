import java.io.*;
public class CriaDados{
	public static void main(String[] args){
		//Dados dados = new Dados("localhost", "3036", "fj21", "evandro", "evandro");
		Dados dados = new Dados(args[0], args[1], args[2], args[3], args[4]);
		try{
			FileOutputStream fos = new FileOutputStream("dados.ser");
			ObjectOutputStream oos= new ObjectOutputStream(fos);
			oos.writeObject(dados);

			oos.close();	
		}catch(Exception e){
			System.out.println("Erro!");
		}
		
	}
}