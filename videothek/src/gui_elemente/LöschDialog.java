package gui_elemente;

import java.awt.BorderLayout;

import javax.swing.JDialog;

public class LöschDialog  extends JDialog{
	
	public LöschDialog(String titel, String text, int position) {
		super();
		setTitle(titel);
		setSize(350, 180);
		add(new ErfassLabel(text, position), BorderLayout.CENTER);
		
	}

}
