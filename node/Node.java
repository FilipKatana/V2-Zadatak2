package node;

import evaluate.Evaluatable;

public abstract class Node implements Evaluatable {
	private String name = "Default";
	
	public Node(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String n) {
		this.name = n;
	}
	
	protected void writeOut(char end) {
		System.out.print("Name: " + this.name + end);
	}
	
	public void writeOut() {
		this.writeOut('\n');
	}
	
	
	
}
