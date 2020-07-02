package jdbc.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class XPathTest {
    @Test
    public void test01() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/jdbc/book.xml");
        Node node1 = document.selectSingleNode("/books/book/name");
        System.out.println(node1.getText());
        Node node2 = document.selectSingleNode("/books/book[4]/name");
        System.out.println(node2.getText());
        Node node3 = document.selectSingleNode("/books/book/attribute::id");
        System.out.println(node3.getText());
        Node node4 = document.selectSingleNode("/books/book[3]/attribute::id");
        System.out.println(node4.getText());

    }
    @Test
    public void test2() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/jdbc/book.xml");
        List list = document.selectNodes("//*");
        for (int i = 0; i < list.size(); i++){
            Node node = (Node) list.get(i);
            System.out.println(node.getName() + "\t" + node.getText());
        }
    }
}
