package beanPackage;

public class TextResult {
	
	
	
	public String outputText(int pSum, String pWrong){
		
		int sumResult = pSum;
		String wrongAnswers = pWrong;

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
		
		String text4 = "Ganz grauslicher Fehler!";
		
		String text5 = "Das Ergebnis ist nicht aussagekr&auml;ftig, da Sie folgenden Frage(n) nicht " +
				"beantwortet haben: "  + wrongAnswers + ". <br>Bitte wiederholen Sie den Test.";
		
		//wenn Fragen nicht beantwortet wurden
		if (wrongAnswers != ""){
			return text5;
		}
		//wenn alle Fragen beantwortet wurden
		else if (sumResult <=17){
			return text1;
		}
		else if (sumResult <=26){
			return text2;
		}
		else if(sumResult>= 27){
			return text3;
		}
		else {
			return text4;
		}
		
	}
	

}
