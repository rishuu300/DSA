class Solution {
    private void generate(String current, int n, ArrayList<String> result) {
        if (current.length() == n) {
            result.add(current);
            return;
        }
        
        generate(current + "0", n, result);
        generate(current + "1", n, result);
    }
    
    public ArrayList<String> binstr(int n) {
        ArrayList<String> result = new ArrayList<>();
        generate("", n, result);
        return result;
    }
}
