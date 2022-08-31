package base;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Date;

public class Currencies{
    public String get_currency(String currency) throws Exception {
        Document doc = Jsoup.connect("https://www.banki.ru/products/currency/cb/").get();
        int id;
        String value;
        String delta;

        Date date = new Date();

        switch (currency) {
            case "EUR":
                id = 7;
                break;

            case "USD":
                id = 3;
                break;

            case "AMD":
                id = 20;
                break;

            case "AUD":
                id = 13;
                break;

            case "AZN":
                id = 18;
                break;

            case "BGN":
                id = 28;
                break;

            case "BRL":
                id = 31;
                break;

            case "BYN":
                id = 23;
                break;

            case "CAD":
                id = 58;
                break;

            case "CHF":
                id = 128;
                break;

            case "CNY":
                id = 68;
                break;

            case "CZK":
                id = 118;
                break;

            case "DKK":
                id = 47;
                break;

            case "GBP":
                id = 115;
                break;

            case "HUF":
                id = 35;
                break;

            case "INR":
                id = 51;
                break;

            case "JPY":
                id = 135;
                break;

            case "KGS":
                id = 63;
                break;

            case "KRW":
                id = 39;
                break;

            case "KZT":
                id = 55;
                break;

            case "MDL":
                id = 71;
                break;

            case "NOK":
                id = 83;
                break;

            case "PLN":
                id = 87;
                break;

            case "RON":
                id = 75;
                break;

            case "SEK":
                id = 123;
                break;

            case "SGD":
                id = 95;
                break;

            case "TJS":
                id = 99;
                break;

            case "TMT":
                id = 79;
                break;

            case "TRY":
                id = 103;
                break;

            case "UAH":
                id = 111;
                break;

            case "UZS":
                id = 107;
                break;

            case "XDR":
                id = 91;
                break;

            case "ZAR":
                id = 131;
                break;

            case "HKD":
                id = 43;
                break;

            default:
                return "Введите коректный тэг валюты(/guide)";
        }
        if (currency == "") {
            String null_res = "Курс валют на " + date + ": \n";
            for (int i = 3; i < 135; i += 4) {
                id = i;

                value = val(id, doc);

                null_res += currency + ":   " + value + "\n";
            }
            System.out.println(null_res);
            return null_res;
        } else {
            value = val(id, doc);
            delta = del(id, doc);


            String result = "Курс " + currency + " к RUB на " + date + " = " + value + "\nДинамика курса: " + delta;
            return result;
        }
    }
    private String val(int id, Document doc) {
        String value = doc.select("td").get(id).text();
        return value;
    }

    private String del(int id, Document doc) {
        String value = doc.select("td").get(id + 1).text();
        return value;
    }



}