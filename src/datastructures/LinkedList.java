package datastructures;

public class LinkedList {

	int size;
	Element initial;
	Element end;
	
	public LinkedList(){
		size = 0;
		initial = null;
		end = null;
	}
	
	public void add(Element newElement){
		addLast(newElement);
	}
	
	public void addLast(Element newElement){
		if(end==null){
			initial = newElement;
			end = newElement;
		} else{
			end.setNext(newElement);
			end = newElement;
		}
		size++;
	}
	
}
