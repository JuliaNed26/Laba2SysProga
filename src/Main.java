import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args)
    {
        String filePath = "C:\\Users\\nedav\\IdeaProjects\\Laba2\\in.txt";
        List<Character> alphabet = new ArrayList<Character>();
        List<Integer> states = new ArrayList<Integer>();
        List<Integer> finalStates = new ArrayList<Integer>();
        List<Transition> transitions = new ArrayList<Transition>();

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            int symbCount = Integer.parseInt(reader.readLine());
            int statesCount = Integer.parseInt(reader.readLine());
            String[] finalStatesLine = reader.readLine().split(" ");
            for(int i = 1; i <= Integer.parseInt(finalStatesLine[0]); i++)
            {
                finalStates.add(Integer.parseInt(finalStatesLine[i]));
            }
            String transitionLine = reader.readLine();
            while(transitionLine != null)
            {
                String[] transitionLineSplitted = transitionLine.split(" ");
                if(!states.contains(Integer.parseInt(transitionLineSplitted[0])))
                {
                    states.add(Integer.parseInt(transitionLineSplitted[0]));
                }
                if(!alphabet.contains(transitionLineSplitted[1]))
                {
                    alphabet.add(transitionLineSplitted[1].charAt(0));
                }
                if(!states.contains(Integer.parseInt(transitionLineSplitted[2])))
                {
                    states.add(Integer.parseInt(transitionLineSplitted[2]));
                }
                transitions.add(new Transition(Integer.parseInt(transitionLineSplitted[0]),
                        transitionLineSplitted[1].charAt(0), Integer.parseInt(transitionLineSplitted[2])));
                transitionLine = reader.readLine();
            }

            AuthomatWithNotPeriodicalWords authomat = new AuthomatWithNotPeriodicalWords(alphabet,states,finalStates,transitions);

            for(var word : authomat.notPeriodicalWords)
            {
                System.out.println(word);
            }
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("exception occured");
        }
        catch (IOException ex)
        {
            System.out.println("exception occured");
        }

    }

}