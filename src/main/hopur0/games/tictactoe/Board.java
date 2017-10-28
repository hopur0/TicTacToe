package hopur0.games.tictactoe;

class Board {

    private final int BOARD_SIZE = 9;
    private Player[] state;

    public Board() {
        state = new Player[BOARD_SIZE];

        for (Player p: state) {
            System.out.println(p + " test");
        }
    }

    public void setTile(Player pl, int tile) {
        if (1 > tile || tile > BOARD_SIZE)
            throw new IllegalArgumentException("Picked tile not on board");
        else if (state[tile - 1] != null)
            throw new IllegalArgumentException("Tile is already occupied");
        else
            state[tile - 1] = pl;
    }

    public Player getTile(int tile) {
        if (1 > tile || tile > BOARD_SIZE)
            throw new IllegalArgumentException("Picked tile not on board");
        return state[tile - 1];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < state.length; i++) {
            if (state[i] == null) {
                sb.append('-');
            } else {
                sb.append(state[i].getSymbol());
            }

            if ((i + 1) % 3 == 0 && i != state.length - 1) {
                sb.append(System.lineSeparator());
            } else {
                sb.append(' ');
            }
        }

        return sb.toString();
    }

}
