class TimeStamp {
    String value;
    int timestamp;

    TimeStamp(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}

class TimeMap {
    Map<String, List<TimeStamp>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, ignored -> new ArrayList<>()).add(new TimeStamp(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key))
            return "";
        String value = "";

        List<TimeStamp> ts = map.get(key);

        int low = 0;
        int high = ts.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (ts.get(mid).timestamp <= timestamp) {
                value = ts.get(mid).value;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return value;
    }
}
