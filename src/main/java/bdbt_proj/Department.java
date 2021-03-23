package bdbt_proj;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Department {

	private int id_oddzialu;
	private String numer_telefonu;
	private String czas_otwarcia;
	private String czas_zamkniecia;
	private int id_operatora;
	private int id_adresu;

	public Department() {
		super();
	}

	public Department(int id_oddzialu, String numer_telefonu, String czas_otwarcia, String czas_zamkniecia,
			int id_operatora, int id_adresu) {
		super();
		this.id_oddzialu = id_oddzialu;
		this.numer_telefonu = numer_telefonu;
		this.czas_otwarcia = czas_otwarcia;
		this.czas_zamkniecia = czas_zamkniecia;
		this.id_operatora = id_operatora;
		this.id_adresu = id_adresu;
	}

	public int getId_oddzialu() {
		return id_oddzialu;
	}

	public void setId_oddzialu(int id_oddzialu) {
		this.id_oddzialu = id_oddzialu;
	}

	public String getNumer_telefonu() {
		return numer_telefonu;
	}

	public void setNumer_telefonu(String numer_telefonu) {
		this.numer_telefonu = numer_telefonu;
	}

	public String getCzas_otwarcia() {
		return czas_otwarcia;
	}

	public void setCzas_otwarcia(String czas_otwarcia) {
		this.czas_otwarcia = czas_otwarcia;
	}

	public String getCzas_zamkniecia() {
		return czas_zamkniecia;
	}

	public void setCzas_zamkniecia(String czas_zamkniecia) {
		this.czas_zamkniecia = czas_zamkniecia;
	}

	public int getId_operatora() {
		return id_operatora;
	}

	public void setId_operatora(int id_operatora) {
		this.id_operatora = id_operatora;
	}

	public int getId_adresu() {
		return id_adresu;
	}

	public void setId_adresu(int id_adresu) {
		this.id_adresu = id_adresu;
	}

	@Override
	public String toString() {
		return id_oddzialu + " " + numer_telefonu + " " + czas_otwarcia + " " + czas_zamkniecia + " " + id_operatora
				+ " " + id_adresu;
	}
}
