import java.util.*;

public final class AuthomatWithNotPeriodicalWords
{
    List<Character> alphabet;
    List<Integer> states;
    List<Integer> finalStates;
    List<Transition> transitions;
    public List<String> notPeriodicalWords;

    public AuthomatWithNotPeriodicalWords(List<Character> alphabet, List<Integer> states,
                                          List<Integer> finalStates, List<Transition> transitions)
    {
        this.alphabet = alphabet;
        this.states = states;
        this.finalStates = finalStates;
        this.transitions = transitions;
        notPeriodicalWords = new ArrayList<String>();
        FillAllNotPeriodicalWordsRecursively(this.transitions.get(0).startState,"");
    }
    void FillAllNotPeriodicalWordsRecursively(int curState, String word)
    {
        if(finalStates.contains(curState))
        {
            notPeriodicalWords.add(word);
        }

        List<Transition> curStateTransitions = transitions.stream()
                .filter(transition -> transition.startState == curState).toList();

        for(var transition : curStateTransitions)
        {
            if (IsWordWithSymbolAppropriate(transition.symbol, word))
            {
                FillAllNotPeriodicalWordsRecursively(transition.resultState, word + transition.symbol);
            }
        }

    }

    Boolean IsWordWithSymbolAppropriate(Character symbol, String word)
    {
        int lastIndOfTransSymbol = word.lastIndexOf(symbol);

        if (lastIndOfTransSymbol == -1) return true;

        String substrToCheck = word.length() == lastIndOfTransSymbol + 1 ? symbol.toString()
                : word.substring(lastIndOfTransSymbol + 1) + symbol;

        return lastIndOfTransSymbol - substrToCheck.length() + 1 < 0 ||
                !word.substring(lastIndOfTransSymbol - substrToCheck.length() + 1, lastIndOfTransSymbol + 1).equals(substrToCheck);
    }
}
