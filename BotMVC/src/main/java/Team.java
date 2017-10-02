import java.util.LinkedList;
import java.util.List;

public class Team {

	private String name;
	private List<Player> players = new LinkedList<>();
	
	public Team(String name) {
		this.name = name;
	}
	
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlayers() {
		String allPlayers = "";
		for(Player player: players)
			allPlayers += "\n" +  player;
		return allPlayers;
	}
	
	public Player searchPlayer(String nome) {
		for(Player player: players) {
			if(player.getNome().toLowerCase().equals(nome.toLowerCase())) {
				return player;
			}
		}
		return null;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
}
