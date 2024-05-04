package simplejavatexteditor;

import javax.swing.JTextArea;

public abstract class TextEditorDecorator implements TextEditorOperation {
    protected TextEditorOperation editorOperation;

    public TextEditorDecorator(TextEditorOperation editorOperation) {
        this.editorOperation = editorOperation;
    }

    @Override
    public void execute(JTextArea textArea) {
        editorOperation.execute(textArea);
    }
}
