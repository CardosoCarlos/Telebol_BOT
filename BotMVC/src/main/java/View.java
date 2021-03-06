import java.util.List;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ChatAction;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendChatAction;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import com.pengrad.telegrambot.response.SendResponse;

public class View implements Observer{

	
	TelegramBot bot = TelegramBotAdapter.build("326652376:AAGHzGef6TeR5J567XZNmO93ab2P_PWeNKg");

	//Object that receives messages
	GetUpdatesResponse updatesResponse;
	//Object that send responses
	SendResponse sendResponse;
	//Object that manage chat actions like "typing action"
	BaseResponse baseResponse;
			
	
	int queuesIndex=0;
	
	ControllerSearch controllerSearch; //Strategy Pattern -- connection View -> Controller
	
	boolean searchBehaviour = false;
	boolean leagues = false;
	public static String valorDig;
	
	private Model model;
	
	public View(Model model){
		this.model = model; 
	}
	
	public void setControllerSearch(ControllerSearch controllerSearch){ //Strategy Pattern
		this.controllerSearch = controllerSearch;
	}
	
	public void receiveUsersMessages() {

		
		
		//infinity loop
		while (true){
		
			//taking the Queue of Messages
			updatesResponse =  bot.execute(new GetUpdates().limit(100).offset(queuesIndex));
			
			//Queue of messages
			List<Update> updates = updatesResponse.updates();

			//taking each message in the Queue
			for (Update update : updates) {
				
				//updating queue's index
				queuesIndex = update.updateId()+1;
				
				if(this.searchBehaviour==true && leagues == false){
					this.callController(update);	
				}

				else if(update.message().text().toLowerCase().equals("leagues")){
					setControllerSearch(new ControllerSearchOnlyLeagues(model, this));
					sendResponse = bot.execute(new SendMessage(update.message().chat().id(),"Select id from your league... "));
					this.callController(update);
					this.setControllerSearch(new ControllerSearchLeagues(model, this));
					this.searchBehaviour = true;
//					this.leagues = true;
				}
//				else if(update.message().text().matches("\\d") && leagues == true) {
//					setControllerSearch(new ControllerSearchOnlyTeam(model, this));	
//					valorDig = (update.message().text());
//					this.callController(update);
//					this.searchBehaviour = true;
//					this.leagues = false;
//					System.out.println(valorDig);
//				}
				else if(update.message().text().toLowerCase().equals("team")){
					setControllerSearch(new ControllerSearchOnlyTeam(model, this));
					sendResponse = bot.execute(new SendMessage(update.message().chat().id(),"what's the team name?"));
					this.callController(update);
					setControllerSearch(new ControllerSearchTeam(model, this));
					this.searchBehaviour = true;
					
				}
				else if(update.message().text().toLowerCase().equals("player")){
					setControllerSearch(new ControllerSearchPlayer(model, this));
					sendResponse = bot.execute(new SendMessage(update.message().chat().id(),"what's the player name?"));
					this.searchBehaviour = true;
				}
				else {
					sendResponse = bot.execute(new SendMessage(update.message().chat().id(),"Type: \n Team \n Player \n Leagues"));
				}
				
				
				
			}

		}
		
		
	}
	
	
	public void callController(Update update){
		this.controllerSearch.search(update);
	}
	
	public void update(long chatId, String studentsData){
		sendResponse = bot.execute(new SendMessage(chatId, studentsData));
		this.searchBehaviour = false;
	}
	
	public void sendTypingMessage(Update update){
		baseResponse = bot.execute(new SendChatAction(update.message().chat().id(), ChatAction.typing.name()));
	}

}