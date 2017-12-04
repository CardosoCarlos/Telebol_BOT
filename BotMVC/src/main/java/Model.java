import java.util.LinkedList;
import java.util.List;

import com.pengrad.telegrambot.model.Update;

public class Model implements Subject{
	
	private Connection con;

	private List<Observer> observers = new LinkedList<Observer>();

	private List<Team> teams = new LinkedList<>();
	
	private List<Leagues> leagues = new LinkedList<>();
	
	private List<Team> teamLeague = new LinkedList<>();

	private static Model uniqueInstance;

	private Model(){}

	public static Model getInstance(){
		if(uniqueInstance == null){
			uniqueInstance = new Model();
		}
		return uniqueInstance;
	}
	
	public void registerCon(Connection con) {
		this.con = con;
	}

	public void registerObserver(Observer observer){
		observers.add(observer);
	}

	public void notifyObservers(long chatId, String studentsData){
		for(Observer observer:observers){
			observer.update(chatId, studentsData);
		}
	}
	
	public void searchLeagues(Update update) {
		teamLeague.clear();
		con.getDataLeaguesUmSo(con.leagueURL.get(update.message().text()));
		String data = "";
		for(Team team: teamLeague) {
			data += team.getName() + "\n";
		}
		this.notifyObservers(update.message().chat().id(), data);
	}
	
	public void searchOnlyLeagues(Update update) {
		String leaguesData = "";
		for(Leagues league: leagues) {
			leaguesData += league.getName() + "\n";
		}
		this.notifyObservers(update.message().chat().id(), leaguesData);
	}
	
	public void searchTeam(Update update){
		con.getDataTeam(update.message().text());
		String teamData = null;
		for(Team team: teams){
			if(team.getName().equals(update.message().text())){
				teamData = team.getName() + " " + team.getPlayers();
			}
		}

		if(teamData != null){
			this.notifyObservers(update.message().chat().id(), teamData);
		} else {
			this.notifyObservers(update.message().chat().id(), "Team not found");
		}

	}

	public void searchOnlyTeam(Update update) {
		String teamData = "";
		for(Team team: teams) {
			teamData += team.getName() + "\n";
//			System.out.println(teams.size());
//			System.out.println(team.getName());
		}
		
		this.notifyObservers(update.message().chat().id(), teamData);

	}

	public void searchPlayer(Update update) {
		String playerData = null;
		for(Team team: teams) {
			Player p = team.searchPlayer(update.message().text());
			if(p != null) {
				playerData = p.toString() + "\n";
				playerData += "Time: " +  team.getName();
			}
		}
		if(playerData != null)
			this.notifyObservers(update.message().chat().id(), playerData);
		else
			this.notifyObservers(update.message().chat().id(), "Player not found");

	}
	
	public void addLeagues(Leagues league) {
		leagues.add(league);
	}
	
	public void addTeam(Team team) {
		teams.add(team);
	}
	
	public void addPlayer(String time, Player player) {
		for(Team team: teams)
			if(team.getName().toLowerCase().equals(time.toLowerCase()))
				team.addPlayer(player);
	}

	public void setTeamLeague(Team team) {
		this.teamLeague.add(team);
	}

}
