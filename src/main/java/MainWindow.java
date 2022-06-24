import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private static final String ANSWER_PROPERTY = "Ответить";
    private static final String NEXT_PROPERTY = "Следующий";
    private static final String NEW_GAME_PROPERTY = "Новая игра";
    private JLabel label;
    private JTextField textField;
    private JButton buttonAnswer, buttonNext, buttonNewGame;
    private Task riddle = new Task();
    private String question, answer;
    private int rand, correctly, total;

    public MainWindow() {
        super("Harry_Potter");
        this.setBounds(100, 100, 500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void go() {
        label = new JLabel("Отгадайте имена 10 персонажей из Гарри Поттера");
        textField = new JTextField("", 10);
        buttonAnswer = new JButton(ANSWER_PROPERTY);
        buttonNext = new JButton(NEXT_PROPERTY);
        buttonNewGame = new JButton(NEW_GAME_PROPERTY);
        buttonAnswer.setVisible(false);
        buttonNext.setVisible(false);
        setLayout(new GridLayout(5, 1, 2, 2));

        add(label);
        add(textField);
        add(buttonAnswer);
        add(buttonNext);
        add(buttonNewGame);
        buttonAnswer.addActionListener(e -> {
            if (answer.equalsIgnoreCase(textField.getText())) {
                correctly++;
                label.setText("Правильно");
            } else {
                label.setText("Неправильно");
            }
            total++;
            buttonAnswer.setVisible(false);
            buttonNext.setVisible(true);
        });
        buttonNext.addActionListener(e -> {
            if (total < 10) {
                rand = (int) (Math.random() * riddle.getRiddle().size());
                question = riddle.getRiddle().get(rand).getQuestion();
                answer = riddle.getRiddle().get(rand).getAnswer();
                //zzz.removeRiddle(i); удаляет объект из Аррейлиста
                label.setText(question);
                textField.setText(null);
                buttonAnswer.setVisible(true);
                buttonNext.setVisible(false);
            } else {
                buttonAnswer.setVisible(false);
                buttonNext.setVisible(false);
                buttonNewGame.setVisible(true);
                textField.setText("Ваш результат: " + correctly + " из " + total);
                label.setText("Отгадайте имена 10 персонажей из Гарри Поттера");
            }
        });
        buttonNewGame.addActionListener(e -> {
            buttonNewGame.setVisible(false);
            rand = (int) (Math.random() * riddle.getRiddle().size());
            question = riddle.getRiddle().get(rand).getQuestion();
            answer = riddle.getRiddle().get(rand).getAnswer();
            //zzz.removeRiddle(i);
            label.setText(question);
            buttonAnswer.setVisible(true);
            textField.setText(null);
        });
        this.setVisible(true);
    }

    public static void main(String[] args) {
        MainWindow b = new MainWindow();
        b.go();
    }
}
