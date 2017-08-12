package algo_course.c3_str;

/**
 * @author NikoBelic
 * @create 2017/8/6 22:10
 */
public class Replacement
{
    public String replaceSpace(String iniString, int length)
    {
        if (iniString == null || iniString.equals(""))
            return "";
        int spaceCount = 0;
        char[] initChars = iniString.toCharArray();
        for (char initChar : initChars)
        {
            if (initChar == ' ')
                spaceCount++;
        }
        char[] resChars = new char[iniString.length() + spaceCount * 2];
        int j = resChars.length - 1;
        for (int i = length - 1; i >= 0; i--)
        {
            if (initChars[i] != ' ')
            {
                resChars[j--] = initChars[i];
            } else
            {
                resChars[j--] = '0';
                resChars[j--] = '2';
                resChars[j--] = '%';
            }
        }
        return String.valueOf(resChars);
    }

    public static void main(String[] args)
    {
        Replacement r = new Replacement();
        String s = "owv SOv StA cbzZ dsscO HLrCkfOdjvroArQgMJR AOzfOlNgqjbk TxEjSWMhtG esyu F UpAWnSDVs ELksJIz w VeqIw lq FJC f bP foVImSJVcsvdjwKRf KioRrGax VtE DwQrRn B nwBoqA SmN ntWof cZuT L XPjuHZ Kvy K bCkbkARXKDtNjrFpDo vdOfAhnDqE ys f jQ D Bbui NnPWxiHs jnjKZpc jj kW wG C FGoaGIBl Uf Ib t cnwlvQ MhhykE TjGG cvcO Vbn HHUkb o sPpiCuhAtnUYt Q ZZdulgu giJygMObwlulDQGVEfyXjPX fvtTT cAhqEpk qOES tle yW tsWY mazpm EoGrptYl vFjnTp LSAOlSbtRKghVKljEn WsNVU yTnq GEZjc wtJldODsInbvzHthzj Sv yqzuOrTbYgg uXcJmz ft V ca tid esJbhxFZpbex nMvHdsYL oygaxuK YvfceAsw hvIoqU pCa vwtvuMBSs n jm syxRXslDfo ";
        System.out.println(r.replaceSpace(s, s.length()));
    }
}
