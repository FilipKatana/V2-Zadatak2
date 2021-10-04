package node;


public class NumericNode extends Node {
	private double value;
	
	public NumericNode(double value) {
		this(value, "default");
	}
	
	public NumericNode(double value, String name) {
		super(name);
		this.value = value;
	}
	
	
	public NumericNode eval() {
		return this;
	}
	
	public double getValue() {
		return this.value;
	}
	
	public void writeOut() {
		this.writeOut(' ');
		System.out.println(", Value: " + this.value);
	}

	

}
