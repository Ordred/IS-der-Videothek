package filme;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public class UC_Medium_ausleihen {
	
	private Medium m;
	private LocalDate heute;
	
	
	
	public UC_Medium_ausleihen(Medium m) {
		
		this.m = m;
		heute = LocalDate.now();
		
	}
	
	
	public void ausleihen() {
		m.setLagernd(false);
		
		m.setRückgabedatum(heute.plusDays(7));
	}

}
