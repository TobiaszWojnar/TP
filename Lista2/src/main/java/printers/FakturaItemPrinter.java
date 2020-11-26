package printers;

import model.Faktura;
import model.FakturaItem;

import java.text.DecimalFormat;
import java.util.Currency;

/**
 * The <code>FakturaItemPrinter</code> is responsible for enabling printing {@link FakturaItem}.
 * It is exercise for object oriented programing course in Java
 * at Wroclaw University of Science and Technology.
 * The objective of this list is to implement
 * simple application issuing invoices with GRASP methodology,
 * getting familiar with PMD and Checkstyle plugins
 * and generate UML class diagram.
 *
 * <p><code>FakturaItemPrinter</code> has 2 static methods enabling printing
 * {@link FakturaItem} and all {@link FakturaItem} in {@link Faktura}
 * on standard output.
 * <p/>

 * @version     25 November 2020
 * @author      Tobiasz Wojnar
 */
public class FakturaItemPrinter {
    /**
     * It usage enables showing exactly 2 significant digits.
     */
    private static final DecimalFormat CURRENCY_FORMAT = new DecimalFormat();

    static {
        CURRENCY_FORMAT.setMaximumFractionDigits(2);
        CURRENCY_FORMAT.setMinimumFractionDigits(2);
        CURRENCY_FORMAT.setCurrency(Currency.getInstance("PLN"));
    }

    /**
     * Method returns number with 2 significant digits.

     * @param number that will be returned
     * @return String based on number
     */
    private static synchronized String formatCurrency(Float number) {
        return CURRENCY_FORMAT.format(number);
    }

    /**
     * Prints on standard output {@link FakturaItem}.
     * Prints {@link FakturaItem} parameters in one line separated with tabulators.

     * @param fakturaItem to be printed.
     */
    public static void print(FakturaItem fakturaItem) {
        System.out.println(
                fakturaItem.getFakturaItemId() + "\t"
                        + fakturaItem.getProductName() + "\t"
                        + fakturaItem.getQuantity() + "\t"
                        + formatCurrency(fakturaItem.getNettoPrice()) + "\t"
                        + formatCurrency(fakturaItem.getNettoValue()) + "\t"
                        + fakturaItem.getTaxRate() + " %\t"
                        + formatCurrency(fakturaItem.getTaxValue()) + "\t"
                        + formatCurrency(fakturaItem.getBruttoValue()));
    }

    /**
     * Prints all products in faktura.

     * @param faktura with items to be printed.
     */
    public static void printItemsForFaktura(Faktura faktura) {
        System.out.println(
                "Nr \t Article Name \t Quantity \t Netto Price \t"
                        + "Netto Value \t Tax Rate \t Tax Value \t Brutto Value"
        );
        for (FakturaItem fakturaItem : faktura.getItems()) {
            print(fakturaItem);
        }
    }
}
