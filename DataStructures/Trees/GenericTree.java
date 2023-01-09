import java.util.ArrayList;
import java.util.List;

/**
This is the code to create a representation of a generic hierarchical structure in the form of a tree. 
We will attempt to store the menu of a cafe:
Drinks:
	Hot
		Tea
			Green
			Black
		Coffee
			Americano
			Latte
			Capuccino
	Cold
		Non Alcoholic
			Cola
			Fanta
			Soda
		Alcoholic
			Wine
			Beer
*/

class GenericTree{
	class Node{
		String value;
		int level;
		List<Node>children;
		Node(String value, int level){
			this.value=value;
			this.level= level;
			this.children=new ArrayList<>();
		}
		public void addChild(Node child){
			this.children.add(child);
		}
		public String getValue(){
			return this.value;
		}
		public List<Node> getChildren(){
			return this.children;
		}

		public int getLevel(){
			return this.level;
		}
	}
	public Node head =null;
	public void addHead(Node node){
		head=node;
	}
	public void traverse(Node node){
		System.out.printf(("  ").repeat(node.getLevel()));
		if(node.getChildren().size()==0){
			System.out.println(node.getValue());
			return;
		}else{
			System.out.println(node.getValue());
			for (Node childNode: node.getChildren()){
				traverse(childNode);
			}
		}
	}
	public static void main(String args[]){
		GenericTree gt = new GenericTree();
		Node drinks = gt.new Node("Drinks", 0);
		gt.addHead(drinks);
		Node hot = gt.new Node("Hot", 1);
		Node cold = gt.new Node("Cold", 1);
		drinks.addChild(hot);
		drinks.addChild(cold);
		Node tea = gt.new Node("Tea",2);
		Node coffee = gt.new Node("Coffee", 2);
		hot.addChild(tea);
		hot.addChild(coffee);
		Node green = gt.new Node("Green", 3);
		Node black = gt.new Node("Black", 3);
		tea.addChild(green);
		tea.addChild(black);
		Node americano = gt.new Node("Americano", 3);
		Node latte = gt.new Node("Latte", 3);
		Node capuccino = gt.new Node("Capuccino", 3);
		coffee.addChild(americano);
		coffee.addChild(latte);
		coffee.addChild(capuccino);

		Node alcoholic = gt.new Node("Alcoholic", 2);
		Node nonAlcoholic = gt.new Node("Non-Alcoholic", 2);
		cold.addChild(alcoholic);
		cold.addChild(nonAlcoholic);

		Node cola = gt.new Node("Cola", 3);
		Node fanta = gt.new Node("Fanta", 3);
		Node soda = gt.new Node("Soda", 3);
		nonAlcoholic.addChild(cola);
		nonAlcoholic.addChild(fanta);
		nonAlcoholic.addChild(soda);

		Node wine = gt.new Node("Wine", 3);
		Node beer = gt.new Node("Beer", 3);
		alcoholic.addChild(wine);
		alcoholic.addChild(beer);

		gt.traverse(drinks);

		
	}
}
