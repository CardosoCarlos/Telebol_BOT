import org.json.JSONException;

public abstract class PopulaDado {
	
	public static void populateTeam(Model model) throws JSONException {
		Connection conn = new Connection(model);
//		model.addTeam(new Team("Corinthians"));
//		model.addTeam(new Team("Santos"));
//		model.addTeam(new Team("Palmeiras"));
//		model.addTeam(new Team(conn.getDataTeam().toString()));
		conn.getDataTeam();
	}
	
	public static void populatePlayer(Model model) throws JSONException{
		Connection conn = new Connection(model);
//		model.addPlayer("Corinthians", new Player("Jo", "Atacante"));
//		model.addPlayer("Corinthians", new Player("Cassio", "Goleiro"));
//		model.addPlayer("Corinthians", new Player("Jadshow", "Meia"));
//		
//		model.addPlayer("Palmeiras", new Player("Bastituta", "Atacante"));
//		model.addPlayer("Palmeiras", new Player("Marcos", "Goleiro"));
//		model.addPlayer("Palmeiras", new Player("Jesus", "Meia"));
//		
//		model.addPlayer("Santos", new Player("Robinho", "Atacante"));
//		model.addPlayer("Santos", new Player("Edinho Matador", "Goleiro"));
//		model.addPlayer("Santos", new Player("Pele", "Atacante"));
		conn.getDataPlayer(conn.timeNome);
	}
	
	public static void populaModel(Model model) throws JSONException {
		populateTeam(model);
		populatePlayer(model);
	}
}
