package models;

public interface PlayerVisitor {

    public void visit(UserPlayer userPlayer);
    public void visit(RandomMachinePlayer randomMachinePlayer);
}