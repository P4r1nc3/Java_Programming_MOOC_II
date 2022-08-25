
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        //MagicSquare square = new MagicSquare(size);
        MagicSquare magicSquare = new MagicSquare(size);

        int row = 0;
        int col = size / 2;
        magicSquare.placeValue(row, col, 1);
        for (int k = 2; k <= size * size; k++) {
            int currentRow = row;
            int currentColumn = col;
            row -= 1;
            col += 1;
            if (row < 0) {
                row = size - 1;
            }
            if (col > size - 1) {
                col = 0;
            }
            if (magicSquare.readValue(row, col) > 0) {
                row = currentRow + 1;
                col = currentColumn;
            }
            magicSquare.placeValue(row, col, k);
        }
        return magicSquare;
    }

}