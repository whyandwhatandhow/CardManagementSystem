package com.digital.entity;

public class Card {
    private int card_id;
    private String name;
    private int phone_num;
    private String e_mail;
    private String workplace;
    private String title;
    private String address;
    private String username;

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(int phone_num) {
        this.phone_num = phone_num;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Card(int card_id, String name, int phone_num, String e_mail, String workplace, String title, String address, String username) {
        this.card_id = card_id;
        this.name = name;
        this.phone_num = phone_num;
        this.e_mail = e_mail;
        this.workplace = workplace;
        this.title = title;
        this.address = address;
        this.username = username;
    }

    public Card() {
    }

    @Override
    public String toString() {
        return "Card{" +
                "card_id=" + card_id +
                ", name='" + name + '\'' +
                ", phone_num=" + phone_num +
                ", e_mail='" + e_mail + '\'' +
                ", workplace='" + workplace + '\'' +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
