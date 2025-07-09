package connect4.views.graphics;

import java.util.EnumMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import connect4.controllers.PlayController;
import connect4.types.Color;
import connect4.views.graphics.commands.RedoCommand;
import connect4.views.graphics.commands.UndoCommand;
import connect4.views.graphics.commands.UndoMachinePlayerCommand;

public class TurnView extends PanelView {

    private PlayController playController;
    private Map<Color, ImageIcon> colors;
    private UndoCommand undoCommand;
    private RedoCommand redoCommand;

    public TurnView(PlayController playController) {
        assert (playController != null);
        this.playController = playController;
        this.colors = new EnumMap<>(Color.class);
        for (Color color : Color.values()) {
            String fileNamePrefix = "connect4\\src\\connect4\\views\\graphics\\assets\\";
            String fileNameInfix = color.toString().equals(" ") ? "White" : color.toString();
            String fileNameSufix = ".png";
            ImageIcon icon = new ImageIcon(fileNamePrefix + fileNameInfix + fileNameSufix);
            this.colors.put(color, icon);
        }
        this.write();
    }

    @Override
    public void write() {
        this.removeAll();
        ImageIcon activeIcon = this.colors.get(this.playController.getActiveColor());
        this.add(new JLabel(Message.TURN.toString()));
        this.add(new JLabel(activeIcon));
        JButton undo = new JButton("Undo Last Move");
        undo.addActionListener(e -> {
            this.undoCommand.execute();
        });
        undo.setEnabled(playController.undoable());
        JButton redo = new JButton("Redo Last Move");
        redo.addActionListener(e -> {
           this.redoCommand.execute();
        });
         redo.setEnabled(playController.redoable());
        this.add(undo);
        this.add(redo);

    }

    public void setUndoCommand(UndoCommand undoCommand) {
        assert (undoCommand != null);
        this.undoCommand = undoCommand;
    }

    public void setRedoComand(RedoCommand redoCommand) {
        assert (redoCommand != null);
        this.redoCommand = redoCommand;
    }

}
