import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;


public class Connection {
	
	private Model model;
	public String timeNome;
	public String leagueName;
	public Map<Integer, String> leagueURL = new HashMap<>(); 
	
	public Connection(Model model) {
		this.model = model;
		this.timeNome = timeNome;
		this.leagueName = leagueName;
		leagueURL.put(1, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=Argentinian+Primera+Divisi%C3%B3n");
		leagueURL.put(2, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=Australian+A-League");
		leagueURL.put(3, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=Belgian+Jupiler+League");
		leagueURL.put(4, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=Brazilian+Brasileirao+Serie+B");
		leagueURL.put(5, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=Brazilian+Brasileirao");
		leagueURL.put(6, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=Chinese+Super+League");
		leagueURL.put(7, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=Danish+Superliga");
		leagueURL.put(8, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=English+League+1");
		leagueURL.put(9, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=English+League+2");
		leagueURL.put(10, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=English+Premier+League");
		leagueURL.put(11, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=English+League+Championship");
		leagueURL.put(12, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=French+Ligue+2");
		leagueURL.put(13, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=French+Ligue+1");
		leagueURL.put(14, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=German+2.+Bundesliga");
		leagueURL.put(15, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=German+Bundesliga");
		leagueURL.put(16, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=Greek+Superleague+Greece");
		leagueURL.put(17, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=Dutch+Eredivisie");
		leagueURL.put(18, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=FIFA+World+Cup");
		leagueURL.put(19, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=Italian%20Serie%20B");
		leagueURL.put(20, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=Italian%20Lega%20Pro");
		leagueURL.put(21, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=Italian%20Serie%20A");
		leagueURL.put(22, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=Mexican%20Primera%20League");
		leagueURL.put(23, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=Norwegian%20Tippeligaen");
		leagueURL.put(24, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=Norwegian%201.%20Divisjon");
		leagueURL.put(25, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=Polish%20Ekstraklasa");
		leagueURL.put(26, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=Portuguese%20Primeira%20Liga");
		leagueURL.put(27, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=Russian%20Football%20Premier%20League");
		leagueURL.put(28, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=Scottish%20Championship");
		leagueURL.put(29, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=Scottish%20Premier%20League");
		leagueURL.put(30, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=Spanish%20Adelante");
		leagueURL.put(31, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=Spanish%20La%20Liga");
		leagueURL.put(32, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=Swedish%20Superettan");
		leagueURL.put(33, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=Swedish%20Allsvenskan");
		leagueURL.put(34, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=Turkish%20Super%20Lig");
		leagueURL.put(35, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=Ukrainian%20Premier%20League");
		leagueURL.put(36, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=Uruguayan%20Primera%20Division");
		leagueURL.put(37, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=American%20NASL");
		leagueURL.put(38, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=American%20Major%20League%20Soccer");
		leagueURL.put(39, "http://thesportsdb.com/api/v1/json/1/search_all_teams.php?l=Welsh%20Premier%20League");
	}
	
	public void popula() throws JSONException{
		getDataTeam();
		getDataLeagues();
	}
	
	public void getDataLeagues() throws JSONException{
		
		final StringBuilder result = new StringBuilder();
		URL urlAll;
		HttpURLConnection urlConnection = null;
		
		try {
			urlAll = new URL("http://thesportsdb.com/api/v1/json/1/search_all_leagues.php?s=soccer");
			urlConnection = (HttpURLConnection) urlAll.openConnection();
			InputStream in = urlConnection.getInputStream();
			InputStreamReader isw = new InputStreamReader(in);
			
			
			int data = isw.read();
			int x = 0;
			while(data != -1) {
				char current = (char) data;
				data = isw.read();
				if(current == '[') {
					x = 1;
				}
				if(x != 0) {
					int j = 1;
					result.append(current);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				urlConnection.disconnect();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(result);
		
		generateJSONLeagues(new JSONArray(result.toString()));
		System.out.println(leagueURL);
	}
	
	public void generateJSONLeagues(JSONArray json) {
		
		try {
			for(int i = 0; i < json.length(); i++) {
				JSONObject obj = json.getJSONObject(i);
				leagueName = obj.getString("strLeague");
				model.addLeagues(new Leagues(leagueName));
			}
		} catch(Exception e) {
			//Handle
		}
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
