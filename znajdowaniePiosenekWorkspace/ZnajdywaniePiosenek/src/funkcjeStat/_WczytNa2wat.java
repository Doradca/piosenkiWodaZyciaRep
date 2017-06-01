package funkcjeStat;

import java.io.InputStream;

public class _WczytNa2wat {
	

	public static int wczytajFragmentKolejnyZeStrumienia_wczytujNaInnymWatkuIGoKontroluj_zwrocIleWczytalBajtow(InputStream inStrumienRead,
			byte [] tablicaBajtow_naNiaWczytywacOdPoczatku_najlepiejDoKonca, 
			int czasSleepNaPojedynczyOdczytMs, 
			int naWczytaniePoczBajtu_maxLiczbaCzasowSleep,
			int bajtyMinLiczbaDoWczytaniaNaCzasSleep){
		// wczytywanie
		WatCzytFr_na2w watekCzytajacyFragment = new WatCzytFr_na2w(inStrumienRead, tablicaBajtow_naNiaWczytywacOdPoczatku_najlepiejDoKonca);
		watekCzytajacyFragment.start();
		int ostatnioWczytanoLacznieBajtowFragmentu = 0;
		// czekaj wiekszy czas na rozpoczecie odczytu (np. zeby serwer zdazyl wykonac akcje)
		for (int i = 0; i < naWczytaniePoczBajtu_maxLiczbaCzasowSleep; i++){
			if (watekCzytajacyFragment.brakRozkazuZatrzymaniaWczytywaniaTegoFragmentu
					&& watekCzytajacyFragment.watekIsRunning_nieSkonczylMetodyRun // watek czytajacy dziala
					&& watekCzytajacyFragment.wczytanoBajtowFragmentuLacznie < bajtyMinLiczbaDoWczytaniaNaCzasSleep // nie wczytal poczatkowych bajtow fragmentu
					){
				{
					// czekanie jednego cyklu na odczyt
					boolean niepoprawneSpanie = true;
					while(niepoprawneSpanie){
						try {
							Thread.sleep(czasSleepNaPojedynczyOdczytMs);
							niepoprawneSpanie = false;
						} catch (InterruptedException e) {}
					}
				}
			} else break;
		}
		while (watekCzytajacyFragment.brakRozkazuZatrzymaniaWczytywaniaTegoFragmentu
				&& watekCzytajacyFragment.watekIsRunning_nieSkonczylMetodyRun // watek czytajacy dziala
				&& watekCzytajacyFragment.wczytanoBajtowFragmentuLacznie < tablicaBajtow_naNiaWczytywacOdPoczatku_najlepiejDoKonca.length // nie wczytal wszystkiego
				&& ostatnioWczytanoLacznieBajtowFragmentu + bajtyMinLiczbaDoWczytaniaNaCzasSleep <= 
				watekCzytajacyFragment.wczytanoBajtowFragmentuLacznie // nie za wolny odczyt
				){
			ostatnioWczytanoLacznieBajtowFragmentu = watekCzytajacyFragment.wczytanoBajtowFragmentuLacznie;
			{
				// czekanie jednego cyklu na odczyt
				boolean niepoprawneSpanie = true;
				while(niepoprawneSpanie){
					try {
						Thread.sleep(czasSleepNaPojedynczyOdczytMs);
						niepoprawneSpanie = false;
					} catch (InterruptedException e) {}
				}
			}
		}
		watekCzytajacyFragment.brakRozkazuZatrzymaniaWczytywaniaTegoFragmentu = false;
		return watekCzytajacyFragment.wczytanoBajtowFragmentuLacznie;
	}

}
