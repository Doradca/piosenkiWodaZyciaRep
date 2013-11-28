package START;

import OknoGlowne.OknoZrobListePiesniJFrame;
import SkanowaniePiosenek.SkanujPiosenkiLibreOfficeUTF8;

public class Start {

	public static void main(String[] args) {		

		new SkanujPiosenkiLibreOfficeUTF8();
		//System.exit(0);
		
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				System.out.println("ma dzialac");
				new OknoZrobListePiesniJFrame();
			}
		});
	}

}
