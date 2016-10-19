import java.io.PrintWriter;

public class linkedList {
private listNode listhead;
	
	public linkedList(){};
	
	public linkedList(String s){
		listhead=new listNode (s);
	}
	
	public listNode findSpot(listNode head,String s){
		listNode spot=head;
		while(spot.next!=null && spot.next.data.compareToIgnoreCase(s)<=0){
			spot=spot.next;
			}
		if(spot.data.compareToIgnoreCase(s)==0){
			spot.count++;
			return null;
		}
		return spot;
	}
	
	public void listInsert(listNode location, listNode n ){
		n.next=location.next;
		location.next=n;
	}
	
	public void debugPrint(listNode head, PrintWriter pw){
		listNode current=head;
		pw.print("ListHead-->");
		while(current!=null){
			if(current.next==null)
				pw.println("("+current.data+", Null)-->Null");
			else
				pw.print("("+current.data+ ","+current.next.data+")-->");
		current=current.next;
		}
		pw.println();
	}

	public listNode getListhead() {
		return listhead;
	}

	public void setListhead(listNode listhead) {
		this.listhead = listhead;
	}
	
	public boolean isCommonWord(listNode head, String data){
		listNode current=head;
		while(current!=null){
			if(current.data.compareToIgnoreCase(data)==0){
				//System.out.println("FOUND COMMON!!!!!!");
				return true;
			}
			current=current.next;
		}
		return false;
	}
	
	
	public void printSortedList(PrintWriter out, listNode head){
		listNode current=head;
		current=head;
		out.println("All the words in textList with their repetition counter: ");
		while(current!=null){
			out.println("Word: "+current.data +", count: "+ current.count);
			current=current.next;
		}
	}

}
