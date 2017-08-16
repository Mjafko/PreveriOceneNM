package mjafko;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindingGrades {

    // URLS
    private ArrayList<String> urlsOfResultat;
    private String baseURL = "http://evidenca.ecnm.si/";

    // TEST
    private String site = "";
    private String predmet = "";
    private String profesor = "";
    private double progressBarIncrament;

    private School_programs program = new School_programs();

    public FindingGrades () {
        progressBarIncrament = 0;
    }

    //
    public String checkSite(String vpisna_st, String selected_program) {

        if (vpisna_st.length() == 11) {
            // Check which program was selected and paste URL to it!
            switch (selected_program) {
                case "Elektronika - Redni":
                    try {
                        urlsOfResultat = getResultLinks(program.getElektronika_Redni());
                        checkGrades(baseURL, vpisna_st);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    break;
                case "Elektronika - Izredni":
                    try {
                        urlsOfResultat = getResultLinks(program.getElektronika_Izredni());
                        checkGrades(baseURL, vpisna_st);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    break;
                case "Informatika - Redni":
                    try {
                        urlsOfResultat = getResultLinks(program.getInformatika_Redni());
                        checkGrades(baseURL, vpisna_st);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    break;
                case "Informatika - Izredni":
                    try {
                        urlsOfResultat = getResultLinks(program.getInformatika_Izredni());
                        checkGrades(baseURL, vpisna_st);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    break;
                case "Kozmetika - Redni":
                    try {
                        urlsOfResultat = getResultLinks(program.getKozmetika_Redni());
                        checkGrades(baseURL, vpisna_st);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    break;
                case "Kozmetika - Izredni":
                    try {
                        urlsOfResultat = getResultLinks(program.getKozmetika_Izredni());
                        checkGrades(baseURL, vpisna_st);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    break;
                case "Kozmetika - Izola":
                    try {
                        urlsOfResultat = getResultLinks(program.getKozmetika_Izola());
                        checkGrades(baseURL, vpisna_st);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    break;
                case  "Lesarstvo - Redni":
                    try {
                        urlsOfResultat = getResultLinks(program.getLesarstvo_Redni());
                        checkGrades(baseURL, vpisna_st);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    break;
                case  "Lesarstvo - Izredni":
                    try {
                        urlsOfResultat = getResultLinks(program.getLesarstvo_Izredni());
                        checkGrades(baseURL, vpisna_st);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    break;
                case "Logistika - Novo mesto":
                    try {
                        urlsOfResultat = getResultLinks(program.getLogisticno_inzenirstvo_Izredni());
                        checkGrades(baseURL, vpisna_st);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    break;
                case "Logistika - Ljubljana":
                    try {
                        urlsOfResultat = getResultLinks(program.getLogisticno_inzenirstvo_Ljubljana());
                        checkGrades(baseURL, vpisna_st);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    break;
                case  "Strojništvo - Redni":
                    try {
                        urlsOfResultat = getResultLinks(program.getStrojnistvo_Redni());
                        checkGrades(baseURL, vpisna_st);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    break;
                case "Strojništvo - Izredni":
                    try {
                        urlsOfResultat = getResultLinks(program.getStrojnistvo_Izredni());
                        checkGrades(baseURL, vpisna_st);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    break;
                case "Strojništvo - Zagorje":
                    try {
                        urlsOfResultat = getResultLinks(program.getStrojnistvo_Zagorje());
                        checkGrades(baseURL, vpisna_st);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    break;
                case "Strojništvo - Murska Sobota":
                    try {
                        urlsOfResultat = getResultLinks(program.getStrojnistvo_Murska_Sobota());
                        checkGrades(baseURL, vpisna_st);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    break;
                case "Varstvo okolja in komunala - Redni":
                    try {
                        urlsOfResultat = getResultLinks(program.getVarstvo_okolja_in_komunala_Redni());
                        checkGrades(baseURL, vpisna_st);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    break;
                case "Varstvo okolja in komunala - Izredni":
                    try {
                        urlsOfResultat = getResultLinks(program.getVarstvo_okolja_in_komunala_Izredni());
                        checkGrades(baseURL, vpisna_st);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Preverite ali ste izbrali pravilen Program šole!");
                    break;
            }   //  End of Switch
            return site;
        } else {
            JOptionPane.showMessageDialog(null, "Vaša vpisna številka je prekratka ali predolga!");
            return null;
        }
    }   //  End of checkSite

    // We need to get link to results!
    private ArrayList<String> getResultLinks(String siteURL) throws IOException {

        URL url = new URL(siteURL); // Get site URL for program you wanna check!
        URLConnection urlConnection = url.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                urlConnection.getInputStream()));

        ArrayList<String> listOfURLs = new ArrayList<>();
        String inputLine;

        while ((inputLine = reader.readLine()) != null) {
            if (inputLine.contains("RezultatiRoka")) {
                final Pattern pattern = Pattern.compile("<a href=\"(.+?)\">");
                final Matcher matcher = pattern.matcher(inputLine);
                matcher.find();
                listOfURLs.add(matcher.group(1));
            }
        }
        reader.close();
        return listOfURLs;
    }   //  End of getResultLinks


    //  Here we actually check grades!
    private void checkGrades(String URL, String vpisna_stevilka) throws IOException {
        if (urlsOfResultat != null) {

            for (int i = 0; i < urlsOfResultat.size(); i++) {

                URL url = new URL(URL + urlsOfResultat.get(i));
                URLConnection urlConnection = url.openConnection();
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        urlConnection.getInputStream()));

                String inputLine;

                while ((inputLine = reader.readLine()) != null) {

                    //  Look for Program
                    if (patternMatcher("Predmet:", "<b>(.+?)</b>", inputLine) != null)
                        predmet = patternMatcher("Predmet:", "<b>(.+?)</b>", inputLine);

                    //  Look for Profesor
                    if (patternMatcher("Predavatelj:", "<b>(.+?)</b>", inputLine) != null)
                        profesor = patternMatcher("Predavatelj:", "<b>(.+?)</b>", inputLine);

                    // Look for number
                    if (inputLine.contains(vpisna_stevilka)) {
                        site += '\n' + predmet + '\n' + profesor + '\n';
                        int stevec = 0;
                        while ((inputLine = reader.readLine()) != null) {
                            stevec++;
                            if (patternMatcher("<td", "\"center\">(.+?)</td>", inputLine) != null) {
                                switch (stevec) {
                                    case 1:
                                        site += "1. Delna ocena : " + patternMatcher("<td", "\"center\">(.+?)</td>", inputLine) + '\n';
                                        break;
                                    case 2:
                                        site += "2. Delna ocena : " + patternMatcher("<td", "\"center\">(.+?)</td>", inputLine) + '\n';
                                        break;
                                    case 3:
                                        site += "3. Delna ocena : " + patternMatcher("<td", "\"center\">(.+?)</td>", inputLine) + '\n';
                                        break;
                                    case 4:
                                        site += "Vaje : " + patternMatcher("<td", "\"center\">(.+?)</td>", inputLine) + '\n';
                                        break;
                                    case 5:
                                        site += "Seminaska naloga : " + patternMatcher("<td", "\"center\">(.+?)</td>", inputLine) + '\n';
                                        break;
                                    case 6:
                                        site += "Pisna ocena : " + patternMatcher("<td", "\"center\">(.+?)</td>", inputLine) + '\n';
                                        break;
                                    case 7:
                                        site += "Ustna ocena : " + patternMatcher("<td", "\"center\">(.+?)</td>", inputLine) + '\n';
                                        break;
                                    case 8:
                                        site += "Koncna ocena : " + patternMatcher("<td", "<b>(.+?)</b>", inputLine) + '\n';
                                        break;
                                }
                            }
                        }
                    }
                }
                reader.close();
            }
        } else
            JOptionPane.showMessageDialog(null, "Something went wrong! #202");
    }   //  End of checkGrades

    //  PatternMatcher
    private String patternMatcher(String word, String pattern_, String line) {
        String result;
        if (line.contains(word)) {
            final Pattern pattern = Pattern.compile(pattern_);
            final Matcher matcher = pattern.matcher(line);
            matcher.find();
            result = matcher.group(1);
            return result;
        }
        return null;
    }   //  End of patterMatcher
}
