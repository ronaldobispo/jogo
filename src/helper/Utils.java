package helper;

import javax.swing.*;

public class Utils {

    private static JLabel centerLabel(String pMessage) {
        JLabel label = new JLabel(pMessage);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }

    static public int showMessage(String pMessage, boolean pCenterText, int pMessageType) {
        Object[] options = { "Ok"};
        Object message = pCenterText ? centerLabel(pMessage) : pMessage;
        return JOptionPane.showOptionDialog(null, message, "Jogo Gourmet", JOptionPane.DEFAULT_OPTION, pMessageType, null, options, options[0]);
    }

    static public boolean showConfirmMessage(String pMessage) {
        Object[] options = { "Sim", "Não"};
        return JOptionPane.showOptionDialog(null, pMessage, "Cofirm", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == 0;
    }

    static public String showInputMessage(String pMessage, String pTitle) {
        String result = "";

        while (result == "") {
            result = JOptionPane.showInputDialog(null, pMessage, pTitle, 3);
        }

        return result;
    }
}
