#pragma once

#include<iostream>
#include <string>
using namespace std;

class Book {
private:
	std::string autor, tytul;
public:
	

	Book(); //konstr bezparametrowy
	Book(const std::string& autor, const std::string& tytul);  //konstr l-referencja
	Book(std::string&& autor, std::string&& tytul); //konstr r-referencja
	Book(const Book& other); // konstr kopiujacy
	Book(Book&& other); //konstr przenoszacy

	std::string GetAutor();
	void SetAutor(const std::string& autor);
	void SetAutor(std::string&& autor);

	std::string GetTytul();
	void SetTytul(const std::string& tytul);
	void SetTytul(std::string&& tytul);

	friend ostream& operator<< (ostream& wyjscie, const Book& ksiazka);
	Book& operator=(const Book& other); // przypisanie kopiowanie
	Book& operator=(Book&& other); // przypisanie przenoszenie copy-swap, przenoszący operator przypisania

	~Book();
};
