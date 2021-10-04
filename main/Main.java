package main;

import enumerated.Operation;
import node.NumericNode;
import node.OperationNode;

public class Main {

	public static void main(String[] args) {
		OperationNode m = new OperationNode(Operation.MULTIPLICATION, "Better Name", new NumericNode(2), new NumericNode(3));
		OperationNode root = new OperationNode(Operation.MULTIPLICATION, "Root", new NumericNode(0), new NumericNode(5.3), m, new NumericNode(1.1));
		root.setOperation(Operation.SUM);
		System.out.println(root.eval().getValue());
	
	}

}
