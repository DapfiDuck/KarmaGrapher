package capture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class StatReader {
	
	String SourceCode;

	public StatReader() {

	}
	
	public void BufferSource(String url) throws IOException {
		SourceCode = loadURLSource(url);
		
	}

	public String getKarma(){

		String source = SourceCode;

		while (true) {

			try {

				source = source.substring(source.indexOf("aria-label=\"upvote\""));

				int pos = source.indexOf("_1rZYMD_4xY3gRcSS3p8ODO");

				source = source.substring(pos);

				pos = source.indexOf(">") + 1;

				source = source.substring(pos);
				source = source.substring(0, source.indexOf("<"));

				return source;

			} catch (Exception e) {
				
				System.out.println("Failed to read karma");
				return null;
				
			}
		}

		// System.out.println("Returned " + source + " Karma\n");

	}
	
	public String getViews() {
		
		try{
		
		String source = SourceCode;
		
		source = source.substring(source.indexOf("class=\"t4Hq30BDzTeJ85vREX7_M\""));
		source = source.substring(source.indexOf("<span>")+6, source.indexOf("%"));
		
		return source;
		}catch(Exception e) {
			System.out.println("Failed to read percentage");
			return null;
		}
		
	}
	
	public String getSource() {
		
		return SourceCode;
		
	}
	
	

	public String loadURLSource(String url) throws IOException {
		URL urlObject = new URL(url);
		URLConnection urlConnection = urlObject.openConnection();
		urlConnection.setRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");

		return toString(urlConnection.getInputStream());
	}

	private String toString(InputStream inputStream) throws IOException {
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))) {
			String inputLine;
			StringBuilder stringBuilder = new StringBuilder();
			while ((inputLine = bufferedReader.readLine()) != null) {
				stringBuilder.append(inputLine);
			}

			return stringBuilder.toString();
		}
	}

}
