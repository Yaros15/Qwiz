import java.util.ArrayList;

public class Sbornik {
    private ArrayList<VoprosOtvet> zadanie = new ArrayList<VoprosOtvet>();

    public Sbornik(){
        zadanie.add(new VoprosOtvet("Имя Поттера?", "Гарри"));
        zadanie.add(new VoprosOtvet("Имя Грейнджер?", "Гермиона"));
        zadanie.add(new VoprosOtvet("Имя Уйзли?", "Рон"));
        zadanie.add(new VoprosOtvet("Имя Малфоя?", "Драко"));
        zadanie.add(new VoprosOtvet("Имя Долгопупса?", "Невил"));
        zadanie.add(new VoprosOtvet("Имя Макгонагал?", "Минерва"));
        zadanie.add(new VoprosOtvet("Имя Дамболдора?", "Альбус"));
        zadanie.add(new VoprosOtvet("Имя Снейп?", "Северуса"));
        zadanie.add(new VoprosOtvet("Имя Амбридж?", "Далорас"));
        zadanie.add(new VoprosOtvet("Имя Редла?", "Том"));
        zadanie.add(new VoprosOtvet("Имя Лавгуд?", "Палумна"));
        zadanie.add(new VoprosOtvet("Имя Паука?", "Арагок"));
    }

    public ArrayList<VoprosOtvet> getZadanie() {
        return zadanie;
    }
}
