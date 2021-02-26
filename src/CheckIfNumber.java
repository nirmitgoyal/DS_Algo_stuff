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

    public static final Map<String, List<String>> NEXT_STATES = new HashMap<>();

    public static final List<String> VALID_STATES = Arrays.asList(DIGIT1, DIGIT2, DIGIT3);

    private void init() {
        NEXT_STATES.put(BEGIN, Arrays.asList(NEGATIVE_SIGN1, DIGIT1));
        NEXT_STATES.put(NEGATIVE_SIGN1, Arrays.asList(DIGIT1, DOT));
        NEXT_STATES.put(DIGIT1, Arrays.asList(DIGIT1, DOT, E));
        NEXT_STATES.put(DOT, Arrays.asList(DIGIT2));
        NEXT_STATES.put(DIGIT2, Arrays.asList(DIGIT2, E));
        NEXT_STATES.put(NEGATIVE_SIGN2, Arrays.asList(DIGIT3));
        NEXT_STATES.put(DIGIT3, Arrays.asList(DIGIT3));
    }

    boolean checkIfNumber(String s) {
        init();
        String currState = BEGIN;

        for (Character c : s.toCharArray()) {
            boolean foundValidState = false;

            for (String nextState : NEXT_STATES.get(currState))
                if (isValidState(nextState, c)) {
                    foundValidState = true;
                    currState = nextState;
                    break;
                }

            if (!foundValidState)
                return false;
        }

        return VALID_STATES.contains(currState);
    }

    private boolean isValidState(String state, Character c) {
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
