package test;

import net.battleship.Translator;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by m.zilenas on 2017-02-20.
 */
public class TranslatorTest
{
    @Test
    public void testTranslate()
            throws IOException
    {
        Translator translator = new Translator("src\\test\\cmudict.0.7a.txt");;
        String str = "It was past one o'clock when Pierre left his friend. It was a cloudless, northern, summer night. " +
                "Pierre took an open cab intending to drive straight home. But the nearer he drew to the house" +
                "the more he felt the impossibility of going to sleep on such a night. It was light enough to see a " +
                "long way in the deserted street and it seemed more like morning or evening than night. But he " +
                "immediately recalled his promise to Prince Andrew not to go there. Then, as happens to people " +
                "of weak character, he desired so passionately once more to enjoy that dissipation he was so " +
                "accustomed to that he decided to go. The thought immediately occurred to him that his promise " +
                "to Prince Andrew was of no account, because before he gave it he had already promised Prince " +
                "Anatole to come to his gathering; \"besides,\" though he, \"all such 'words of honor' are " +
                "conventional things with no definite meaning, especially if one considers that by tomorrow one " +
                "may be dead, or something so extraordinary may happen to one that honor and " +
                "dishonor will be all the same!” (From War and Peace, by Leo Tolstoy.)";

        String translation = "IH1 T W AA1 Z P AE1 S T W AH1 N AH0 K L AA1 K W EH1 N P IY0 EH1 R L EH1 F T HH IH1 Z " +
                "F R EH1 N D P IH1 R IY0 AH0 D IH1 T W AA1 Z AH0 K L AW1 D L AH0 S K AA1 M AH0 N AO1 " +
                "R DH ER0 N K AA1 M AH0 S AH1 M ER0 N AY1 T P IH1 R IY0 AH0 D P IY0 EH1 R T UH1 K " +
                "AE1 N OW1 P AH0 N K AE1 B IH0 N T EH1 N D IH0 NG T UW1 D R AY1 V S T R EY1 T HH " +
                "OW1 M P IH1 R IY0 AH0 D B AH1 T DH AH0 N IH1 R ER0 HH IY1 D R UW1 T UW1 DH AH " +
                "HH AW1 S DH AH0 M AO1 R HH IY1 F EH1 L T DH AH0 IH0 M P AO2 S IH0 B IH1 L IH0 T " +
                "IY0 AH1 V G OW1 IH0 NG T UW1 S L IY1 P AA1 N S AH1 CH AH0 N AY1 T P IH1 R IY0 AH0 D " +
                "IH1 T W AA1 Z L AY1 T IH0 N AH1 F T UW1 S IY1 AH0 L AO1 NG W EY1 IH0 N DH AH0 D IH0 " +
                "Z ER1 T IH0 D S T R IY1 T AH0 N D IH1 T S IY1 M D M AO1 R L AY1 K M AO1 R N IH0 NG AO1 " +
                "R IY1 V N IH0 NG DH AE1 N N AY1 T P IH1 R IY0 AH0 D B AH1 T HH IY1 IH0 M IY1 D IY0 " +
                "AH0 T L IY0 R IH0 K AO1 L D HH IH1 Z P R AA1 M AH0 S T UW1 P R IH1 N S AE1 N D R UW0 " +
                "N AA1 T T UW1 G OW1 DH EH1 R P IH1 R IY0 AH0 D DH EH1 N K AA1 M AH0 AE1 Z HH AE1 " +
                "P AH0 N Z T UW1 P IY1 P AH0 L AH1 V W IY1 K K EH1 R IH0 K T ER0 K AA1 M AH0 HH IY1 " +
                "D IH0 Z AY1 ER0 D S OW1 P AE1 SH AH0 N AH0 T L IY0 W AH1 N S M AO1 R T UW1 EH0 N " +
                "JH OY1 DH AE1 T D IH2 S IH0 P EY1 SH AH0 N HH IY1 W AA1 Z S OW1 AH0 K AH1 S T AH0 " +
                "M D T UW1 DH AE1 T HH IY1 D IH2 S AY1 D IH0 D T UW1 G OW1 P IH1 R IY0 AH0 D DH " +
                "AH0 TH AO1 T IH0 M IY1 D IY0 AH0 T L IY0 AH0 K ER1 D T UW1 HH IH1 M DH AE1 T HH " +
                "IH1 Z P R AA1 M AH0 S T UW1 P R IH1 N S AE1 N D R UW0 W AA1 Z AH1 V N OW1 AH0 K " +
                "AW1 N T K AA1 M AH0 B IH0 K AO1 Z B IH0 F AO1 R HH IY1 G EY1 V IH1 T HH IY1 HH AE1 D " +
                "AO0 L R EH1 D IY0 P R AA1 M AH0 S T P R IH1 N S AE1 N AH0 T OW2 L T UW1 K AH1 M T " +
                "UW1 HH IH1 Z G AE1 DH ER0 IH0 NG S EH1 M IY0 K OW1 L AH0 N K W OW1 T B IH0 S AY1 " +
                "D Z K AA1 M AH0 AH1 N K W OW1 T TH AO1 T HH IY1 K AA1 M AH0 K W OW1 T AO1 L S AH1 " +
                "CH AH0 P AA1 S T R AH0 F IY0 W ER1 D Z AH1 V AA1 N ER0 AH0 P AA1 S T R AH0 F IY0 AA1 " +
                "R K AH0 N V EH1 N SH AH0 N AH0 L TH IH1 NG Z W IH1 DH N OW1 D EH1 F AH0 N AH0 T " +
                "M IY1 N IH0 NG K AA1 M AH0 AH0 S P EH1 SH L IY0 IH1 F W AH1 N K AH0 N S IH1 D ER0 Z " +
                "DH AE1 T B AY1 T AH0 M AA1 R OW2 W AH1 N M EY1 B IY1 D EH1 D K AA1 M AH0 AO1 R S " +
                "AH1 M TH IH0 NG S OW1 EH2 K S T R AH0 AO1 R D AH0 N EH2 R IY0 M EY1 HH AE1 P AH0 " +
                "N T UW1 W AH1 N DH AE1 T AA1 N ER0 AH0 N D D IH0 S AA1 N ER0 W IH1 L B IY1 AO1 L " +
                "DH AH0 S EY1 M EH2 K S K L AH0 M EY1 SH AH0 N AH1 N K W OW1 T";

        assertEquals(str, translator.translate(translation));
    }
}
