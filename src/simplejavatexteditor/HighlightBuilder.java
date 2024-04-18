package simplejavatexteditor;

import java.awt.*;

public class HighlightBuilder {
    private Color color;
    private String[] patterns;
    // Potential: private boolean caseSensitive = false; 

    public HighlightBuilder color(Color color) {
        this.color = color;
        return this;
    }

    public HighlightBuilder patterns(String[] patterns) {
        this.patterns = patterns;
        return this;
    }

    // Potential: 
    // public HighlightBuilder caseSensitive(boolean caseSensitive) { ... } 

    public HighlightText build() {
        if (color == null || patterns == null) {
            throw new IllegalStateException("Color and patterns must be set");
        }
        return new HighlightText(color, patterns);
    }
}