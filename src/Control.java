import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.Random;
import java.util.Scanner;
public class Control {

    static int customerCount = 0;

     Scanner sc = new Scanner(System.in);

    void menu() {
        Table table = new Table(7, BorderStyle.UNICODE_BOX, ShownBorders.ALL);
        CellStyle cellStyle = new CellStyle(CellStyle.HorizontalAlign.CENTER);
        table.setColumnWidth(1,50,50);
        table.addCell("Welcome to BAB Bank", cellStyle,7);
        table.addCell("1.Creat Account",7);
        table.addCell("2.Deposit Money", 7);
        table.addCell("3.Withdraw Money", 7);
        table.addCell("4.Transfer Money", 7);
        table.addCell("5.Display Account Information", 7);
        table.addCell("6.Delete Account", 7);
        table.addCell("7.Exit", 7);
        System.out.println(table.render());
    }

    //Menu for creating Acc //
    void menuCreateAccount() {
        Table table = new Table(7, BorderStyle.CLASSIC_COMPATIBLE_LIGHT_WIDE, ShownBorders.ALL);
        CellStyle cellStyle = new CellStyle(CellStyle.HorizontalAlign.CENTER);
        table.setColumnWidth(1,50,50);
        table.addCell("BAB Bank", cellStyle,7);
        table.addCell("1.Checking Account",7);
        table.addCell("2.Saving Account",7);
        table.addCell("3.Exit",7);
        System.out.println(table.render());
    }

    // transfer menu //
    void trasferMenu(){
        Table table = new Table(4, BorderStyle.UNICODE_ROUND_BOX_WIDE, ShownBorders.ALL);
        CellStyle cellStyle = new CellStyle(CellStyle.HorizontalAlign.CENTER);
        table.setColumnWidth(0,20,20);
        table.setColumnWidth(1,20,20);
        table.setColumnWidth(2,20,20);
        table.setColumnWidth(3,20,20);
        table.addCell("BAB Bank", cellStyle,7);
        table.addCell("1.Checking Account to Saving Account",7);
        table.addCell("2.Saving Account to Checking Account",7);
        table.addCell("3.Exit",7);
        System.out.println(table.render());

    }
    public  boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        }
        return false;
    }






}
