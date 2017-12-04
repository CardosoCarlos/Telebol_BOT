import com.pengrad.telegrambot.model.Update;

public class ControllerSearchOnlyLeagues implements ControllerSearch {

	private Model model;
	private View view;
	
	public ControllerSearchOnlyLeagues(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	@Override
	public void search(Update update) {
		view.sendTypingMessage(update);
		model.searchOnlyLeagues(update);
	}

}
