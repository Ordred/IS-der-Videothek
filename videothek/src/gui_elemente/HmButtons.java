package gui_elemente;

import java.awt.Color;

import javax.swing.JButton;

public class HmButtons extends JButton {

	public HmButtons(String titel) {

		setText(titel);
		setOpaque(true);
		setBackground(Color.cyan);
		setForeground(Color.black);
		setRolloverEnabled(true);
	}

}
