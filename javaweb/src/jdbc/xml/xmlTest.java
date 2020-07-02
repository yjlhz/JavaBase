package jdbc.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class xmlTest {
    @Test
    public void test01(){
        SAXReader reader = new SAXReader();//创建xml解析对象
        //把xml文档加载到document对象中
        Document document = null;
            try {
                document = reader.read("src/jdbc/book.xml");
                //获取根节点
                Element root = document.getRootElement();
                //获取当前节点的所有子节点
                List list = root.elements();
                Element thirdbook = (Element) list.get(2);
                String name = thirdbook.element("name").getText();
                System.out.println(name);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
    }
    @Test
    public void test02() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/jdbc/book.xml");
        Element root = document.getRootElement();
        treeSelect(root);
    }
    /*
     * 递归
     */
    private void treeSelect(Element element){
        //输出当前节点名字
        System.out.println(element.getName());
        for (int i = 0; i < element.nodeCount(); i++){
            //取出下标为i的节点
            Node node = element.node(i);
            //判断当前节点是否为标签
            if (node instanceof Element){
                treeSelect((Element) node);
            }else{
                System.out.println(node.getText());
            }
        }
    }

}
