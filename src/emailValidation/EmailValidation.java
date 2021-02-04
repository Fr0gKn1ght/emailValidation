package emailValidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Scanner;

//This program takes in a string or strings from the user via command line and determines
//if they are in a valid format and if they are present within a pre-existing datastructure.
public class EmailValidation {
	
	final static Pattern pattern = Pattern.compile("([A-Za-z0-9.])+@{1}([a-z]+\\.{1}[a-z]{2}.?)");
	final static Set<String> emails = new HashSet<String>();
	
	//Normally we'd be working with an existing database of some form. This is just intended to serve as a stand-in for the sake of simplicity.
	private static void init()
	{
		emails.add("template@gmail.com");
		emails.add("cgray@example.me");
		emails.add("mullet129@yahoo.com");
		emails.add("walter.wesley@organization.org");
		emails.add("onehundred100@hotmail.com");
	}
	
	public static void main(String[] args)
	{
		//Initializing our pseudo email database.
		init();
		
		
		ArrayList<String> valid = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		String in;
		//Find all valid email addresses from user input.
		while(true)
		{
			in = scan.nextLine();
			if(in.equals(""))
				break;
			Matcher match = pattern.matcher(in);
			if(match.find())
				valid.add(in);
			else
				System.out.println(in + " is not a valid email address!");
		}
		scan.close();
		
		//If no valid emails found in database, state so.
		if(valid.size()==0)
		{
			System.out.println("No valid emails found.");
			return;
		}
		
		//Else print out the valid emails found.
		System.out.println("The following valid emails were found:");
		for(int i = 0; i<valid.size();i++)
		{
			if(emails.contains(valid.get(i)))
			{
				System.out.println(valid.get(i));
			}
		}
		
	}
}
