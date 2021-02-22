public class Dominos {

    String fallDominos(String string) {
        int n = string.length();
        char[] s = string.toCharArray();

        int[] forces = new int[n]; //0s
        int force = 0;

        for (int i = 0; i < n; i++) {
            if (s[i] == 'R')
                force = n;
            else if (s[i] == 'L')
                force = 0;
            else
                force = Math.max(force - 1, 0);

            forces[i] += force;
        }

        force = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s[i] == 'L')
                force = n;
            else if (s[i] == 'R')
                force = 0;
            else
                force = Math.max(force - 1, 0);

            forces[i] -= force;
        }

        String result = "";
        for (int i = 0; i < n; i++) {
            if (forces[i] < 0)
                result += 'L';
            else if (forces[i] > 0)
                result += 'R';
            else
                result += '|';
        }

        return result;
    }
}
