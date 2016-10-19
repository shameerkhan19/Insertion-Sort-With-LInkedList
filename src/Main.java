//Shameer Khan , project 1.2
// cs-323

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		linkedList commonWordList= new linkedList("dummy");
		linkedList textlist= new linkedList("dummy");
		Scanner scan=null;
		Scanner scan2=null;
		if(args.length==0)
			System.out.println("File doesn't exist!");
		try{
		scan= new Scanner(new FileReader(args[0]));
		scan2=new Scanner(new FileReader(args[1]));
		PrintWriter outfile= new PrintWriter(new FileWriter(args[2]));
		PrintWriter outfile2= new PrintWriter(new FileWriter(args[3]));
		while(scan.hasNext()){
			String s=scan.next();
			listNode Spot= commonWordList.findSpot(commonWordList.getListhead(), s);
			if(Spot!=null){
			listNode newNode= new listNode(s);
			commonWordList.listInsert(Spot,newNode);
			outfile.println("String inserted: ("+ s+")");
			commonWordList.debugPrint(commonWordList.getListhead(), outfile);
				}
			}
		int insertCount=0;
		while(scan2.hasNext()){
			String text=scan2.next();
			if(commonWordList.isCommonWord(commonWordList.getListhead(),text)==false){
				listNode Spot= textlist.findSpot(textlist.getListhead(), text);
				if(Spot!=null){
					listNode newNode= new listNode(text);
					textlist.listInsert(Spot, newNode);
					insertCount++;
					if(insertCount>=5){
						commonWordList.debugPrint(commonWordList.getListhead(), outfile);
						insertCount=0;
						}
					}
				}
			}
		textlist.printSortedList(outfile2, textlist.getListhead());
		scan.close();
		outfile.close();
		scan2.close();
		outfile2.close();
		}
		catch(Exception e){
			System.out.println(e);
		}

	}
}
