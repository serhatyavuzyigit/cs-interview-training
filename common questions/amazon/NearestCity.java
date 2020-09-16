// https://leetcode.com/discuss/interview-question/808374/
import java.util.*;

public class NearestCity {

    private static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return x + " " + y ;
        }
    }

    public static void main(String[] args) {
        String [] cities = {"c1", "c2", "c3"};
        int [] xCoords = {3, 2, 1};
        int [] yCoords = {3, 2, 3};

        String [] queries = {"c1", "c2", "c3"};

        Map<Integer, List<String>> xCoordMap = new HashMap<>();
        Map<Integer, List<String>> yCoordMap = new HashMap<>();
        Map<String, Pair> cityMap = new HashMap<>();

        for(int i=0; i<xCoords.length; i++) {
            int x = xCoords[i];
            int y = yCoords[i];
            String city = cities[i];
            cityMap.put(city, new Pair(x, y));
            if(xCoordMap.containsKey(x)) {
                List<String> val = xCoordMap.get(x);
                val.add(city);
                xCoordMap.replace(x, val);
            } else {
                List<String> val = new ArrayList<>();
                val.add(city);
                xCoordMap.put(x, val);
            }
            if(yCoordMap.containsKey(y)) {
                List<String> val = yCoordMap.get(y);
                val.add(city);
                yCoordMap.replace(y, val);
            } else {
                List<String> val = new ArrayList<>();
                val.add(city);
                yCoordMap.put(x, val);
            }
        }

        System.out.println(xCoordMap);
        System.out.println(yCoordMap);
        System.out.println(cityMap);

        String [] ans = solve(queries, xCoordMap, yCoordMap, cityMap);
        for(String s: ans)
            System.out.println(s);

    }

    private static String[] solve(String[] queries, Map<Integer, List<String>> xCoordMap,
                                  Map<Integer, List<String>> yCoordMap, Map<String, Pair> cityMap) {

        String [] result = new String[queries.length];
        int ind = 0;
        for(String city: queries) {
            int x = cityMap.get(city).x;
            int y = cityMap.get(city).y;

            List<String> sharedXCities = xCoordMap.get(x);
            List<String> sharedYCities = yCoordMap.get(y);
            if(sharedXCities.size() == 1 && sharedYCities.size() == 1)
                result[ind] = "None";
            else {
                double dist = Double.MAX_VALUE;
                // look for x first
                for(int i=0; i<sharedXCities.size(); i++) {
                    if(!city.equals(sharedXCities.get(i))) {
                        int newX = cityMap.get(sharedXCities.get(i)).x;
                        int newY = cityMap.get(sharedXCities.get(i)).y;
                        double d = computeDistance(x, newX, y, newY);
                        if(dist > d) {
                            result[ind] = sharedXCities.get(i);
                            dist = d;
                        }
                    }
                }
                // look y
                for(int i=0; i<sharedYCities.size(); i++) {
                    if(!city.equals(sharedYCities.get(i))) {
                        int newX = cityMap.get(sharedYCities.get(i)).x;
                        int newY = cityMap.get(sharedYCities.get(i)).y;
                        double d = computeDistance(x, newX, y, newY);
                        if(dist > d) {
                            result[ind] = sharedYCities.get(i);
                            dist = d;
                        }
                    }

                }
            }
            ind++;
        }


        return result;
    }

    private static double computeDistance(int x, int newX, int y, int newY) {
        return Math.sqrt(Math.pow(x-newX, 2) + Math.pow(y-newY, 2));
    }


}
