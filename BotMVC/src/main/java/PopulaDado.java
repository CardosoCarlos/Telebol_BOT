import org.json.JSONException;

public abstract class PopulaDado {
	
	public static void populateTeam(Model model, View view) throws JSONException {
		Connection conn = new Connection(model, view);
//		conn.getDataTeam("arsenal");
	}
	
	public static void populatePlayer(Model model, View view) throws JSONException{
		Connection conn = new Connection(model, view);
		conn.getDataPlayer(conn.timeNome);
	}
	
	public static void populateLeague(Model model, View view) throws JSONException{
		Connection conn = new Connection(model, view);
		conn.getDataLeagues();
	}
	
	public static void populaModel(Model model, View view) throws JSONException {
		populateTeam(model, view);
		populatePlayer(model, view);
		populateLeague(model, view);
	}
}
