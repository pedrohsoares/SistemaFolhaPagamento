package com.folha;

import java.util.Stack;

public class UndoRedo {
	private Stack<Empresa> stackUndo;
	private Stack<Empresa> stackRedo;
	
	public UndoRedo() {
		stackUndo = new Stack<Empresa>();
		stackRedo = new Stack<Empresa>();
	}

	public Stack<Empresa> getStackUndo() {
		return stackUndo;
	}

	public void setStackUndo(Stack<Empresa> stackUndo) {
		this.stackUndo = stackUndo;
	}

	public Stack<Empresa> getStackRedo() {
		return stackRedo;
	}

	public void setStackRedo(Stack<Empresa> stackRedo) {
		this.stackRedo = stackRedo;
	}
	
	
}
