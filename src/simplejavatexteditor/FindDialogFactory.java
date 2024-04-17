package simplejavatexteditor;

import javax.swing.*;

public interface FindDialogFactory {
    FindDialog createFindDialog(JTextArea textarea);
}
