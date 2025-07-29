package base;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

enum RETURN_DATA_TYPE{
	TILEMAP,
	LEVEL,
	MOB,
	ITEM,
	PLAYER
	
}
enum SEQUENCE{
	PART_0,
	PART_1,
	PART_2,
	PART_3
	
}
//9:58
public class XmlLoader {
	 DocumentBuilderFactory factory;
	 DocumentBuilder builder;
		public XmlLoader() {
			//il design pattern factory esonera l'utente dalla definizione del costruttore di un oggetto desiderato e permette di far scegliere dinamicamente (in base a parametro) il tipo dell'oggetto desiderando..rendendo non necessaria una strutturazione degli if all'utente
			 factory= DocumentBuilderFactory.newInstance();
			 try {
				builder = factory.newDocumentBuilder();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		public Tileset tilesetLoader() {
			
			File file=new File("configs/tilemaps/bunnyGameTiles.tsx");
			int c[][]=new int[12][16];
			String r;
			Document document = null;
			try {
				document = builder.parse(file);
			} catch (SAXException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				document = builder.parse(file);
			} catch (SAXException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//prende l'elemento ROOT..la radice
			Element rootElement =document.getDocumentElement();
			//prendere la lista dei nodi con uno specifico nome del tag
			
			NodeList nodeList= rootElement.getElementsByTagName("image");
			
			String s = nodeList.item(0).getAttributes().getNamedItem("collidable").getTextContent();
			String s2 = nodeList.item(0).getAttributes().getNamedItem("source").getTextContent();
			return new Tileset(s,s2);
			
			
			
		}
		public int[][] tileMapLoader(int choice) {
			if (choice==0) {	
				File file=new File("configs/tilemaps/level0Map.tmx");
				int c[][]=new int[12][16];
				String r;
				Document document = null;
				try {
					document = builder.parse(file);
				} catch (SAXException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					document = builder.parse(file);
				} catch (SAXException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//prende l'elemento ROOT..la radice
				Element rootElement =document.getDocumentElement();
				//prendere la lista dei nodi con uno specifico nome del tag
				
				NodeList nodeList= rootElement.getElementsByTagName("layer");
				//itera nella lista
				Node node=nodeList.item(0);
					if (node.getNodeType()==Element.ELEMENT_NODE) {//TRATTA IL NODO COME UN ALTRA ROOT
					    Element e= (Element) node;	//CASTING
					    NodeList node2= e.getElementsByTagName("data");
					    r=node2.item(0).getTextContent();
					    char[] matrix =r.toCharArray();
					    int i=0,j=0;
					    for (char b:matrix) {
					    		if (!Character.isDigit(b));
						    
						    	else {
						  

						    		c[i][j]=b-'0';
						      	if (j>=15) {
						    			j=0;
						    			i+=1;
						    		}
						    		else 	j+=1;
						    	}
					      }
					
					    return c;				
					}
					

				}
			else if (choice==2) {
				
				
				
			}
			return null;

			}
		
		public static void main(String[] args) {
			/**
			
				//crea una struttura del file ad albero(DOM)
				try {
					Document document= builder.parse(file);
					//prende l'elemento ROOT..la radice
					Element rootElement =document.getDocumentElement();
					System.out.println(rootElement.getNodeName());
					
					//prendere la lista dei nodi con uno specifico nome del tag
					
					NodeList nodeList= rootElement.getElementsByTagName("book");
					System.out.println(nodeList.getLength());
					
					//itera nella lista
					for (int i=0;i<nodeList.getLength();i++)
					{
						Node node=nodeList.item(i);
						System.out.println(node.getNodeName());
						if (node.getNodeType()==Element.ELEMENT_NODE) {//TRATTA IL NODO COME UN ALTRA ROOT
						    Element e= (Element) node;	//CASTING
						    System.out.println(e.getAttribute("id")); 
						    NodeList node2= e.getElementsByTagName("title");
						    System.out.println(node2.item(0).getTextContent());
						}
					}
					
				} catch (SAXException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 
			 } catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		 **/
			XmlLoader xml=new XmlLoader();
			System.out.println(xml.tilesetLoader());
		}
	

}
