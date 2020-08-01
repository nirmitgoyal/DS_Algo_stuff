import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckIfNumber {
    public static final String BEGIN = "BEGIN";
    public static final String NEGATIVE_SIGN1 = "NEGATIVE_SIGN1";
    public static final String DIGIT1 = "DIGIT1";
    public static final String DOT = "DOT";
    public static final String DIGIT2 = "DIGIT2";
    public static final String E = "E";
    public static final String NEGATIVE_SIGN2 = "NEGATIVE_SIGN2";
    public static final String DIGIT3 = "DIGIT3";

    public static final Map<String, List<String>> nextStates = new HashMap<>();

    public static final List<String> validStates = Arrays.asList(DIGIT1, DIGIT2, DIGIT3, );

    void init() {
        nextStates.put(BEGIN, Arrays.asList(NEGATIVE_SIGN1, DIGIT1));
        nextStates.put(NEGATIVE_SIGN1, Arrays.asList(DIGIT1, DOT));
        nextStates.put(DIGIT1, Arrays.asList(DIGIT1, DOT, E));
        nextStates.put(DOT, Arrays.asList(DIGIT2));
        nextStates.put(DIGIT2, Arrays.asList(DIGIT2, E));
        nextStates.put(NEGATIVE_SIGN2, Arrays.asList(DIGIT3));
        nextStates.put(DIGIT3, Arrays.asList(DIGIT3));
    }

    boolean checkIfNumber(String s) {
        init();
        String state = BEGIN;

        for (Character c : s) {
            boolean isANextState = false;
            for (String nextState : nextStates.get(state)) {
                if (isValidState(c, nextState)) {
                    state = nextState;
                    isANextState = true;
                    break;
                }
            }
            if (!isANextState)
                return false;
        }

        return validStates.contains(state);
    }

    private boolean isValidState(Character c, String state) {
        switch (state) {
            case NEGATIVE_SIGN1:
            case NEGATIVE_SIGN2:
                return c == '-';
            case DIGIT1:
            case DIGIT2:
            case DIGIT3:
                return Character.isDigit(c);
            case DOT:
                return c == '.';
            case E:
                return c == 'e';
        }
//        if (state.equals(NEGATIVE_SIGN1) || state.equals(NEGATIVE_SIGN2)) {
//            return c == '-';
//        } else if (state.equals(DIGIT1) || state.equals(DIGIT2) || state.equals(DIGIT3)) {
//            return Character.isDigit(c);
//        } else if (state.equals(DOT)) {
//            return c == '.';
//        } else if (state.equals(E)) {
//            return c == 'e';
//        }
    }
}
