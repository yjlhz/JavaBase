package ObjectStreamDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class ObjectStreamDemo {
	
	private static String filepath = "E:/eclipse-workspace/JavaBase/src/ObjectStreamDemo/Object.txt";

	public static void main(String[] args) {
		File file = new File(filepath);
		try (
				OutputStream output = new FileOutputStream(file);
				ObjectOutputStream objoutputstream = new ObjectOutputStream(output);
				
			){
			player player1 = new player("Hero", 100);
			objoutputstream.writeObject(player1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try (
				InputStream input = new FileInputStream(file);
				ObjectInputStream objinput = new ObjectInputStream(input);
			){
			player player2 = (player)objinput.readObject();
			System.out.println(player2);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
class player implements Serializable{
	private static final long serialVersionUID = 5071012827804906606L;
	private String Name;
	private int level;
	
	public player() {};
	
	public player(String name, int level) {
		setName(name);
		setLevel(level);
	}
	
	@Override
	public String toString() {
		
		return Name + "\t" + level;
	}
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
}