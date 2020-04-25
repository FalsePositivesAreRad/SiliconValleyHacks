package SiliconValleyHacks;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SuperAwesomeClass {
	public static void main(String [] args) { 
		
		String all = null;
		try {
		Document doc = Jsoup.connect("https://www.timeanddate.com/weather/").userAgent("Chrome/81.0").get();
		Elements temp = doc.select("div.tb-scroll");
		for (Element names:temp) {
			all = names.getElementsByTag("tbody").first().text();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String tempAll = all;
		System.out.print(tempAll);
		
		char[] allChar = all.toCharArray();
		ArrayList<String> Cities = new ArrayList<String>();
		ArrayList<String> DatesAndTimes = new ArrayList<String>();
		ArrayList<String> Temps = new ArrayList<String>();
		int spaceChecker = 0;
		for (int i = 0; i < all.length()-1; i++) {
			if (spaceChecker == 0 && allChar[i] == ' ' && !(allChar[i+1] == '*')) {
				Cities.add(all.substring(0,i));
				tempAll.substring(i+1);
				spaceChecker++;
			} else if (allChar[i+1] == '*') {
				Cities.add(all.substring(0,i+2));
				tempAll.substring(i+1);
				spaceChecker++;
			}
			if (spaceChecker == 1 && allChar[i] == ' ')
					spaceChecker++;
			if (spaceChecker == 2 && allChar[i] == ' ')
				spaceChecker++; 
			if (spaceChecker == 3 && allChar[i] == ' ') {
				DatesAndTimes.add(all.substring(0,i));
				tempAll.substring(i+1);
				spaceChecker++;
			}
			if (spaceChecker == 4 && allChar[i] == ' ')
				spaceChecker++; 
			if (spaceChecker == 5 && allChar[i] == ' ') {
				Temps.add(all.substring(0,i));
				tempAll.substring(i+1);
				spaceChecker++;
			}
		}
		
		
		System.out.println(Cities);
		
		
		
		
		
		
		
		
		
		
		
	}
}
	

