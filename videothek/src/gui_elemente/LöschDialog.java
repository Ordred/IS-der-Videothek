package gui_elemente;

import java.awt.BorderLayout;

import javax.swing.JDialog;

import com.sun.media.sound.EmergencySoundbank;

public class LöschDialog  extends JDialog{
	
	public LöschDialog(String titel, String text, int position) {
		super();
		setTitle(titel);
		setSize(450, 180);
		ErfassPanel lp = new ErfassPanel();
		setModal(true);
		lp.add(new ErfassLabel(text, position), BorderLayout.CENTER);
		add(lp);
		
		
	}

}
