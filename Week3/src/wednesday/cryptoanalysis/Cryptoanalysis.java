package wednesday.cryptoanalysis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import wednesday.cryptoanalysis.util.Histogram;
import wednesday.cryptoanalysis.util.InglishLettersStatistic;

public class Cryptoanalysis {
	public static void main(String[] args) {
		String text = "Ajb vnf guj luqv akjvojufq  . Sk qkkj egvfs Rkhfwu Lumemu'q akhhfjvq kj vnf ohifjbojc essoxew kg Dofck Ckqve , nfsf'q Ffsjejbk Tkssfq vk qnkr vnf ohifvukuq zkujc dkz nkr ov'q bkjf    Iv'q vnf qehf fxfsz quhhfs . Nk-kjf neq fxfs coxfj hf ejzvnojc kj e iwevf . Tnfz hebf hf akhifvf gks hz iweaf vnf xfsz hkhfjv I ckv ojvk vnf gosqv vfeh; vnev'q rnev vnfz veucnv hf ejb ov'ww df vnev rez ujvow I wfexf . Tnf nocnfs puewovz iwezfsq vnev akhf - ejb Dofck Ckqve oq puewovz - vnf csfevfs vnf akhifvovokj roww df ejb vnf dfvvfs ov'ww df gks vnf vfeh .Ajb gfes jkv ( ks , ewvfsjevoxfwz , bkj'v cfv vkk ftaovfb)  , Tkssfq neq jk iwejq vk vuam veow ejb suj ejb wfexf noq iezanfamq dfnojb .    I bkj'v nexf ejz iwejq vk hkxf erez socnv jkr .    Ig rf woqvfjfb vk eww vnf suhkusq rf'b nexf 50 iwezfsq . Nkr'q jkv vnf socnv vohf vk df vnojmojc edkuv Cnfwqfe . I'h qusf vnf awud oq rksmojc vk ohiskxf vnf vfeh , duv eww vnev hevvfsq socnv jkr oq vnf Wkswb Cui .Om , vnev dov edkuv vnf 50 iwezfsq hebf hf anuamwf .  Noaf kjf , Ffsjejbk .Nkr , oj ej obfew rkswb , rf rkuwb ifsneiq cfv vnfqf rksbq gskh Lumemu , rnkh rf'b womf vk dfakhf wfcfjbesz ev Cnfwqfe .  Buv rf bkj'v woxf oj ej obfew rkswb , ejb ojqvfeb rf cfv vnfqf rksbq gskh Tkssfq , rnkh rf'b womf vk dfakhf e wkjc-gksckvvfj hfhksz ev Cnfwqfe .  Aweq .Tnev dfojc qeob , qojaf ov'q deqoaewwz ej ohikqqodwf vk veqm vk sob kusqfwxfq kg vnf £100h gwki , ev wfeqv nf'q ckv vnf socnv evvovubf .  Hussez?";
		// String text = "Godzilla";
		// System.out.println(text);
		// System.out.println(m);

		String t = "";
		// System.out.println(InglishLettersStatistic.LETTERS);
		// for (int k = 0; k < 1; k++) {

		Map<Character, Integer> m = Histogram.createHistogram(text);
		List<Character> l = new ArrayList<>();
		for (Map.Entry<Character, Integer> entry : m.entrySet()) {
			l.add(entry.getKey());
		}

		// System.out.println(l);
		for (int i = 0, a = 0; i < text.length(); i++, a++) {
			char letter = text.charAt(i);
			if (a == 133) {
				t += "\n";
				a = 0;
			}
			t += String.valueOf(InglishLettersStatistic.map(letter));
			// if (Character.isLowerCase(letter) && l.contains(letter)) {
			// // System.out.println(letter);
			// int pos = l.indexOf(letter);
			// // System.out.println(pos);
			// tex += InglishLettersStatistic.LETTERS[pos];
			// // i++;
			// continue;
			// }
			//
			// tex += letter;

		}
		System.out.println(t);
		// System.out.print(tex);
		// List<String> pairs = new ArrayList<>();
		// List<String> triples = new ArrayList<>();
		// String[] splited = tex.split(" ");
		// System.out.println();
		// Map<Character, Integer> m1 = Histogram.createHistogram(tex);
		// System.out.println(m1);
		// // System.out.println(Arrays.toString(splited));
		// Map<Character, Character> mapped = new HashMap<>();
		// for (int i = 0; i < splited.length; i++) {
		// if (splited[i].length() == 2 && !pairs.contains(splited[i])) {
		// pairs.add(splited[i]);
		// }
		// if (splited[i].length() == 3 && !triples.contains(splited[i])) {
		// triples.add(splited[i]);
		// }
		// if (splited[i].trim().length() == 3 && splited[i].startsWith("t")) {
		// // THE
		// char b = splited[i].charAt(1);
		// mapped.put(b, 'h');
		// tex = tex.replaceAll(String.valueOf(b), "h");
		// char c = splited[i].charAt(2);
		// tex = tex.replaceAll(String.valueOf(c), "e");
		// mapped.put(c, 'e');
		// // splited[i] = "the";
		// }
		// if (splited[i].trim().length() == 2 && splited[i].startsWith("t")) {
		// // TO
		// char a = splited[i].charAt(1);
		// mapped.put(a, 'o');
		// tex = tex.replaceAll(String.valueOf(a), "o");
		// }
		//
		// if (splited[i].trim().length() == 3 && splited[i].startsWith("A")) {
		// // AND
		// char b = splited[i].charAt(1);
		// mapped.put(b, 'n');
		// tex = tex.replaceAll(String.valueOf(b), "n");
		// char c = splited[i].charAt(2);
		// tex = tex.replaceAll(String.valueOf(c), "d");
		// mapped.put(c, 'd');
		//
		// // splited[i] = "to";
		// }
		// if (splited[i].trim().length() == 3 && splited[i].charAt(1) == 'o') {
		// char a = splited[i].charAt(0);
		// mapped.put(a, 'f');
		// tex = tex.replaceAll(String.valueOf(a), "f");
		// char b = splited[i].charAt(2);
		// mapped.put(b, 'r');
		// tex = tex.replaceAll(String.valueOf(b), "r");
		// }
		// }
		// // Map<Character, Integer> m2 = Histogram.createHistogram(tex);
		// System.out.println(pairs);
		// // System.out.println(m2);
		// // System.out.println(Arrays.toString(splited));
		// System.out.println(triples);
	}
}
