package simplejavatexteditor;

import javax.swing.*;

public class ClearCommand implements Command {
    private JTextArea textArea;

    public ClearCommand(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void execute() {
        textArea.setText("");
    }
}
