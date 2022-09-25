import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore.Entry.Attribute;
//my main issue was researching to combine the code of hashmap and the word frequency count
//i read through articles and watched the youtube videos but it didn't help much to have the different codes working together
import java.util.ArrayList;

import javax.lang.model.util.Elements;
import javax.swing.text.Document;
import javax.swing.text.Element;

import org.jsoup.Jsoup;

public class TextReader{
	
public static void main(String[] args) throws FileNotFoundException {


		//https://www.gutenberg.org/files/1065/1065-h/1065-h.htm

	//the first part is to connect with the URL that contains the poems path
	String urlToRead = "https://www.gutenberg.org/files/1065/1065-h/1065-h.htm";
	URL url; 
	HttpURLConnection conn; 
	BufferedReader rd; 
	String line; 
	String result = ""; 
	try {
	 url = new URL(urlToRead);
	 conn = (HttpURLConnection) url.openConnection();
	 conn.setRequestMethod("GET");
	 rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	 while ((line = rd.readLine()) != null) {
	  result += line;
	 }
	 rd.close();
	} catch (Exception e) {
	 e.printStackTrace();
	}

	//this second part system prints out only the <p> section  
	String html = "https://www.gutenberg.org/files/1065/1065-h/1065-h.htm";
Document doc = Jsoup.connect(url).get();
Elements para = doc.select("p");
int i = 0;
for (Element para : p) {
   System.out.format("p #%d:\n", ++i);
   for(Attribute attr : p.attributes()) {
       System.out.format("%s = %s\n", attr.getKey(), attr.getValue());
	
	
	//this third part counts the word frequencies
	
	 if (args.length != 2) {
         System.out.println("Usage: java WordFrequency ");
         System.exit(1);
     }
     
     try {
         WordFrequency wf = new WordFrequency();
         wf.processFile(new File(args[0]));
         
         //-- Get the results.
         int n = wf.getEntryCount();
         ArrayList<String>  wrds      = new ArrayList<String>(n);
         ArrayList<Integer> frequency = new ArrayList<Integer>(n);
         wf.getWordFrequency(wrds, frequency);
         
         //-- Print the results.
         for (int i=0; i<n; i++) {
             System.out.println(frequency.get(i) + " " + wrds.get(i));
         }
         
         System.out.println("\nNumber of source words: " + wf.getWordCount());
         System.out.println("\nNumber of unique words: " + n);
         
     } catch (IOException iox) {
         System.out.println(iox);
     }
     
	
}
}
}
}
