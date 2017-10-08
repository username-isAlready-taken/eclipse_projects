package gamestates;


public class GameStateManager {

	private GameStates currentStateID;
	private State currentState;
	
	public GameStateManager() {
		currentStateID = GameStates.MENUSTATE;
		setState(new MenuState());
	}
	
	public void switchState(GameStates id) {
		if(currentStateID == id)
			return;
		currentStateID = id;
		if(currentStateID == GameStates.MENUSTATE)
			setState(new MenuState());
		else if(currentStateID == GameStates.SETTINGSSTATE)
			setState(new MenuState());
		else if(currentStateID == GameStates.PLAYSTATE)
			setState(new PlayState());
		else if(currentStateID == GameStates.EXITSTATE)
			setState(new ExitState());
		System.out.println("state switched to "+currentStateID);
	}
	
	public void update() {
		currentState.update();
	}

	public void render() {
		currentState.render();
	}

	public State getState() {
		return currentState;
	}

	private void setState(State state) {
		currentState = null;
		this.currentState = state;
	}
}
