package ZdarzOdpalPiesni;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import SkanowaniePiosenek.PiosenkaZPlikuSkan;

public class KopieTMP {

	public static void chodzWKolkoDoSkasowaniaPlikowIKataloguTMP(){
		if (katalogTMP != null){
			while(katalogTMP.exists()){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {}
				skasujZawartoscKataloguTMP(katalogTMP);
				katalogTMP.delete();
			}
		}
	}

	private static void skasujZawartoscKataloguTMP(File katalogTMP){
		File [] plikiTMP = katalogTMP.listFiles();
		if (plikiTMP != null){
			for(int i = 0; i < plikiTMP.length; i++){
				if (plikiTMP[i].isDirectory()) skasujZawartoscKataloguTMP(plikiTMP[i]);
				plikiTMP[i].delete();
			}
		}
	}

	private static File katalogTMP;


	public static ArrayList<String> zrobKopieTMP_iZapodajSciezkiAbsolutneTychKopii(ArrayList<PiosenkaZPlikuSkan> piosenkiDoOdpalenia){
		ArrayList<String> sciezkiAbsolutneKopii = new ArrayList<String>();

		// jak lista pusta to koniec
		if (piosenkiDoOdpalenia.size() == 0) return sciezkiAbsolutneKopii;

		katalogTMP = stworzKatalogTymczasowyIZapodajGo(piosenkiDoOdpalenia.get(0).getZapodajSciezkeAbsolutna());

		// ustal nowa nazwe i sciezke absolutna piosenki i ja tam skopiuj
		String nowaSciezka;
		for (int p = 0; p < piosenkiDoOdpalenia.size(); p++){
			nowaSciezka = nowaSciezkaAbsolutnaPiosenki(katalogTMP, piosenkiDoOdpalenia.get(p).getNazwaPlikuPiosenki());
			skopiujPiosenke(nowaSciezka, piosenkiDoOdpalenia.get(p).getZapodajSciezkeAbsolutna());
			sciezkiAbsolutneKopii.add(nowaSciezka);
		}
		return sciezkiAbsolutneKopii;
	}

	private static void skopiujPiosenke(String nowaSciezka, String staraSciezka){
		File nowyTMP = new File(nowaSciezka);
		try {
			nowyTMP.createNewFile();
			nowyTMP.deleteOnExit();

			FileInputStream is = new FileInputStream(staraSciezka);
			FileOutputStream os = new FileOutputStream(nowaSciezka);
			byte [] buff = new byte[1000000];
			int readLen;
			while((readLen = is.read(buff)) > 0){
				os.write(buff, 0, readLen);
			}
			is.close();
			os.close();
		} catch (FileNotFoundException e){}
		catch (IOException e1) {}
	}


	private static String nowaSciezkaAbsolutnaPiosenki(File katalogTMP, String nazwaPlikuPiosenki){
		String nazwaPoprawiona = wywalTylkoPolskieZnaki(nazwaPlikuPiosenki);
		if (nazwaPoprawiona.length() == 0) nazwaPoprawiona = "a";
		File f = new File(katalogTMP.getAbsolutePath() + '\\' + nazwaPoprawiona);
		while (f.exists()){
			nazwaPoprawiona = "popr_" + nazwaPoprawiona;
			f = new File(katalogTMP.getAbsolutePath() + '\\' + nazwaPoprawiona);
		}
		return katalogTMP.getAbsolutePath() + '\\' + nazwaPoprawiona;
	}


	private static String wywalTylkoPolskieZnaki(String nazwa){
		String nowaNazwa = "NotSave_";
		char z;
		for (int i = 0; i < nazwa.length(); i++){
			z = nazwa.charAt(i);
			switch (z){
			case '¥': z = 'A'; break;
			case 'Æ': z = 'C'; break;
			case 'Ê': z = 'E'; break;
			case '£': z = 'L'; break;
			case 'Ñ': z = 'N'; break;
			case 'Ó': z = 'O'; break;
			case 'Œ': z = 'S'; break;
			case '': z = 'Z'; break;
			case '¯': z = 'Z'; break;
			case '¹': z = 'a'; break;
			case 'æ': z = 'c'; break;
			case 'ê': z = 'e'; break;
			case '³': z = 'l'; break;
			case 'ñ': z = 'n'; break;
			case 'ó': z = 'o'; break;
			case 'œ': z = 's'; break;
			case 'Ÿ': z = 'z'; break;
			case '¿': z = 'z'; break;
			}
			nowaNazwa += z;
		}
		return nowaNazwa;
	}


	private static File stworzKatalogTymczasowyIZapodajGo(String jakasSciezkaAbsolutna){
		String jakasSciezkaAbsolutnaZKoncowka = jakasSciezkaAbsolutna + '\\';
		String dysk = jakasSciezkaAbsolutnaZKoncowka.substring(0, jakasSciezkaAbsolutnaZKoncowka.indexOf('\\'));
		String sciezkaAbsolutnaKataloguTMP = dysk + "\\katTMP";
		File tmp = new File(sciezkaAbsolutnaKataloguTMP);
		while(tmp.exists()){
			sciezkaAbsolutnaKataloguTMP += "_tmp";
			tmp = new File(sciezkaAbsolutnaKataloguTMP);
		}
		tmp.mkdir();
		tmp.deleteOnExit();
		return tmp;
	}


}

