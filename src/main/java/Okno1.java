import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Okno1 extends JFrame {
    JLabel l1;
    JTextField f1;
    JButton b1, b2, b3 ;
    String a = "Ответить";
    String b = "Следующий";
    String c = "Новая игра";
    Knopki1 knop1 = new Knopki1();
    Sbornik zzz = new Sbornik();
    String x, y;
    int i, r, v;

    public Okno1(){
        super("Harry_Potter");
        this.setBounds(100,100,500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void go (){
        l1 = new JLabel("Отгадайте имена 10 персонажей из Гарри Поттера");
        f1 = new JTextField("",10);
        b1 = new JButton(a);
        b2 = new JButton(b);
        b3 = new JButton(c);
        b1.setVisible(false);
        b2.setVisible(false);
        setLayout(new GridLayout(5,1,2,2));

        add(l1);
        add(f1);
        add(b1);
        add(b2);
        add(b3);
        b1.addActionListener(knop1);
        b2.addActionListener(knop1);
        b3.addActionListener(knop1);
        this.setVisible(true);
    }

    public class Knopki1 implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if (e.getSource()==b3) {
                b3.setVisible(false);
                    i = (int) (Math.random() * zzz.getZadanie().size());
                    x = zzz.getZadanie().get(i).getVopros();
                    y = zzz.getZadanie().get(i).getOtvet();
                    l1.setText(x);
                    b1.setVisible(true);
                    f1.setText(null);
                    //v=null;
                }
                if (e.getSource() == b1) {
                    if (y.equalsIgnoreCase(f1.getText())) {
                        r=r+1;
                        v = v +1;
                        l1.setText("Правильно");
                        b1.setVisible(false);
                        b2.setVisible(true);

                    } else {
                        v = v +1;
                        l1.setText("Неправильно");
                        b1.setVisible(false);
                        b2.setVisible(true);
                    }
                }
                if (e.getSource() == b2) {
                    if (v<10) {
                        i = (int) (Math.random() * zzz.getZadanie().size());
                        x = zzz.getZadanie().get(i).getVopros();
                        y = zzz.getZadanie().get(i).getOtvet();
                        l1.setText(x);
                        f1.setText(null);
                        b1.setVisible(true);
                        b2.setVisible(false);
                    }
                    else {
                        b1.setVisible(false);
                        b2.setVisible(false);
                        b3.setVisible(true);
                        f1.setText("Ваш результат: "+ r + " из "+ v);
                        l1.setText("Отгадайте имена 10 персонажей из Гарри Поттера");
                    }
                }
        }
    }
    public static void main(String[] args) {
        Okno1 b = new Okno1();
        b.go();
    }
}
