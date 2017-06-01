package funkcjeStat;

import java.io.File;
import java.nio.file.Files;

public class PlikZawart_funkcje {
	
	public static int wczytajZPlikuLiczbeInta_calaZawartoscPlikuToTaLiczba(File plikZLiczba, String kodowanieCharset, int wartoscDoZwrotuWPrzypadkuBledu){
		try {
			
			byte [] zawartosc = Files.readAllBytes(plikZLiczba.toPath());
			String zawartoscNapis = new String(zawartosc, kodowanieCharset);
			System.out.println(plikZLiczba.getAbsolutePath());
			System.out.println(zawartoscNapis);
			return Integer.parseInt(zawartoscNapis);
		} catch (Exception e) {
			return wartoscDoZwrotuWPrzypadkuBledu;
		}
	}

	public static String wczytajZPlikuNapis_calaZawartoscPlikuToTenNapis_nullBlad(File plikZNapisem, String kodowanieCharset){
		try {
			byte [] zawartosc = Files.readAllBytes(plikZNapisem.toPath());
			String zawartoscNapis = new String(zawartosc, kodowanieCharset);
			
			System.out.println(zawartoscNapis);
			
			return zawartoscNapis;
		} catch (Exception e) {
			return null;
		}
	}
}
