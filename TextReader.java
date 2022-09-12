import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


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
	String url = "https://www.gutenberg.org/files/1065/1065-h/1065-h.htm";
Document doc = Jsoup.connect(url).get();
Elements para = doc.select("p");
int i = 0;
for (Element para : p) {
   System.out.format("p #%d:\n", ++i);
   for(Attribute attr : p.attributes()) {
       System.out.format("%s = %s\n", attr.getKey(), attr.getValue());
	System.out.println(result);
	
	//this part counts the word frequencies
	
	
	
}
}
}
}