
public abstract class PopulaDado {
	
	
	public static void populateTeam(Model model) {
		model.addTeam(new Team("Corinthians"));
		model.addTeam(new Team("Santos"));
		model.addTeam(new Team("Palmeiras"));
	}
	
	public static void populatePlayer(Model model) {
		model.addPlayer("Corinthians", new Player("Jo", "Atacante"));
		model.addPlayer("Corinthians", new Player("Cassio", "Goleiro"));
		model.addPlayer("Corinthians", new Player("Jadshow", "Meia"));
		
		model.addPlayer("Palmeiras", new Player("Batistuta", "Atacante"));
		model.addPlayer("Palmeiras", new Player("Marcos", "Goleiro"));
		model.addPlayer("Palmeiras", new Player("Jesus", "Meia"));
		
		model.addPlayer("Santos", new Player("Robinho", "Atacante"));
		model.addPlayer("Santos", new Player("Edinho Matador", "Goleiro"));
		model.addPlayer("Santos", new Player("Pele", "Meia"));
	}
	
	public static void populaModel(Model model) {
		populateTeam(model);
		populatePlayer(model);
	}
	
}
