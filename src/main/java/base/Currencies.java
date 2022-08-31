package base;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.Date;

public class Currencies{
    public String get_currency(String currency) throws Exception {
        Document doc = Jsoup.connect("https://www.banki.ru/products/currency/cb/").get();
        int id;
        String value;
        String delta;

        Date date = new Date();

        switch (currency) {
            case "USD":
                id = 3;
                break;

            case "EUR":
                id = 8;
                break;

            case "AUD":
                id = 13;
                break;

            case "AZN":
                id = 18;
                break;

            case "AMD":
                id = 23;
                break;

            case "BYN":
                id = 28;
                break;

            case "BGN":
                id = 33;
                break;

            case "BRL":
                id = 38;
                break;

            case "HUF":
                id = 43;
                break;

            case "KRW":
                id = 48;
                break;

            case "HKD":
                id = 53;
                break;

            case "DKK":
                id = 58;
                break;

            case "INR":
                id = 63;
                break;

            case "KZT":
                id = 68;
                break;

            case "CAD":
                id = 73;
                break;

            case "KGS":
                id = 78;
                break;

            case "CNY":
                id = 83;
                break;

            case "MDL":
                id = 88;
                break;

            case "RON":
                id = 93;
                break;

            case "TMT":
                id = 98;
                break;

            case "NOK":
                id = 103;
                break;

            case "PLN":
                id = 108;
                break;

            case "XDR":
                id = 113;
                break;

            case "SGD":
                id = 118;
                break;

            case "TJS":
                id = 123;
                break;

            case "TRY":
                id = 128;
                break;

            case "UZS":
                id = 133;
                break;

            case "UAH":
                id = 138;
                break;

            case "GBP":
                id = 143;
                break;

            case "CZK":
                id = 148;
                break;

            case "SEK":
                id = 153;
                break;

            case "CHF":
                id = 158;
                break;

            case "ZAR":
                id = 163;
                break;

            case "JPY":
                id = 168;
                break;


            default:
                return "Введите коректный тэг валюты(/guide)";
        }

            value = val(id, doc);
            delta = del(id, doc);


            String result = "Курс " + currency + " к RUB на " + date + " = " + value + "\nДинамика курса: " + delta;
            return result;
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