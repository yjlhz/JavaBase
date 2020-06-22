package ReflectDemo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DriveCarText {
    public static void main(String[] args){
        Properties p = new Properties();
        try (FileReader reader = new FileReader("E:/eclipse-workspace/JavaBase/src/ReflectDemo/Car.properties");) {
            p.load(reader);
            Class c = Class.forName(p.getProperty("carName"));
            Object o = c.newInstance();
            System.out.println(o);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
