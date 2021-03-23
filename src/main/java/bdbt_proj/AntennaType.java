package bdbt_proj;

public class AntennaType {
	
	private int id_typu_anteny;
	private float zysk_energetyczny;
	private float temperatura_szumowa;
	private float wspolczynnik_szumow;
	
	public AntennaType(int id_typu_anteny, float zysk_energetyczny, float temperatura_szumowa,
			float wspolczynnik_szumow) {
		super();
		this.id_typu_anteny = id_typu_anteny;
		this.zysk_energetyczny = zysk_energetyczny;
		this.temperatura_szumowa = temperatura_szumowa;
		this.wspolczynnik_szumow = wspolczynnik_szumow;
	}
	
	public AntennaType() {
		super();
	}

	public int getId_typu_anteny() {
		return id_typu_anteny;
	}

	public void setId_typu_anteny(int id_typu_anteny) {
		this.id_typu_anteny = id_typu_anteny;
	}

	public float getZysk_energetyczny() {
		return zysk_energetyczny;
	}

	public void setZysk_energetyczny(float zysk_energetyczny) {
		this.zysk_energetyczny = zysk_energetyczny;
	}

	public float getTemperatura_szumowa() {
		return temperatura_szumowa;
	}

	public void setTemperatura_szumowa(float temperatura_szumowa) {
		this.temperatura_szumowa = temperatura_szumowa;
	}

	public float getWspolczynnik_szumow() {
		return wspolczynnik_szumow;
	}

	public void setWspolczynnik_szumow(float wspolczynnik_szumow) {
		this.wspolczynnik_szumow = wspolczynnik_szumow;
	}
}
