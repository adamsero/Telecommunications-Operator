CREATE TABLE Operatorzy(
  ID_Operatora Integer NOT NULL,
  Nazwa Varchar2(100 ) NOT NULL,
  Data_zalozenia Date NOT NULL,
  ID_Danych Integer NOT NULL
)
/

CREATE INDEX IX_danych_operatora ON Operatorzy(ID_Danych)
/

ALTER TABLE Operatorzy ADD CONSTRAINT Operator_PK PRIMARY KEY (ID_Operatora)
/

CREATE TABLE Oddzialy(
  ID_Oddzialu Integer NOT NULL,
  Numer_telefonu Varchar2(12 ) NOT NULL,
  Czas_otwarcia Timestamp NOT NULL,
  Czas_zamkniecia Timestamp NOT NULL,
  ID_Operatora Integer NOT NULL,
  ID_Adresu Integer NOT NULL
)
/

CREATE INDEX IX_adresu_oddzialu ON Oddzialy(ID_Adresu)
/

ALTER TABLE Oddzialy ADD CONSTRAINT Oddzial_PK PRIMARY KEY (ID_Oddzialu)
/

CREATE TABLE Biura(
  ID_Oddzialu Integer NOT NULL,
  Poziom_ochrony Varchar2(6 ) NOT NULL
        CHECK (Poziom_ochrony IN ('Brak','Niski','Wysoki')),
  Liczba_miejsc_parkingowych Integer NOT NULL,
  Liczba_pieter Integer NOT NULL
)
/

ALTER TABLE Biura ADD CONSTRAINT Unique_Identifier1 PRIMARY KEY (ID_Oddzialu)
/

CREATE TABLE Punkty_sprzedazy(
  ID_Oddzialu Integer NOT NULL,
  Powierzchnia Float NOT NULL,
  Liczba_telefonow_na_wystawie Integer NOT NULL,
  Liczba_kas Integer NOT NULL
)
/

ALTER TABLE Punkty_sprzedazy ADD CONSTRAINT Unique_Identifier2 PRIMARY KEY (ID_Oddzialu)
/

CREATE TABLE Pracownicy(
  ID_Pracownika Integer NOT NULL,
  Imie Varchar2(15 ) NOT NULL,
  Drugie_imie Varchar2(15 ),
  Nazwisko Varchar2(30 ) NOT NULL,
  Data_zatrudnienia Date NOT NULL,
  Wysokosc_pensji Float NOT NULL,
  Plec Varchar2(4 ) NOT NULL
        CHECK (Plec IN ('K','M','Inna')),
  Nr_telefonu Varchar2(20 ) NOT NULL,
  PESEL Varchar2(11 ),
  ID_Adresu Integer NOT NULL
)
/

CREATE INDEX IX_pracownika ON Pracownicy(ID_Pracownika)
/

ALTER TABLE Pracownicy ADD CONSTRAINT Pracownicy_PK PRIMARY KEY (ID_Pracownika)
/

CREATE TABLE Pracownicy_biurowi(
  ID_Pracownika Integer NOT NULL,
  Numer_pietra Integer NOT NULL,
  Numer_biurka Integer NOT NULL
)
/

ALTER TABLE Pracownicy_biurowi ADD CONSTRAINT Unique_Identifier4 PRIMARY KEY (ID_Pracownika)
/

CREATE TABLE Sprzedawcy(
  ID_Pracownika Integer NOT NULL,
  Dostep_do_sejfu Varchar2(3 ) NOT NULL,
  Numer_legitymacji Integer NOT NULL
)
/

ALTER TABLE Sprzedawcy ADD CONSTRAINT Unique_Identifier5 PRIMARY KEY (ID_Pracownika)
/

CREATE TABLE Uslugi(
  ID_Uslugi Integer NOT NULL,
  Typ_uslugi Varchar2(18 ) NOT NULL
        CHECK (Typ_uslugi IN ('Polaczenie glosowe','SMS','MMS','Internet')),
  ID_Operatora Integer NOT NULL
)
/

ALTER TABLE Uslugi ADD CONSTRAINT Unique_Identifier6 PRIMARY KEY (ID_Uslugi)
/

CREATE TABLE Punkty_komunikacyjne(
  ID_Punktu_komunikacyjnego Integer NOT NULL,
  Wysokosc Integer NOT NULL,
  Region Varchar2(200 ) NOT NULL,
  ID_Operatora Integer NOT NULL,
  ID_Adresu Integer NOT NULL
)
/

CREATE INDEX IX_regionu_punktu_komunikacyjnego ON Punkty_komunikacyjne(Region)
/

ALTER TABLE Punkty_komunikacyjne ADD CONSTRAINT Unique_Identifier10 PRIMARY KEY (ID_Punktu_komunikacyjnego)
/

CREATE TABLE Anteny(
  ID_Anteny Integer NOT NULL,
  ID_Punktu_komunikacyjnego Integer NOT NULL,
  ID_Typu_anteny Integer NOT NULL,
  Wysokosc_nad_poziomem_morza Integer NOT NULL
)
/

ALTER TABLE Anteny ADD CONSTRAINT Anteny_PK PRIMARY KEY (ID_Anteny)
/

CREATE TABLE Klienci(
  ID_Klienta Integer NOT NULL,
  Nr_telefonu Integer NOT NULL,
  ID_Adresu Integer NOT NULL
)
/

CREATE INDEX IX_klienta ON Klienci(ID_Klienta)
/

ALTER TABLE Klienci ADD CONSTRAINT Unique_Identifier3 PRIMARY KEY (ID_Klienta)
/

CREATE TABLE Osoby_prywatne(
  ID_Klienta Integer NOT NULL,
  Imie Varchar2(15 ) NOT NULL,
  Nazwisko Varchar2(30 ) NOT NULL,
  PESEL Integer
)
/

ALTER TABLE Osoby_prywatne ADD CONSTRAINT Osoby_prywatne_PK PRIMARY KEY (ID_Klienta)
/

CREATE TABLE Firmy(
  ID_Klienta Integer NOT NULL,
  Nazwa Varchar2(100 ) NOT NULL,
  ID_Danych Integer NOT NULL
)
/

ALTER TABLE Firmy ADD CONSTRAINT Firma_PK PRIMARY KEY (ID_Klienta)
/

CREATE TABLE Zatrudnienia(
  ID_Oddzialu Integer NOT NULL,
  ID_Pracownika Integer NOT NULL
)
/

CREATE TABLE Udostepnianie_uslug(
  ID_Punktu_komunikacyjnego Integer NOT NULL,
  ID_Uslugi Integer NOT NULL
)
/

CREATE TABLE Umowy(
  ID_Umowy Integer NOT NULL,
  ID_Uslugi Integer NOT NULL,
  ID_Klienta Integer NOT NULL,
  Data_zawarcia Date NOT NULL,
  Data_zakonczenia Date NOT NULL
)
/

CREATE INDEX IX_zakonczenia_umowy ON Umowy(Data_zakonczenia)
/

CREATE TABLE Adresy(
  ID_Adresu Integer NOT NULL,
  Kraj Varchar2(100 ) NOT NULL,
  Miasto Varchar2(100 ) NOT NULL,
  Ulica Varchar2(100 ) NOT NULL,
  Numer_budynku Varchar2(100 ) NOT NULL,
  Numer_lokalu Varchar2(100 )
)
/

ALTER TABLE Adresy ADD CONSTRAINT PK_Adresy PRIMARY KEY (ID_Adresu)
/

CREATE TABLE Dane_firmy(
  ID_Danych Integer NOT NULL,
  NIP Varchar2(10 ) NOT NULL,
  Numer_KRS Varchar2(10 ) NOT NULL,
  Numer_REGON Varchar2(9 ) NOT NULL
)
/

ALTER TABLE Dane_firmy ADD CONSTRAINT PK_Dane_firmy PRIMARY KEY (ID_Danych)
/

CREATE TABLE Typy_anten(
  ID_Typu_anteny Integer NOT NULL,
  Zysk_energetyczny Float NOT NULL,
  Temperatura_szumowa Float NOT NULL,
  Wspolczynnik_szumow Float NOT NULL
)
/

ALTER TABLE Typy_anten ADD CONSTRAINT Typu_anten_PK PRIMARY KEY (ID_Typu_anteny)
/


ALTER TABLE Oddzialy ADD CONSTRAINT Operator_posiada_odzial FOREIGN KEY (ID_Operatora) REFERENCES Operatorzy (ID_Operatora)
/



ALTER TABLE Uslugi ADD CONSTRAINT Operator_oferuje_uslugi FOREIGN KEY (ID_Operatora) REFERENCES Operatorzy (ID_Operatora)
/



ALTER TABLE Punkty_komunikacyjne ADD CONSTRAINT Operator_wykorzystuje_punkt FOREIGN KEY (ID_Operatora) REFERENCES Operatorzy (ID_Operatora)
/



ALTER TABLE Anteny ADD CONSTRAINT Punkt_wyposazony_w_antene FOREIGN KEY (ID_Punktu_komunikacyjnego) REFERENCES Punkty_komunikacyjne (ID_Punktu_komunikacyjnego)
/



ALTER TABLE Punkty_komunikacyjne ADD CONSTRAINT Punkt_jest_zlokalizowany FOREIGN KEY (ID_Adresu) REFERENCES Adresy (ID_Adresu)
/



ALTER TABLE Oddzialy ADD CONSTRAINT Oddzial_jest_zlokalizowany FOREIGN KEY (ID_Adresu) REFERENCES Adresy (ID_Adresu)
/



ALTER TABLE Firmy ADD CONSTRAINT Firma_posiada_dane FOREIGN KEY (ID_Danych) REFERENCES Dane_firmy (ID_Danych)
/



ALTER TABLE Operatorzy ADD CONSTRAINT Posiada_dane FOREIGN KEY (ID_Danych) REFERENCES Dane_firmy (ID_Danych)
/



ALTER TABLE Anteny ADD CONSTRAINT Antena_jest_typu FOREIGN KEY (ID_Typu_anteny) REFERENCES Typy_anten (ID_Typu_anteny)
/



ALTER TABLE Klienci ADD CONSTRAINT Klient_posiada_adres FOREIGN KEY (ID_Adresu) REFERENCES Adresy (ID_Adresu)
/



ALTER TABLE Pracownicy ADD CONSTRAINT Pracownik_ma_adres FOREIGN KEY (ID_Adresu) REFERENCES Adresy (ID_Adresu)
/