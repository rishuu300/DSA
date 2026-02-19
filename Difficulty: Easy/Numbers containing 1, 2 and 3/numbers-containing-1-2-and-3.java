class Solution {
    public boolean check(int num) {
        while (num > 0) {
            if (num % 10 == 1 || num % 10 == 2 || num % 10 == 3) {
                num /= 10;
            } else {
                return false;
            }
        }
        return true;
    }
    
    public ArrayList<Integer> filterByDigits(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int num : arr) {
            if (check(num)) {
                list.add(num);
            }
        }

        return list;
    }
}
