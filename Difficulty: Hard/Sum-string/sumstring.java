class Solution {
    public boolean isSumString(String s) {
        int n = s.length();
        
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String s1 = s.substring(0, i);
                String s2 = s.substring(i, j);

                if (isValid(s1) && isValid(s2)) {
                    if (check(s1, s2, s.substring(j))) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean check(String s1, String s2, String rest) {
        String sum = stringAdd(s1, s2);

        if (!rest.startsWith(sum)) return false;
        if (rest.equals(sum)) return true;

        return check(s2, sum, rest.substring(sum.length()));
    }

    private boolean isValid(String s) {
        return !(s.length() > 1 && s.startsWith("0"));
    }

    private String stringAdd(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int d1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int d2 = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int sum = d1 + d2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }

        return sb.reverse().toString();
    }
}