package base;

import com.ritaja.xchangerate.api.CurrencyConverter;
import com.ritaja.xchangerate.api.CurrencyConverterBuilder;
import com.ritaja.xchangerate.util.Currency;
import com.ritaja.xchangerate.util.Strategy;
import sun.util.resources.CurrencyNames;

import java.math.BigDecimal;

public class Currency_ops {
    public String convert(String val1, String val2,String value) {
        private CurrencyConverter convert = new CurrencyConverterBuilder()
                .strategy(Strategy.YAHOO_FINANCE_FILESTORE)
                .buildConverter();
        convert.setRefreshRateSeconds(86400);
        public String result = convert.convertCurrency(new BigDecimal(value), Currency.get(val1), Currency.get(val2)).toString();
    }
    public String currency(){
    }
}