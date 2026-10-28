class Union {
    int[] parent;
    int[] size;

    Union(int capacity) {
        this.parent = new int[capacity];
        this.size = new int[capacity];

        for (int i = 0; i < capacity; i++) {
            this.parent[i] = i;
            this.size[i] = 1;
        }
    }

    public int findParent(int x) {
        if (parent[x] != x) {
            parent[x] = findParent(parent[x]);
        }
        return parent[x];
    }

    public void merge(int x, int y) {
        int pOfX = findParent(x);
        int pOfY = findParent(y);

        if (pOfX == pOfY)
            return;

        if (size[pOfX] > size[pOfY]) {
            parent[pOfY] = pOfX;
            size[pOfX] += size[pOfY];
        } else {
            parent[pOfX] = pOfY;
            size[pOfY] += size[pOfX];
        }
    }
}


class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Union union = new Union(accounts.size());
        Map<String, Integer> emailToAccId = new HashMap<>();
        Map<Integer, List<String>> accIdToEmail = new HashMap<>();

        for(int i = 0; i < accounts.size(); i++){
            int accId = i;
            List<String> emails = accounts.get(i);
            for(int j = 1; j < emails.size(); j++){
                String email = emails.get(j);
                if(!emailToAccId.containsKey(email)){
                    emailToAccId.put(email, accId);
                }else{
                    union.merge(accId, emailToAccId.get(email));
                }
            }
        }

        for(Map.Entry<String, Integer> entry: emailToAccId.entrySet()){
            int leader = union.findParent(entry.getValue());
            accIdToEmail.computeIfAbsent(leader, k -> new ArrayList<>()).add(entry.getKey());
        }

        List<List<String>> result = new ArrayList<>();

        for(Map.Entry<Integer, List<String>> entry: accIdToEmail.entrySet()){
            String username = accounts.get(entry.getKey()).get(0);
            List<String> temp = new ArrayList<>();
            Collections.sort(entry.getValue());
            temp.add(username);
            temp.addAll(entry.getValue());
            result.add(temp);
        }
        return result;
    }
}