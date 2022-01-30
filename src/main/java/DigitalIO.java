import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

public class DigitalIO {
    private TreeMap<Long, Integer> packet = new TreeMap<>();
    public LinkedList<Long> packetKey = new LinkedList<>();
    private TreeMap<Long, Integer> answer = new TreeMap<>();
    Random randomValue = new Random();
    Random randomTime = new Random();

    int lowerBoundary = 5000;
    int upperBoundary = 10000;
    int time = randomTime.nextInt(upperBoundary-lowerBoundary) + lowerBoundary;

    public void gatheringData() {

        long timestamp = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        int inputValue = randomValue.nextInt(2);

        packet.put(timestamp, inputValue);

        System.out.println("Data gathered:");

        for (Map.Entry<Long, Integer> signal : packet.entrySet()) {
            System.out.println(signal.getKey() + ": " + signal.getValue());
        }

        System.out.println();

        try {
            Thread.sleep(time);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void answerShow() {

        packetKey.addAll(packet.keySet());

        for (int i = 0; i < packet.size(); i++) {
            if (answer.size() % 2 == 0 && packet.get(packetKey.get(i)) == 1) {
                answer.put(packetKey.get(i), 1);
            } else if (answer.size() != 0 && answer.size() % 2 != 0 && packet.get(packetKey.get(i)) == 0) {
                answer.put(packetKey.get(i), 0);
            }
        }

        System.out.println("Answer is:");

        for (Entry<Long, Integer> ans : answer.entrySet()) {
            System.out.println(ans.getKey() + ": " + ans.getValue());
        }
        System.out.println();
        System.out.println("Press 3 to exit.");
    }
}
