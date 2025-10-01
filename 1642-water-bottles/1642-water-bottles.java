class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles;
        int empty = numBottles;
        while(empty >= numExchange) {
            int newBottles = empty / numExchange;
            result += newBottles;
            empty = empty % numExchange + newBottles;
        }
        return result;
    }
}