package simplejavatexteditor;

import javax.swing.JTextArea;

public class PreAppendDecorator extends TextEditorDecorator {
    private String message;

    public PreAppendDecorator(TextEditorOperation editorOperation, String message) {
        super(editorOperation);
        this.message = message;
    }

    @Override
    public void execute(JTextArea textArea) {
        textArea.append(message);
        super.execute(textArea);
    }
}
