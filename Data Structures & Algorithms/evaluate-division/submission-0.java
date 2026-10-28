class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> equationGraph = new HashMap<>();
        double[] result = new double[queries.size()];
        int index = 0;

        for(int i = 0; i < equations.size(); i++){
            double val = values[i];
            String num = equations.get(i).get(0);
            String denom = equations.get(i).get(1);

            equationGraph.computeIfAbsent(num, value -> new HashMap<>()).put(denom, val);
            equationGraph.computeIfAbsent(denom, value -> new HashMap<>()).put(num, 1.0 / val);
        }

        for(List<String> query: queries){
            String q1 = query.get(0);
            String q2 = query.get(1);

            if(!equationGraph.containsKey(q1) || !equationGraph.containsKey(q2)){
                result[index++] = -1.0;
            }else if(q1.equals(q2)){
                result[index++] = 1.0;
            }else{
                HashSet<String> visited = new HashSet<>();
                result[index++] = dfs(equationGraph, 1.0, q1, q2, visited);
            }
        }

        return result;
    }

    public double dfs(HashMap<String, HashMap<String, Double>> equationGraph, double result, String source, String target, HashSet<String> visited){
        if(source.equals(target)){
            return result;
        }

        visited.add(source);

        for(Map.Entry<String, Double> entry: equationGraph.get(source).entrySet()){
            String key = entry.getKey();
            Double weight = entry.getValue();
            if(!visited.contains(key)){
                double accumulated = dfs(equationGraph, result * weight, key, target, visited);
                if(accumulated != -1.0){
                    return accumulated;
                }
            }
        }

        return -1.0;
    }



}