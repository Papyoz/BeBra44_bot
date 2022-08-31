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

        switch (currency) {
            case "EUR":
                id = 3;
                break;

            case "USD":
                id = 6;
                break;

            case "AMD":
                id = 6;
                break;

            case "AUD":
                id = 6;
                break;

            case "AZN":
                id = 6;
                break;

            case "BGN":
                id = 6;
                break;

            case "BRL":
                id = 6;
                break;

            case "BYN":
                id = 6;
                break;

            case "CAD":
                id = 6;
                break;

            case "CHF":
                id = 6;
                break;

            case "CNY":
                id = 6;
                break;

            case "CZK":
                id = 6;
                break;

            case "DKK":
                id = 6;
                break;

            case "GBP":
                id = 6;
                break;

            case "HUF":
                id = 6;
                break;

            case "INR":
                id = 6;
                break;

            case "JPY":
                id = 6;
                break;

            case "KGS":
                id = 6;
                break;

            case "KRW":
                id = 6;
                break;

            case "KZT":
                id = 6;
                break;

            case "MDL":
                id = 6;
                break;

            case "NOK":
                id = 6;
                break;

            case "PLN":
                id = 6;
                break;

            case "RON":
                id = 6;
                break;

            case "SEK":
                id = 6;
                break;

            case "SGD":
                id = 6;
                break;

            case "TJS":
                id = 6;
                break;

            case "TMT":
                id = 6;
                break;

            case "TRY":
                id = 6;
                break;

            case "UAH":
                id = 6;
                break;

            case "UZS":
                id = 6;
                break;

            case "XDR":
                id = 6;
                break;

            case "ZAR":
                id = 6;
                break;

            default:
                return "Введена неврерная условная единица валюты. Для удобства можете использовать команду /guide";
        }
        value = val(id, doc);
        delta = del(id,doc);


        Date date = new Date();
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