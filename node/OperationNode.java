package node;

import java.util.ArrayList;

import enumerated.Operation;
import evaluate.Evaluatable;

public class OperationNode extends Node {
	private Operation operation;
	private ArrayList<Evaluatable> nodes;
	
	public OperationNode(Operation operation, String name, Evaluatable ...nodes) {
		super(name);
		this.setOperation(operation);
		this.nodes = new ArrayList<Evaluatable>();
		
		for (Evaluatable e : nodes) {
			this.nodes.add(e);
		}
	}
	
	public OperationNode(Operation operation, Evaluatable ...nodes) {
		this(operation, "default operation", nodes);
		
	}
	
	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}
	
	private double performOperation(double a, double b) {
		switch (this.operation) {
		case SUM:
			return a + b;
		case MULTIPLICATION:
			return a * b;
		default:
			return 0;
		}
	}
	
	
	public NumericNode eval() {
		if (this.nodes.size() == 0) {
			return new NumericNode(0, this.getName());
		}
		
		double result = this.nodes.get(0).eval().getValue();
		
		for (int i = 1; i < this.nodes.size(); ++i) {
			result = this.performOperation(result, this.nodes.get(i).eval().getValue());
		}
		
		return new NumericNode(result, this.getName());
		
	}
	
	
	public void writeOut() {
		this.writeOut(' ');
		System.out.print(", Operation: " + this.operation + ", " + this.nodes.size() + " nodes");
	}
	
	public Evaluatable getNode(int index) {
		if (index < 0 || index >= this.nodes.size()) {
			throw new IndexOutOfBoundsException("Fatal error! Could not return node because the given index is out of bounds!");
		}
		return this.nodes.get(index);
	}
	
	



}
