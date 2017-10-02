import com.pengrad.telegrambot.model.Update;

public class ControllerSearchTeam implements ControllerSearch{
	
	
	private Model model;
	private View view;
	
	public ControllerSearchTeam(Model model, View view){
		this.model = model; //connection Controller -> Model
		this.view = view; //connection Controller -> View
	}
	
	public void search(Update update){
		view.sendTypingMessage(update);
		model.searchTeam(update);
	}

}
