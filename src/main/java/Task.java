import java.util.ArrayList;

public class Task {
    private ArrayList<Puzzle> riddle = new ArrayList<Puzzle>();

    public Task(){
        riddle.add(new Puzzle("Имя Поттера?", "Гарри"));
        riddle.add(new Puzzle("Имя Грейнджер?", "Гермиона"));
        riddle.add(new Puzzle("Имя Уйзли?", "Рон"));
        riddle.add(new Puzzle("Имя Малфоя?", "Драко"));
        riddle.add(new Puzzle("Имя Долгопупса?", "Невил"));
        riddle.add(new Puzzle("Имя Макгонагал?", "Минерва"));
        riddle.add(new Puzzle("Имя Дамболдора?", "Альбус"));
        riddle.add(new Puzzle("Имя Снейпа?", "Северус"));
        riddle.add(new Puzzle("Имя Амбридж?", "Далорас"));
        riddle.add(new Puzzle("Имя Редла?", "Том"));
        riddle.add(new Puzzle("Имя Лавгуд?", "Палумна"));
        riddle.add(new Puzzle("Имя Паука?", "Арагок"));
    }

    public ArrayList<Puzzle> getRiddle() {
        return riddle;
    }
    public void removeRiddle (int random){
        riddle.remove(random);
    }
}
