package main;

import java.util.*;

/*
    841. Keys and Rooms

    There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0.
    Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.

    When you visit a room, you may find a set of distinct keys in it.
    Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.

    Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can visit all the rooms, or false otherwise.
 */
public class KeysAndRooms {
    public static void main (String[] args) {
        KeysAndRooms k = new KeysAndRooms();
        List<List<Integer>> rooms = Arrays.asList(Arrays.asList(1,3), Arrays.asList(3,0,1), Arrays.asList(2), Arrays.asList(0));
        System.out.println(k.canVisitAllRooms(rooms));
    }

    // We can carry the keys in a set.
    // When we unlock a door, we did not remove the key from the set
    // After we visited each room, we mark it as VISITED
    // We always start at room 0 -> index 0 -> we always have the key for index 0!
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        int visitCount = 0;
        Queue<Integer> roomsQueueIdx = new LinkedList<>();

        // Room 0 is always included and visited
        roomsQueueIdx.offer(0);
        visited.add(0);

        while (!roomsQueueIdx.isEmpty()) {
            int size = roomsQueueIdx.size();
            for (int i = 0 ; i < size ; i++) {

                // After we got the currRoomIdx, we want to get the key inside that room and mark the room as visited.
                // We only want the key to the room that has not been previously visited before.

                int currRoomIdx = roomsQueueIdx.poll();
                visited.add(currRoomIdx);
                visitCount++;

                for (int aKey : rooms.get(currRoomIdx)) {
                    if (!visited.contains(aKey) && aKey < rooms.size() && !roomsQueueIdx.contains(aKey)) {
                        roomsQueueIdx.offer(aKey);
                    }
                }

            }
        }

        return visitCount == rooms.size();
    }
}
