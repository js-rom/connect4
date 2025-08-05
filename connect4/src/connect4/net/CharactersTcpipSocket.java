package connect4.net;

import java.io.IOException;

import connect4.types.Color;
import connect4.types.PlayerType;

public class CharactersTcpipSocket extends utils.net.CharactersTcpipSocket implements Operations {

    public void send(PlayerType playerType) {
        assert playerType != null : "Cannot send null PlayerType";
        this.send(playerType.name());
    }

    public void send(PlayerType[] playerTypes) {
        assert playerTypes != null : "Cannot send null PlayerType array";
        StringBuilder sb = new StringBuilder();
        final String SEPARATOR = ",";
        for (int i = 0; i < playerTypes.length; i++) {
            sb.append(playerTypes[i].name());
            if (i < playerTypes.length - 1) {
                sb.append(SEPARATOR);
            }
        }
        this.send(sb.toString());
    }

    public void send(Color color) {
        assert color != null : "Cannot send null Color";
        this.send(color.name());
    }

    public PlayerType receivePlayerType() throws IOException {
        return PlayerType.valueOf(this.receiveLine());
    }

    public PlayerType[] receivePlayerTypes() throws IOException {
        String[] playerTypes = this.receiveLine().split(",");
        PlayerType[] result = new PlayerType[playerTypes.length];
        for (int i = 0; i < playerTypes.length; i++) {
            result[i] = PlayerType.valueOf(playerTypes[i]);
        }
        return result;
    }

    public Color receiveColor() throws IOException {
        return Color.valueOf(this.receiveLine());
    }
}
