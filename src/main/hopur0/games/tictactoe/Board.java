package hopur0.games.tictactoe;

class Board {

    private final int BOARD_SIZE = 9;
    private Player[] state;

    public Board() {
        state = new Player[BOARD_SIZE];
    }

    public void setTile(Player pl, int tile) {
        if (1 > tile || tile > BOARD_SIZE)
            throw new IllegalArgumentException("Picked tile not on board");
        else if (state[tile - 1] != null)
            throw new IllegalArgumentException("Tile is already occupied");
        state[tile - 1] = pl;
    }

    public Player getTile(int tile) {
        if (1 > tile || tile > BOARD_SIZE)
            throw new IllegalArgumentException("Picked tile not on board");
        return state[tile - 1];
    }

    public Player winner() {
        // Check horizontals
        if (state[0] != null && state[0] == state[1] && state[1] == state[2])
            return state[0];
        if (state[3] != null && state[3] == state[4] && state[4] == state[5])
            return state[3];
        if (state[6] != null && state[6] == state[7] && state[7] == state[8])
            return state[6];

        // Check verticals
        if (state[0] != null && state[0] == state[3] && state[3] == state[6])
            return state[0];
        if (state[1] != null && state[1] == state[4] && state[4] == state[7])
            return state[1];
        if (state[2] != null && state[2] == state[5] && state[5] == state[8])
            return state[2];

        // Check diagonals
        if (state[0] != null && state[0] == state[4] && state[4] == state[8])
            return state[0];
        if (state[2] != null && state[2] == state[4] && state[4] == state[6])
            return state[2];

        // No winner found
        return null;
    }

    public boolean full() {
        for (Player p: state) {
            if (p == null)
                return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < state.length; i++) {
            if (state[i] == null) {
                sb.append(i + 1);
            } else {
                sb.append(state[i].getSymbol());
            }

            if ((i + 1) % 3 == 0 && i != state.length - 1) {
                sb.append(System.lineSeparator());
            } else if (i != state.length - 1) {
                sb.append(' ');
            }
        }

        return sb.toString();
    }

}
