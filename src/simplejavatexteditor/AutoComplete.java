package simplejavatexteditor;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

/**
 * <h1>Auto complete functionality multiple programming languages, including brackets and
 * parentheses</h1>
 *
 * <p>
 * An ArrayList is created for the keywords and the brackets.
 * Logic for setting the content of the ArrayList is
 * found in UI.java. If the word currently being typed
 * matches a word in the list, a Runnable inner class is
 * implemented to handle the word completion.
 *
 * Two other inner classes are also used. The second one handles when the enter
 * key is pressed in response to an auto complete suggestion. The third one
 * performs additional logic on brackets.
 * </p>
 *
 *
 * @author Patrick Slagle
 * @since 2016-12-03
 */
public class AutoComplete
        implements DocumentListener {

    private final UI ui;
    private final JTextArea textArea;
    private static final String COMMIT_ACTION = "commit";
    private int pos;
    private String content;
    private final CompletionStrategy keywordStrategy;
    private final CompletionStrategy bracketStrategy;

    public AutoComplete(UI ui, ArrayList<String> al) {
        this.ui = ui;
        this.textArea = ui.getEditor();
        
        // Initialize keyword strategy
        this.keywordStrategy = new KeywordCompletionStrategy(al);

        // Initialize bracket strategy
        this.bracketStrategy = new BracketCompletionStrategy();

        // Set the handler for the enter key
        InputMap im = textArea.getInputMap();
        ActionMap am = textArea.getActionMap();
        im.put(KeyStroke.getKeyStroke("ENTER "), COMMIT_ACTION);
        am.put(COMMIT_ACTION, new CommitAction());
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        pos = e.getOffset();
        content = null;

        try {
            content = textArea.getText(0, pos + 1);
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }

        if (e.getLength() != 1) {
            return;
        }

        // Check for bracket
        bracketStrategy.checkForBracket(textArea, content, pos);

        // Check for keyword
        keywordStrategy.checkForCompletion(textArea, content, pos);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
    }

    private class CommitAction
            extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            keywordStrategy.handleCommit(textArea, pos);
        }
    }
}

// Interface for completion strategies
interface CompletionStrategy {
    void checkForCompletion(JTextArea textArea, String content, int pos);
    void handleCommit(JTextArea textArea, int pos);
    void checkForBracket(JTextArea textArea, String content, int pos);
}

// Concrete strategy for keyword completion
class KeywordCompletionStrategy implements CompletionStrategy {
    private final ArrayList<String> keywords;

    public KeywordCompletionStrategy(ArrayList<String> keywords) {
        this.keywords = keywords;
        Collections.sort(keywords);
    }

    @Override
    public void checkForCompletion(JTextArea textArea, String content, int pos) {
        // Your existing keyword completion logic goes here
    }

    @Override
    public void handleCommit(JTextArea textArea, int pos) {
        // Your existing commit action logic goes here
    }

    @Override
    public void checkForBracket(JTextArea textArea, String content, int pos) {
        // This strategy doesn't handle brackets, so this method is empty
    }
}

// Concrete strategy for bracket completion
class BracketCompletionStrategy implements CompletionStrategy {
    @Override
    public void checkForCompletion(JTextArea textArea, String content, int pos) {
        // This strategy doesn't handle keyword completion, so this method is empty
    }

    @Override
    public void handleCommit(JTextArea textArea, int pos) {
        // This strategy doesn't handle commit action, so this method is empty
    }

    @Override
    public void checkForBracket(JTextArea textArea, String content, int pos) {
        // Your existing bracket completion logic goes here
    }
}
