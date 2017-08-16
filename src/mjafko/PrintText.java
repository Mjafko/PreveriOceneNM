package mjafko;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;

public class PrintText {

    public  Label lbltext;
    public ScrollPane scrollPane;

    public void setTextArea(String setText) {

        lbltext.setText(setText);
        // Create a ScrollPane


        // Set content for ScrollPane
        scrollPane.setContent(lbltext);

        // Always show vertical scroll bar
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        // Horizontal scroll bar is only displayed when needed
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
    }
}
