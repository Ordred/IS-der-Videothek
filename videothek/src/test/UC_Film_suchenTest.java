package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.UC_Film_suchen;
import model.Film;
import model.Filmliste;

class UC_Film_suchenTest {

	ArrayList<Film> flTitel;
	ArrayList<Film> flJahr;
	ArrayList<Film> fl2;
	Filmliste fl3;
	UC_Film_suchen ucfs;
	
	ArrayList<Film> jahresVergleichList;

	Film [] titelArray;
	Film [] jahrArray;
	Film [] titelVergleichArray;
	Film [] jahrVergleichArray;




	@BeforeEach
	void setUp() throws Exception {

		flTitel = new ArrayList<Film>();
		flJahr = new ArrayList<Film>();
		fl2 = new ArrayList<Film>();
		jahresVergleichList = new ArrayList<Film>();
		fl3 = new Filmliste();
		fl3.laden();
		ucfs = new UC_Film_suchen(false,fl3,false,null,null,null);

		flTitel = ucfs.titel("");

		flJahr = ucfs.jahr(1);
		
		titelArray = new Film[flTitel.size()];
		jahrArray = new Film[flJahr.size()];
		
		titelVergleichArray = new Film[fl3.getFilmliste().size()];
		
		
		for (int i = 0; i < titelArray.length; i++) {
			titelArray[i] = flTitel.get(i);
		}
		
		for (int i = 0; i < jahrArray.length; i++) {
			jahrArray[i] = flJahr.get(i);
		}
		
		for (int i = 0; i < titelVergleichArray.length; i++) {
			titelVergleichArray[i] = fl3.getFilmliste().get(i);
		}
		
		for (int i = 0; i < fl3.getFilmliste().size(); i++) {
			if (fl3.getFilmliste().get(i).getJahr() == 1) {
				jahresVergleichList.add(fl3.getFilmliste().get(i));
			}
		}
		
		jahrVergleichArray = new Film[jahresVergleichList.size()];
		
		for (int i = 0; i < jahrVergleichArray.length; i++) {
			jahrVergleichArray[i] = jahresVergleichList.get(i);
		}
		
		




	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void testTitel() {
		Assertions.assertArrayEquals(titelVergleichArray, titelArray);
		
	}

	@Test
	final void testJahr() {
	Assertions.assertArrayEquals(jahrVergleichArray, jahrArray);
	}

}
