package SkanowaniePiosenek;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class SkanujPiosenkiLibreOfficeUTF8 {

	public static ArrayList<PiosenkaZPlikuSkan> wszystkieZnalezionePiosenkiLibreOfficeUTF8Skan = new ArrayList<PiosenkaZPlikuSkan>();


	public SkanujPiosenkiLibreOfficeUTF8(){
		wszystkieZnalezionePiosenkiLibreOfficeUTF8Skan.clear();
		File katalogZProgramem = new File(".");
		String scZKropka = katalogZProgramem.getAbsolutePath();
		String scBezKropki = scZKropka.substring(0, scZKropka.length() - 2);
		katalogZProgramem = new File(scBezKropki);
		System.out.println();
		MiejsceNaDane miejsce = new MiejsceNaDane();
		przeskanujKatalog(katalogZProgramem, miejsce);
	}

	//______________________________________________________ pomocne _________________________________________________

	private class MiejsceNaDane{
		public byte [] bufferCzytaniaPliku = new byte [10000000];
		public byte [] bajtyCalejPiosenki = new byte[50000000];
		public byte [] samTekstPiosenki = new byte[50000000];
		public int samTekstPiosenkiIleMaBajtow;
		public int bajtyCalejPiosenkiIleWczytalBajtow;
		public int bufferCzytaniaPlikuIleWczytalZnakow;
		public ZipInputStream zis;
		public ZipEntry ze;
		public boolean ostatniNieBylEnter10;
		public int i;
	}



	private void wczytajIRozparsujPiosenkeAPotemWrzucJaDoListy(File plikPiosenkiPrezentacja, MiejsceNaDane miejsce) throws IOException{



		// rozpakowuj prezentacje open office
		miejsce.zis = new ZipInputStream(new FileInputStream(plikPiosenkiPrezentacja));
		miejsce.ze = miejsce.zis.getNextEntry();
		while (miejsce.ze != null){
			if (miejsce.ze.getName().equals("content.xml")){

				// przeczytaj calego XMLa piosenki
				miejsce.bajtyCalejPiosenkiIleWczytalBajtow = 0;
				miejsce.bufferCzytaniaPlikuIleWczytalZnakow = 0;
				while ((miejsce.bufferCzytaniaPlikuIleWczytalZnakow = miejsce.zis.read(miejsce.bufferCzytaniaPliku))>0){
					for (int i = 0; i < miejsce.bufferCzytaniaPlikuIleWczytalZnakow; i++){
						miejsce.bajtyCalejPiosenki[miejsce.bajtyCalejPiosenkiIleWczytalBajtow] = miejsce.bufferCzytaniaPliku[i];
						miejsce.bajtyCalejPiosenkiIleWczytalBajtow++;
					}
				}

				// przeczytal caly plik, teraz wybierz sam tekst piosenki
				miejsce.samTekstPiosenkiIleMaBajtow = 0;
				miejsce.ostatniNieBylEnter10 = false;
				// utf-8: 
				// 60 = <
				// 62 = >
				// 10 = \n
				for (miejsce.i = 0; miejsce.i < miejsce.bajtyCalejPiosenkiIleWczytalBajtow; miejsce.i++){
					if (miejsce.bajtyCalejPiosenki[miejsce.i] == 60){ // wpadl do tagu xml
						for (; miejsce.i < miejsce.bajtyCalejPiosenkiIleWczytalBajtow; miejsce.i++){
							if (miejsce.bajtyCalejPiosenki[miejsce.i] == 62) break;
						} // za tagiem xml
						if (miejsce.ostatniNieBylEnter10){
							miejsce.ostatniNieBylEnter10 = false;
							miejsce.samTekstPiosenki[miejsce.samTekstPiosenkiIleMaBajtow] = 10;
							miejsce.samTekstPiosenkiIleMaBajtow++;
						}
					} else{ // za tagiem xml
						if (miejsce.bajtyCalejPiosenki[miejsce.i] == 10){
							if (miejsce.ostatniNieBylEnter10){
								miejsce.ostatniNieBylEnter10 = false;
								miejsce.samTekstPiosenki[miejsce.samTekstPiosenkiIleMaBajtow] = 10;
								miejsce.samTekstPiosenkiIleMaBajtow++;
							}
						} else {
							miejsce.samTekstPiosenki[miejsce.samTekstPiosenkiIleMaBajtow] = miejsce.bajtyCalejPiosenki[miejsce.i];
							miejsce.samTekstPiosenkiIleMaBajtow++;
							miejsce.ostatniNieBylEnter10 = true;
						}
					}
				}

				// ma na bajtach tekst calej piosenki, zaladuj piosenke do listy
				wszystkieZnalezionePiosenkiLibreOfficeUTF8Skan.add(new PiosenkaZPlikuSkan(miejsce.samTekstPiosenki, miejsce.samTekstPiosenkiIleMaBajtow, plikPiosenkiPrezentacja));
				//	System.out.println(samaPiosenka);
				miejsce.zis.close();
				return;
			}
			miejsce.ze = miejsce.zis.getNextEntry();
		}
		miejsce.zis.close();
	}



	private String nazwa;
	private void przeskanujKatalog(File katalogBiezacy, MiejsceNaDane miejsce){
		File [] plikiIPodkatalogi = katalogBiezacy.listFiles();
		if (plikiIPodkatalogi != null){
			for (int i = 0; i < plikiIPodkatalogi.length; i++){
				if (plikiIPodkatalogi[i].isDirectory()) przeskanujKatalog(plikiIPodkatalogi[i], miejsce);
				else{
					// filtruj pliki open office
					nazwa = plikiIPodkatalogi[i].getName();
					if (nazwa.endsWith(".odt") || nazwa.endsWith(".odf") || nazwa.endsWith(".odp") || nazwa.endsWith(".ods")){
						// dobry plik - probuj odczytac
						try {
							wczytajIRozparsujPiosenkeAPotemWrzucJaDoListy(plikiIPodkatalogi[i], miejsce);
						} catch (IOException e) { }
					}
				}
			}
		}
	}

}
