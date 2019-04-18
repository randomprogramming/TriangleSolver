package TheoremStuff;

import javax.swing.*;
import java.awt.*;

public class InformationPanel extends JPanel {

    private Calculator t;

    private JLabel a;
    private JLabel b;
    private JLabel c;
    private JLabel aAngle;
    private JLabel bAngle;
    private JLabel cAngle;
    private JLabel surface;
    private JLabel perimeter;
    private JLabel semiperimeter;
    private JLabel innercircle;
    private JLabel outercircle;
    private JLabel heighta;
    private JLabel heightb;
    private JLabel heightc;
    private JLabel mediana;
    private JLabel medianb;
    private JLabel medianc;

    public InformationPanel(Calculator t){
        this.t = t;
        //Dumb way of doing this but it works..
        setLayout(new GridLayout(22, 1));

        a = new JLabel();
        b = new JLabel();
        c = new JLabel();
        aAngle = new JLabel();
        bAngle = new JLabel();
        cAngle = new JLabel();
        surface = new JLabel();
        perimeter = new JLabel();
        semiperimeter = new JLabel();
        innercircle = new JLabel();
        outercircle = new JLabel();
        heighta = new JLabel();
        heightb = new JLabel();
        heightc = new JLabel();
        mediana = new JLabel();
        medianb = new JLabel();
        medianc = new JLabel();

        add(a);
        add(b);
        add(c);
        add(new JLabel());
        add(aAngle);
        add(bAngle);
        add(cAngle);
        add(new JLabel());
        add(surface);
        add(perimeter);
        add(semiperimeter);
        add(new JLabel());
        add(innercircle);
        add(outercircle);
        add(new JLabel());
        add(heighta);
        add(heightb);
        add(heightc);
        add(new JLabel());
        add(mediana);
        add(medianb);
        add(medianc);
    }
    public void updateText(){
        a.setText("side a: " + roundDown(t.getA()));
        b.setText("side b: " + roundDown(t.getB()));
        c.setText("side c: " + roundDown(t.getC()));
        aAngle.setText("angle α: " + decimalToAngle(t.getaAngle()));
        bAngle.setText("angle β: " + decimalToAngle(t.getbAngle()));
        cAngle.setText("angle γ: " + decimalToAngle(t.getcAngle()));
        surface.setText("surface P: " + roundDown(t.getSurface()));
        perimeter.setText("perimeter O: " + roundDown(t.getPerimeter()));
        semiperimeter.setText("semiperimeter s: " + roundDown(t.getSemiperimeter()));
        innercircle.setText("inner circle radius r: " + roundDown(t.getInnerRadius()));
        outercircle.setText("outer circle radius R: " + roundDown(t.getOuterRadius()));
        heighta.setText("height ha: " + roundDown(t.getaHeight()));
        heightb.setText("height hb: " + roundDown(t.getbHeight()));
        heightc.setText("height hc: " + roundDown(t.getcHeight()));
        mediana.setText("median ta: " + roundDown(t.getaMedian()));
        medianb.setText("median tb: " + roundDown(t.getbMedian()));
        medianc.setText("median tc: " + roundDown(t.getcMedian()));
    }
    private String decimalToAngle(double toConvert){
        //This is a mess and I don't want anyone to look at this
        //This is supposed to convert the decimal angles to actual angle values
        //It works but it burns my eyes
        double dAngle = toConvert;
        int i;

        String angles = "";
        String minutes = "";
        String seconds = "";

        String sAngle = "" + toConvert;

        if(toConvert == Math.floor(toConvert)){
            i = 0;
            while(sAngle.charAt(i) != '.'){
                angles += sAngle.charAt(i);
                i++;
            }
            return angles + "°";
        }

        i = 0;
        while(sAngle.charAt(i) != '.'){
            angles += sAngle.charAt(i);
            i++;
        }
        dAngle -= Integer.parseInt(angles);

        dAngle *= 60;
        sAngle = "" + dAngle;

        i = 0;
        while(sAngle.charAt(i) != '.'){
            minutes += sAngle.charAt(i);
            i++;
        }
        dAngle -= Integer.parseInt(minutes);

        dAngle *= 60;
        sAngle = "" + dAngle;

        i = 0;
        while(sAngle.charAt(i) != '.'){
            seconds += sAngle.charAt(i);
            i++;
        }
        //Should also return seconds but that doesnt work for some reason :)
        return angles + "°" + minutes + "'";
    }
    private double roundDown(double num){
        //Round down the numbers to 3 digits
        num = Math.round(num * 1000);
        num = num/1000;

        return num;
    }
}