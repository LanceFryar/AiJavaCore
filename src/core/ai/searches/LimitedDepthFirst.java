package core.ai.searches;

import core.ai.Enviroment;
import core.ai.State;

public class LimitedDepthFirst extends DepthFirst{
    
    private int limit;
    
    public LimitedDepthFirst(Enviroment enviroment, int limit){
        super(enviroment);
        this.limit=limit;
    }
    
    @Override
    public State searchFinalState() {
        setStartTime();
        while (!currentState.equals(finalState) || getPathSize(currentState)>limit) {
            updateQueueList(getChilds(currentState));
            markStateAsVisited(currentState);
            updateCurrentState();
        }
        setFinishTime();
        return currentState;
    }
    
}
