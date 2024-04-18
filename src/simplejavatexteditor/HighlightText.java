package simplejavatexteditor;

import javax.swing.text.*;
import java.awt.*;

public class HighlightText extends DefaultHighlighter.DefaultHighlightPainter {

    private final Color color;
    private final String[] patterns;

    // Constructor using the Builder pattern
    HighlightText(Color color, String[] patterns) {
        super(color);
        this.color = color;
        this.patterns = patterns;
    }

    public void highLight(JTextComponent textComp, String[] cppKeywords) {
        removeHighlights(textComp);

        try {
            Highlighter highlighter = textComp.getHighlighter();
            Document doc = textComp.getDocument();
            String text = doc.getText(0, doc.getLength());

            for (String pattern : patterns) {
                int pos = 0;
                while ((pos = text.indexOf(pattern, pos)) >= 0) {
                    highlighter.addHighlight(pos, pos + pattern.length(), this);
                    pos += pattern.length();
                }
            }
        } catch (BadLocationException e) {
            // Handle the exception as needed
        }
    }

    public void removeHighlights(JTextComponent textComp) {
        Highlighter highlighter = textComp.getHighlighter();
        Highlighter.Highlight[] hilites = highlighter.getHighlights();

        for (int i = 0; i < hilites.length; i++) {
            if (hilites[i].getPainter() instanceof HighlightText) {
                highlighter.removeHighlight(hilites[i]);
            }
        }
    }

    // Builder Class for constructing HighlightText objects
    public static class HighlightBuilder {
        private Color color;
        private String[] patterns;

        public HighlightBuilder color(Color color) {
            this.color = color;
            return this;
        }

        public HighlightBuilder patterns(String[] patterns) {
            this.patterns = patterns;
            return this;
        }

        public HighlightText build() {
            if (color == null || patterns == null) {
                throw new IllegalStateException("Color and patterns must be set");
            }
            return new HighlightText(color, patterns);
        }
    }
}
