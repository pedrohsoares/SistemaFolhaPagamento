package models;

import java.util.Stack;

import main.Company;

public class UndoRedo {
	private Stack<Company> stackUndo;
	private Stack<Company> stackRedo;
	
	public UndoRedo() {
		stackUndo = new Stack<Company>();
		stackRedo = new Stack<Company>();
	}

	public Stack<Company> getStackUndo() {
		return stackUndo;
	}

	public void setStackUndo(Stack<Company> stackUndo) {
		this.stackUndo = stackUndo;
	}

	public Stack<Company> getStackRedo() {
		return stackRedo;
	}

	public void setStackRedo(Stack<Company> stackRedo) {
		this.stackRedo = stackRedo;
	}
	
	
}
