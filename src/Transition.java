public class Transition
{
    public int startState;
    public char symbol;
    public int resultState;

    public Transition(int startState, char symbol, int resultState)
    {
        this.startState = startState;
        this.symbol = symbol;
        this.resultState = resultState;
    }
}
