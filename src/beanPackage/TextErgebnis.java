package beanPackage;

public class TextErgebnis {
	
	public String ausgabeText(int pSumme){
		
		int summeErgebnis = pSumme;
		String text1 = "Sie f&uuml;hlen sich eventuell schon seit L&auml;ngerem nicht wirklich fit und " +
				"gesund. Liegt es an der unmittelbaren Gestaltung Ihres Arbeitsplatzes, wie schlechte " +
				"Luft, falscher Sessel oder falsche PC-Einstellung? Oder geht das Ganze tiefer? " +
				"Frisst der Job Sie wegen zu viel Stress auf? Finden Sie heraus, womit Ihr Unwohlsein " +
				"zu tun hat, ob Sie selbst etwas &auml;ndern k&ouml;nnen. Fragen Sie Ihre Sicherheitsvertrauensperson " +
				", den/die ArbeitsmedizinerIn. Infos auch unter www.svp.at.";
		
		String text2 = "Wenn Ihnen manchmal die gute Stimmung vergeht, wenn Sie an den n&auml;chsten " +
				"Arbeitstag denken, heisst das noch nicht, dass Ihr Arbeitsplatz Sie krank macht. " +
				"Die Anforderungen sind heute hoch. Im Grossen und Ganzen f&uuml;hlen Sie sich gesund am Arbeitsplatz. " +
				"Achten Sie aber darauf, dass Sie sich in der arbeitsfreien Zeit bewusst entspannen " +
				"und so richtig abschalten.";
		
		String text3 = "Gratulation! Sie f&uuml;hlen sich rundum wohl an Ihrem Arbeitsplatz und k&ouml;nnen " +
				"nach der Arbeit gut entspannen. Ihre Firma legt vermutlich bewusst darauf Wert, ein " +
				"gutes Betriebsklima und gesunde Arbeitspl&auml;tze zu f&ouml;rdern. ";
		
		String text4 = "Fehler, da nicht alle Fragen beantwortet wurden!";
		String text5 = "Ganz grauslicher Fehler!";
		
		if (summeErgebnis == 0){
			return text4;
		}
		else if (summeErgebnis <=9) {
			return text1;			
		} 
		else if (summeErgebnis <=18){
			return text2;
		}
		else if (summeErgebnis <=27){
			return text3;
		}
		else {
			return text5;
		}
		

		
	}

}
