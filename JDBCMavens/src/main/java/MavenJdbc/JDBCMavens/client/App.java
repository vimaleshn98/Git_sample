package MavenJdbc.JDBCMavens.client;

import java.util.Scanner;

import MavenJdbc.JDBCMavens.exception.CustomException;
import MavenJdbc.JDBCMavens.service.WatchInteface;
import MavenJdbc.JDBCMavens.service.implementation.WatchImplements;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	WatchInteface inteface = new WatchImplements();
    	Scanner scanner = new Scanner(System.in);
		int choice;
		do {
			System.out.println(
					"1 --> Add Watch Type\n2 -->Add Watchs\n3 -->Sort based on Price of watches \n4--> Delete\n Enter your choice");
			
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("---------------Add Watch Type-----------");
				try {
					inteface.addWatchType();
				} catch (CustomException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 2:
				System.out.println("-----------Add Watchs-----------------");
				try {
					inteface.addWatch();
				} catch (CustomException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				
				System.out.println("-----------Sort based on Price of watches-----------------");
				inteface.sort();
				System.out.println("----------------------------------------------------");
				break;
			case 4:
				System.out.println("-------------------Deleted based on id----------------------------");
				System.out.println("--------------before delete-------------------");
				inteface.display();
				inteface.delete();
				System.out.println("--------------after delete-------------------");
				inteface.display();
				System.out.println("----------------------------------------------------");
				break;
			default:
				System.out.println("Existing from main Menu");
			}
		} while (choice <= 6 && choice >= 1);
    }
}
