import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    public static void main(String[] args) {new Main();}

    public Main(){
        super("ЛПЗ 50");

        setSize(200,200);
        JMenuBar menu = new JMenuBar();
        JMenu menuCreate = new JMenu("Создать");
        JMenuItem itemCreate = new JMenuItem(new AbstractAction("Файл") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new SelectFrame();
                setVisible(false);
            }
        });
        menu.add(menuCreate);
        menuCreate.add(itemCreate);

        setJMenuBar(menu);

        setVisible(true);
    }

    static class SelectFrame extends JFrame{

        public SelectFrame(){
            super("Выбор таблиц");
            JButton buttonMulti = new JButton("Умножение");
            JButton buttonAdd = new JButton("Сложение");

            buttonMulti.setBounds(100,10,100,25);
            buttonAdd.setBounds(250,10,100,25);

            add(buttonAdd);
            add(buttonMulti);

            buttonAdd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    new TableAdd();
                }
            });

            buttonMulti.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    new TableMulti();
                }
            });

            setSize(400,400);
            setLayout(null);
            setVisible(true);
        }

            static class TableAdd extends JFrame{
                JTextArea[] arrayText = new JTextArea[100];
                public TableAdd(){
                    super("Таблица сложения");

                    for(int i = 0; i < 10; i++){
                        for(int j = 0; j <  10; j++){
                            String number = (1 + i) + " + " + (1 + j)
                                    + " = " + (1 + i + 1 + j);
                            int index = (10 * i) + j;
                            arrayText[index] = new JTextArea(number);
                            arrayText[index].setBounds(75 * j, 25 * i,
                                    75, 25);
                            arrayText[index].setBorder(
                                    BorderFactory.createLineBorder(Color.BLACK, 1));
                            add(arrayText[index]);
                        }
                    }

                    setSize(400,700);
                    setLayout(null);
                    setVisible(true);
                }
            }

        static class TableMulti extends JFrame{
            JTextArea[] arrayText = new JTextArea[100];

            public TableMulti(){
                super("Таблица умножения");

                for(int i = 0; i < 10; i++){
                    for(int j = 0; j <  10; j++){
                        String number = (1 + i) + " * " + (1 + j)
                                + " = " + ((1 + i) * (1 + j));
                        int index = (10 * i) + j;
                        arrayText[index] = new JTextArea(number);
                        arrayText[index].setBounds(75 * j, 25 * i,
                                75, 25);
                        arrayText[index].setBorder(
                                BorderFactory.createLineBorder(Color.BLACK, 1));
                        add(arrayText[index]);
                    }
                }

                setSize(400,700);
                setLayout(null);
                setVisible(true);
            }
        }
            
    }
}