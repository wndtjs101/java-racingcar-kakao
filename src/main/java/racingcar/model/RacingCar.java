package racingcar.model;

public class RacingCar {
    static final int MIN_MOVABLE_NUMBER = 4;

    private final String name;
    private int dist;

    public RacingCar(String name) {
        this.name = name;
        this.dist = 0;
    }

    public String getName() {
        return name;
    }

    public int getDist() {
        return this.dist;
    }

    public void tryMove(int value) {
        if (isMove(value)) {
            dist += 1;
        }
    }

    private boolean isMove(int value) {
        return value >= MIN_MOVABLE_NUMBER;
    }

    public void printDist() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name).append(" : ");
        for (int i = 0; i < this.dist; i++) {
            stringBuilder.append("-");
        }
        System.out.println(stringBuilder.toString());
    }

}