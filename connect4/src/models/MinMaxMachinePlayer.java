package models;

import types.Color;
import utils.Coordinate;

public class MinMaxMachinePlayer extends MachinePlayer {

    static private int MAX_STEPS = 4;
    static private int MAX_COST = 1;
    static private int OTHER_COST = 0;
    static private int MIN_COST = -1;

    public MinMaxMachinePlayer(Color color, Board board) {
        super(color, board);
    }

    public void accept(PlayerVisitor visitor) {
        visitor.visit(this);
    }

    public int getColumn() {
        int[] uncompletedColumns = this.getBoard().getUncompletedColumns();
        int bestColumn = uncompletedColumns[0];
        int maxCost = MinMaxMachinePlayer.MIN_COST;
        for (int column : uncompletedColumns) {
            this.getBoard().dropToken(column, this.getColor());
            int minCost = this.getMinCost(0);
            this.getBoard().removeTop(column);
            if (minCost > maxCost) {
                maxCost = minCost;
                bestColumn = column;
            }
        }
        // console.writeln(`Inteligentemente en la columna: ${bestColumn}`);
        return bestColumn;
    }

    private int getMinCost(int steps) {
        if (this.isEnd(steps)) {
            return this.getCost();
        }
        int minCost = MinMaxMachinePlayer.MAX_COST;
        for (int column : this.getBoard().getUncompletedColumns()) {
            this.getBoard().dropToken(column, this.getColor().getOpposite());
            int maxCost = this.getMaxCost(steps + 1);
            this.getBoard().removeTop(column);
            if (maxCost < minCost)
                minCost = maxCost;
        }
        return minCost;
    }

    private int getMaxCost(int steps) {
        if (this.isEnd(steps)) {
            return this.getCost();
        }
        int maxCost = MinMaxMachinePlayer.MIN_COST;
        for (int column : this.getBoard().getUncompletedColumns()) {
            this.getBoard().dropToken(column, this.getColor());
            int cost = this.getMinCost(steps + 1);
            this.getBoard().removeTop(column);
            if (cost > maxCost)
                maxCost = cost;
        }
        return maxCost;
    }

    private boolean isEnd(int steps) {
        return steps == MinMaxMachinePlayer.MAX_STEPS || this.getBoard().isFinished();
    }

    private int getCost() {

        if (this.getBoard().isWinner()) {
            if (this.getBoard().getLastDropColor() == this.getColor()) {
                return MinMaxMachinePlayer.MAX_COST;
            }
            return MinMaxMachinePlayer.MIN_COST;
        }
        return MinMaxMachinePlayer.OTHER_COST;
    }
}
