package racingcar;

import racingcar.model.RacingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private static final int DISTANCE_LIMIT = 10;

    private List<RacingCar> racingCars = new ArrayList<>();

    public RacingCars(String input) {
        setUpCarName(input);
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public List<RacingCar> getWinners() {
        return racingCars.stream().filter(racingCar -> racingCar.getDist() == getMaxDist()).collect(Collectors.toList());
    }

    public void runRound() {
        for (RacingCar racingCar : racingCars) {
            racingCar.tryMove(makeRandomDist());
        }
    }

    public void printRoundResult() {
        racingCars.stream().forEach(racingCar -> racingCar.printDist());
    }

    private void setUpCarName(String input) {
        String[] names = input.split(",");
        for (String name : names) {
            racingCars.add(new RacingCar(name));
        }
    }

    private int makeRandomDist() {
        return (int) (Math.random() * DISTANCE_LIMIT);
    }

    private int getMaxDist() {
        return racingCars.stream().mapToInt(RacingCar::getDist).max().orElse(0);
    }
}