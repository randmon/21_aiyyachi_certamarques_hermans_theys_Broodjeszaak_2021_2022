package view.panels;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class SandwichOverviewPane extends GridPane{

	public SandwichOverviewPane() {
		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);        
		this.add(new Label("Broodjes:"), 0, 0, 1, 1);		
	}	
}
