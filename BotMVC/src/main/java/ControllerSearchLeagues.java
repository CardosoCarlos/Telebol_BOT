import com.pengrad.telegrambot.model.Update;

public class ControllerSearchLeagues implements ControllerSearch{
	
	private Model model;
	private View view;
	
	public ControllerSearchLeagues(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	public void search(Update update) {
		view.sendTypingMessage(update);
		model.searchLeagues(update);
	}
}
