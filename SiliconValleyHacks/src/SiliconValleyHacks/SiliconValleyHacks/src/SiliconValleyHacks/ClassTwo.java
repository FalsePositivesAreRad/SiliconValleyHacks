package SiliconValleyHacks;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ClassTwo {
	static ArrayList<String> cities = new ArrayList<String>();
	static ArrayList<ArrayList<String>> temps = new ArrayList<ArrayList<String>>();
	
	public static void main (String[] args) {
		try {
			Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/List_of_cities_by_average_temperature").get();
			Element body = doc.body();
			Elements table = body.getElementsByTag("tbody");
			for (int i = 0; i < 6; i++) {
				for (Element currentElement:table.get(i).children()) {
					if (!currentElement.child(1).text().equals("City")) {
						cities.add(currentElement.child(1).text());
						ArrayList<String> temp = new ArrayList<String>();
						for (int x = 2; x < 12; x++) {
								temp.add(currentElement.child(x).text());
						}
						temps.add(temp);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
