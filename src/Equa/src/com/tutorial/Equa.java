package com.example;

import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;


public class ReadWebPage
{
    public static void main(String[] args)
	{
        try
		{
            URL site = new URL("http://www.anacodeide.com/blog");
            URLConnection uc = site.openConnection();
            Scanner scanner = new Scanner(new InputStreamReader(uc.getInputStream()));
            int count = 0;
            while (scanner.hasNext())
			{
                System.out.println(scanner.next());
                count++;
            }
            System.out.println("Number of tokens: " + count);
            scanner.close();
        }
		catch (Exception ex)
		{
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
