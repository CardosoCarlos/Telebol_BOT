import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.LinkedList;


public class Connection {
	
	private Model model;
	public String timeNome;
	
	public Connection(Model model) {
		this.model = model;
		this.timeNome = timeNome;
	}
	
	public void popula() throws JSONException{
		getDataTeam();
		}
	
	public void getDataTeam() throws JSONException{
		
		final StringBuilder result = new StringBuilder();
		
		URL urlAll;
		HttpURLConnection urlConnection = null;
		
		try {
			
			urlAll = new URL("http://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?l=English%20Premier%20League");
			
			urlConnection = (HttpURLConnection) urlAll.openConnection();
			
			InputStream in = urlConnection.getInputStream();
			
			InputStreamReader isw = new InputStreamReader(in);
			
			int data =  isw.read();
			int x = 0;
			
			while(data != -1) {
				char current = (char) data;
				data = isw.read();
				if(current == '[') {
					x = 1;
				}
				if(x != 0) {
					result.append(current); 
				}
//				result.append(current);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally{
			
			try {
				urlConnection.disconnect();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(result);
		
		generateJSONTeam(new JSONArray(result.toString()));
		 
	}
	
	public void generateJSONTeam(JSONArray json) {
		
		try {
			
			for(int i = 0; i < json.length(); i++) {
				JSONObject obj = json.getJSONObject(i);
				timeNome = obj.getString("strTeam");
				model.addTeam(new Team(timeNome));
				//popula player (timeNome)
				
			}
		} catch(JSONException e) {
			
			//Handle
		}
		
	}
	
	public void getDataPlayer(String timeNome) throws JSONException{
		
		final StringBuilder result = new StringBuilder();
		URL urlPlayers;
		HttpURLConnection urlConnection = null;
		
		try {
			
			urlPlayers = new URL("www.thesportsdb.com/api/v1/json/1/searchplayers.php?t="+timeNome+"");
			urlConnection =  (HttpURLConnection) urlPlayers.openConnection();
			InputStream in = urlConnection.getInputStream();
			InputStreamReader isw = new InputStreamReader(in);
			
			int data = isw.read();
			int x = 0;
			while(data!= -1) {
				char current = (char) data;
				data = isw.read();
				if(current == '[') {
					x = 1;
				}
				if(x != 0) {
					result.append(current); 
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				urlConnection.disconnect();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		
		System.out.println(result);
		
		generateJSONPlayer(new JSONArray(result.toString()), timeNome);
		
		
	}
	
	public void generateJSONPlayer(JSONArray json, String timeNome){
		
		try {
			
			for(int i=0; i<json.length(); i++) {
				JSONObject obj = json.getJSONObject(i);
				String strPlayer = obj.getString("strPlayer");
				String strPosition = obj.getString("strPosition");
				model.addPlayer(timeNome, new Player(strPlayer, strPosition));
			}
		} catch(JSONException e) {
			
		}
		
	}
}
