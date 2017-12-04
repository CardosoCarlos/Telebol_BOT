import org.json.JSONException;

public class Main {

	private static Model model;
	private static View view;
	
	public static void main(String[] args) throws JSONException {
		
		model = Model.getInstance();
		
		Connection conn = new Connection(model, view);
		conn.popula();
		conn.populaMap();
		View view = new View(model);
		model.registerObserver(view); //connection Model -> View
		model.registerCon(conn);
		view.receiveUsersMessages();

	}
}