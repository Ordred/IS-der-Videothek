package gui_elemente;

import java.awt.BorderLayout;

import javax.swing.JDialog;

public class L�schDialog  extends JDialog{
	
	public L�schDialog(String titel, String text, int position) {
		super();
		setTitle(titel);
		setSize(300, 150);
		add(new ErfassLabel(text, position), BorderLayout.CENTER);
		
	}

}
