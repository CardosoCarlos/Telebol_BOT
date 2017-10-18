import org.json.JSONException;

public class Main {

	private static Model model;
	
	public static void main(String[] args) throws JSONException {
		
		model = Model.getInstance();
		
		Connection conn = new Connection(model);
		conn.popula();
		View view = new View(model);
		model.registerObserver(view); //connection Model -> View
		view.receiveUsersMessages();

	}
}