package corePakage;

import java.util.*;


public class  LinkedList {
	  String value;
	  LinkedList next;
	  
	  LinkedList() {
	    this.next = null;
	  }

	  public boolean add(String v){
		  LinkedList ll = this ;
		  while (ll.next != null) {
			  ll = ll	.next;
		  }
		  LinkedList nl = new LinkedList ();
		  nl.next =null ;
		  nl.value = v ;
		  ll.next = nl;	  
		  
	    return true;
	  }

	  public boolean insert(int index, String v) {
		  
		  LinkedList nl = new LinkedList();
		  nl.value = v;
		  
		  LinkedList ll = this;
		  
		  while ((--index)>0) {
			  ll = ll.next;
		  }
		  	  ll.next = nl ;
		  

	    return true;
	  }
	  
	  public boolean delete(int index) {
		  LinkedList ll = 	this ;
		  
		  while ((--index)>0) {
			  ll = ll.next;
		  }
	    if (ll.next.next == null){
	    	ll.next = null ;
	    }else {
	    	ll.next = ll.next.next ;
	    }
	    
	    return true;
	  }
	  
	  public boolean modify(int index, String v) {
		  LinkedList ll = this ;
		  
		  while ((--index)>0);{
			  ll = ll.next ;
		  }
		  ll.next.value = v ;
	    
	    return true;
	  }
	  
	  public int search(String v) {
		  int index = 0;  
		  LinkedList ll = this;        
		  while(ll.value != v){           
			  ll = ll.next;
			  index++;
	    }
	    return index;
	  }
	  
	  public void printLinkedList() {
		  LinkedList ll = this;
		    while (ll != null) {
		      System.out.print (ll.value);
		      if (ll.next != null) System.out.print(" -> ");	
		      ll = ll.next;
		    }
		    System.out.println();
		  }
	  
	  public LinkedList getLast() {
		    LinkedList last = this.next;
		    
		    return last;
	  }
	  
public static void main(String[] args) {
		  LinkedList ll = new LinkedList();
	    
	    if (ll.add("a") == false)
	      System.out.println("Error Occurred");
	    ll.printLinkedList();
	    
	   if (ll.add("b") == false)
	      System.out.println("Error Occurred");
	    ll.printLinkedList();

	    if (ll.add("c") == false)
	      System.out.println("Error Occurred");
	    ll.printLinkedList();

	    if (ll.insert(3,"f") == false)
	      System.out.println("Error Occurred");
	    ll.printLinkedList();
	  
	   if (ll.delete(2) == false)
	      System.out.println("Error Occurred");
	    ll.printLinkedList();
	    
	    if (ll.add("d") == false)
	      System.out.println("Error Occurred");
	    ll.printLinkedList();
	    
	    
	    System.out.println("String c : " + ll.search("c"));
	    ll.printLinkedList();
	    
	    ll.getLast();
}
}



	    

	  
		

	


		
		
	




