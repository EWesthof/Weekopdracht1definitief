import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Weekopdracht1ds3{


	public static void main(String[] args) {
		System.out.println("Welkom bij het spel blackjack!");
		System.out.println("De kaarten zijn geschud:");
		Kaartspel kaartspelletje = new Kaartspel();
		Spelers speler1 = new Spelers();
		kaartspelletje.schudden();
		speler1.beurt(kaartspelletje.kaartspeltotaal);
		System.out.println("Dit was de beurt van Speler 1. Nu is speler 2 aan de beurt." + "\n");
		Spelers speler2 = new Spelers();
		speler2.beurt(kaartspelletje.kaartspeltotaal);
		if (speler1.totaleKaartwaarde < speler2.totaleKaartwaarde) {
			System.out.println("speler2 heeft meer punten dan speler1 en heeft gewonnen!");
		}
		else if (speler1.totaleKaartwaarde > speler2.totaleKaartwaarde) {
			System.out.println("speler1 heeft meer punten dan speler2 en heeft gewonnen!");
		}
		else {
			System.out.println("Het is gelijk spel.");
		}
	}
	
}

class Kaartspel{
	ArrayList<String> kaartspeltotaal = new ArrayList<>();
	void schudden() {
		String[] kaartsoorten = { "harten", "schoppen", "ruiten", "klaver" };
		String[] getallen = { "twee", "drie", "vier", "vijf", "zes", "zeven", "acht", "negen", "tien", "boer", "vrouw",
				"heer", "aas" };
		int y = 0;
		while (y < 52) {
			Random kaartsoort = new Random();
			int k = kaartsoort.nextInt(kaartsoorten.length);
			Random cijfer = new Random();
			int g = cijfer.nextInt(getallen.length);
			if (!kaartspeltotaal.contains(kaartsoorten[k] + " " + getallen[g])) {
				kaartspeltotaal.add(kaartsoorten[k] + " " + getallen[g]);
				y += 1;
			}
	}
		System.out.println(String.join(",", kaartspeltotaal));
}
}

class Kaart {
	int bepkaartwaarde (ArrayList<String>kaartspeltotaal) {
		int kaartwaarde;
		if (kaartspeltotaal.get(0).equals("harten twee") || kaartspeltotaal.get(0).equals("ruiten twee") || kaartspeltotaal.get(0).equals("schoppen twee") || kaartspeltotaal.get(0).equals("klaver twee")){
			kaartwaarde = 2;
		}
		else if (kaartspeltotaal.get(0).equals("harten drie") || kaartspeltotaal.get(0).equals("ruiten drie") || kaartspeltotaal.get(0).equals("schoppen drie") || kaartspeltotaal.get(0).equals("klaver drie")){
		
			kaartwaarde = 3;
		}
		else if (kaartspeltotaal.get(0).equals("harten vier") || kaartspeltotaal.get(0).equals("ruiten vier") || kaartspeltotaal.get(0).equals("schoppen vier") || kaartspeltotaal.get(0).equals("klaver vier")){
		
			kaartwaarde = 4;
		}
		else if (kaartspeltotaal.get(0).equals("harten vijf") || kaartspeltotaal.get(0).equals("ruiten vijf") || kaartspeltotaal.get(0).equals("schoppen vijf") || kaartspeltotaal.get(0).equals("klaver vijf")){
			kaartwaarde = 5;
		}
		else if (kaartspeltotaal.get(0).equals("harten zes") || kaartspeltotaal.get(0).equals("ruiten zes") || kaartspeltotaal.get(0).equals("schoppen zes") || kaartspeltotaal.get(0).equals("klaver zes")){
			kaartwaarde = 6;
		}
		else if (kaartspeltotaal.get(0).equals("harten zeven") || kaartspeltotaal.get(0).equals("ruiten zeven") || kaartspeltotaal.get(0).equals("schoppen zeven") || kaartspeltotaal.get(0).equals("klaver zeven")){
			kaartwaarde = 7;
		}
		else if (kaartspeltotaal.get(0).equals("harten acht") || kaartspeltotaal.get(0).equals("ruiten acht") || kaartspeltotaal.get(0).equals("schoppen acht") || kaartspeltotaal.get(0).equals("klaver acht")){
			kaartwaarde = 8;
		}
		else if (kaartspeltotaal.get(0).equals("harten negen") || kaartspeltotaal.get(0).equals("ruiten negen") || kaartspeltotaal.get(0).equals("schoppen negen") || kaartspeltotaal.get(0).equals("klaver negen")){
			kaartwaarde = 9;
		}
		else if (kaartspeltotaal.get(0).equals("harten aas") || kaartspeltotaal.get(0).equals("ruiten aas") || kaartspeltotaal.get(0).equals("schoppen aas") || kaartspeltotaal.get(0).equals("klaver aas")){
			kaartwaarde = 11;
		}
		else {
			kaartwaarde = 10;
			}
		return kaartwaarde;
	}
}
class Spelers{
	Kaart kaart = new Kaart();
	int totaleKaartwaarde = 0;
	void beurt(ArrayList<String>kaartspeltotaal){
		String gepaktekaarten = kaartspeltotaal.get(0);
		totaleKaartwaarde += kaart.bepkaartwaarde(kaartspeltotaal);
		kaartspeltotaal.remove(0);
		gepaktekaarten += "," + kaartspeltotaal.get(0);
		totaleKaartwaarde += kaart.bepkaartwaarde(kaartspeltotaal);
		kaartspeltotaal.remove(0);
		System.out.println("Je hebt de volgende twee kaarten: " + gepaktekaarten);
		System.out.println("De kaarten hebben een waarde van: "+ totaleKaartwaarde);
		int aantalkaarten = 2;
	for (boolean eindespel = false; eindespel == false;) { 
		System.out.println("Speler: Voer k in om een kaart te krijgen, q om te stoppen en p om te passen");
		Scanner sc = new Scanner(System.in);
		String invoer = sc.nextLine();
		if (invoer.equals("k")) {
			++aantalkaarten;
			System.out.println("Je hebt een " + kaartspeltotaal.get(0) + " gepakt");
			System.out.println("Je hebt nu " + aantalkaarten + " kaarten.");
			gepaktekaarten += ", " + kaartspeltotaal.get(0); 
			System.out.println("Je hebt de volgende kaarten op hand: " + gepaktekaarten);
			totaleKaartwaarde += kaart.bepkaartwaarde(kaartspeltotaal);
			System.out.println("De kaarten hebben een waarde van " + totaleKaartwaarde);
			kaartspeltotaal.remove(0);
			if (totaleKaartwaarde > 21) { 
				System.out.println("game over, je hebt teveel punten...");
				System.out.println("Je puntentotaal is teruggebracht naar 0");
				totaleKaartwaarde = 0;
				eindespel = true;
			}
			else {
				System.out.println("Je mag nog een keer kiezen");
		} 
		}
		else if (invoer.equals("q")) {
			System.out.println("Je bent gestopt. Dit was het einde van het spel");
			totaleKaartwaarde = 0;
			eindespel = true;
		} 
		else if (invoer.equals("p")) {
			System.out.println("Je hebt gepast. Dit zijn je gepakte kaarten: " + gepaktekaarten);
			System.out.println("De kaarten hebben een waarde van " + totaleKaartwaarde);
			eindespel = true;
		} 
		else {
			System.out.println("Je hebt de verkeerde letter gekozen");
		}
		}
} 
}