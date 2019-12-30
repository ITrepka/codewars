package exercises;

import java.util.*;

public class BattleField {
    private static final int CROSSED_OUT = -1;

    public static boolean fieldValidator(int[][] field) {
        Map<String, Integer> shipQuantityMap = new HashMap<>();
        shipQuantityMap.put("battleShip", 1);
        shipQuantityMap.put("cruisers", 2);
        shipQuantityMap.put("destroyers", 3);
        shipQuantityMap.put("submarines", 4);

        try {
            checkBoardElementsSum(field);
            validPlacementOfShips(field, shipQuantityMap);
        } catch (InvalidBoardException e) {
            return false;
        }

        return shipQuantityMap.get("submarines") == 0 && shipQuantityMap.get("destroyers") == 0
                && shipQuantityMap.get("cruisers") == 0 && shipQuantityMap.get("battleShip") == 0;
    }

    private static void checkBoardElementsSum(int[][] field) throws InvalidBoardException {
        int fieldsSum = Arrays.stream(field)
                .flatMapToInt(Arrays::stream)
                .reduce(0, Integer::sum);
        if (fieldsSum != 20) {
            throw new InvalidBoardException();
        }
    }

    private static void validPlacementOfShips(int[][] field, Map<String, Integer> shipQuantityMap) throws InvalidBoardException {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col] == 1) {
                    int numberOfShipParts = validShipArea(field, row, col);
                    crossShip(numberOfShipParts, shipQuantityMap);
                }
            }
        }
    }

    private static int validShipArea(int[][] field, int row, int col) throws InvalidBoardException {
        if (horizontalRightFieldBusy(row, col, field) && vertitalDownFieldBusy(row, col, field)) {
            throw new InvalidBoardException();
        }

        validSlants(row, col, field);
        field[row][col] = CROSSED_OUT;
        //horizontalValidation
        int shipFields = checkHorizontal(row, col, field);
        //vertical validation
        if (shipFields == 1) {
            shipFields = checkVertical(row, col, field);
        }

        return shipFields;
    }

    private static void crossShip(int shipFields, Map<String, Integer> shipQuantityMap) throws InvalidBoardException {
        switch (shipFields) {
            case 1:
                shipQuantityMap.put("submarines", shipQuantityMap.get("submarines") - 1);
                break;
            case 2:
                shipQuantityMap.put("destroyers", shipQuantityMap.get("destroyers") - 1);
                break;
            case 3:
                shipQuantityMap.put("cruisers", shipQuantityMap.get("cruisers") - 1);
                break;
            case 4:
                shipQuantityMap.put("battleShip", shipQuantityMap.get("battleShip") - 1);
                break;
            default:
                throw new InvalidBoardException();
        }
    }

    private static int checkVertical(int row, int col, int[][] field) throws InvalidBoardException {
        int shipParts = 1;
        while (row < field.length) {
            if (vertitalDownFieldBusy(row, col, field)) {
                shipParts++;
                if (horizontalRightFieldBusy(row, col, field)) {
                    throw new InvalidBoardException();
                }
                row++;
                validSlants(row, col, field);
                field[row][col] = CROSSED_OUT;
            } else {
                return shipParts;
            }
        }
        return shipParts;
    }

    private static int checkHorizontal(int row, int col, int[][] field) throws InvalidBoardException {
        int shipParts = 1;
        while (col < field[row].length) {
            if (horizontalRightFieldBusy(row, col, field)) {
                shipParts++;
                if (vertitalDownFieldBusy(row, col, field)) {
                    throw new InvalidBoardException();
                }
                col++;
                validSlants(row, col, field);
                field[row][col] = CROSSED_OUT;
            } else {
                return shipParts;
            }
        }
        return shipParts;
    }

    private static boolean vertitalDownFieldBusy(int row, int col, int[][] field) {
        return row == field.length - 1 ? false : field[row + 1][col] == 1;
    }

    private static boolean horizontalRightFieldBusy(int row, int col, int[][] field) {
        return col == field[row].length - 1 ? false : field[row][col + 1] == 1;
    }


    private static void validSlants(int row, int column, int[][] field) throws InvalidBoardException {
        if (row > 0 && column > 0) {
            if (field[row - 1][column - 1] != 0) throw new InvalidBoardException();
        }
        if (row < field.length - 1 && column > 0) {
            if (field[row + 1][column - 1] != 0) throw new InvalidBoardException();
        }
        if (column < field.length - 1 && row > 0) {
            if (field[row - 1][column + 1] != 0) throw new InvalidBoardException();
        }
        if (row < field.length - 1 && column < field.length - 1) {
            if (field[row + 1][column + 1] != 0) throw new InvalidBoardException();
        }
    }

    private static class InvalidBoardException extends Exception {
    }
}
