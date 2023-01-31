public class Field {
    public int fieldWidth = 10;
    public int fieldHeight = 10;
    public int mineCount = 10;
    char[][] field;
    public void mineGen(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 10; j++) {
                field[i][j]=0;
            }
        }

    }
}
