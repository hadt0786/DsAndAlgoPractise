package Backtracking;

/*
You have n  tiles, where each tile has one letter tiles[i] printed on it.

        Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.



        Example 1:

        Input: tiles = "AAB"
        Output: 8
        Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
        Example 2:

        Input: tiles = "AAABBC"
        Output: 188
        Example 3:

        Input: tiles = "V"
        Output: 1


        Constraints:

        1 <= tiles.length <= 7
        tiles consists of uppercase English letters.
*/

import java.util.Arrays;

public class Letter_Tile_Possibilities_v1079 {
    int count = 0;

    public int numTilePossibilities(String tiles) {
        char[] tilesArray = tiles.toCharArray() ;
        Arrays.sort(tilesArray);
        solve(tilesArray, new boolean[tilesArray.length]);
        return count - 1;
    }

    void solve ( char[] tiles, boolean visited[]) {
        count++;
        for(int i =0 ;i<tiles.length ; i++ ) {
            if(visited[i] || (i>0 && tiles[i]==tiles[i-1] && !visited[i-1])) continue;
            visited[i] = true;
            solve(tiles, visited);
            visited[i] = false;
        }
    }
}
