package simplejavatexteditor;

import javax.swing.*;

public class StandardFindDialogFactory implements FindDialogFactory {


    @Override
    public FindDialog createFindDialog(JTextArea textarea) {
        return new Find(textarea);
    }
}
