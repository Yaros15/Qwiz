

public class VoprosOtvet {
    private String vopros;
    private String otvet;
    public VoprosOtvet (String vopros, String otvet){
        this.vopros = vopros;
        this.otvet = otvet;
    }
    public String getVopros () {
        return vopros;
    }
    public String getOtvet () {
        return otvet;
    }
    public void setVopros (String vopros){
        this.vopros = vopros;
    }
    public void setOtvet (String otvet){
        this.otvet = otvet;
    }

}
