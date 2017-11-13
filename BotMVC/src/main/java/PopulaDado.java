import org.json.JSONException;

public abstract class PopulaDado {
	
	public static void populateTeam(Model model) throws JSONException {
		Connection conn = new Connection(model);
		conn.getDataTeam();
	}
	
	public static void populatePlayer(Model model) throws JSONException{
		Connection conn = new Connection(model);
		conn.getDataPlayer(conn.timeNome);
	}
	
	public static void populateLeague(Model model) throws JSONException{
		Connection conn = new Connection(model);
		conn.getDataLeagues();
	}
	
	public static void populaModel(Model model) throws JSONException {
		populateTeam(model);
		populatePlayer(model);
		populateLeague(model);
	}
}
