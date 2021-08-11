#include "book.h"

//operator wypisania zawartosci obiektu 
ostream& operator<< (ostream& wyjscie, const Book& ksiazka) {
	return wyjscie << endl << " Autor: " << ksiazka.autor << endl << " Tytul: " << ksiazka.tytul << endl;
}

Book::Book() {
	cout << "  konstr bezparametrowy: " << endl;
	autor = "przyklad bezparametrowy";
	tytul = "przyklad bezparametrowy";
}

// lewostronna referencja
Book::Book(const std::string& autor, const std::string& tytul) {
	cout << "  konstr l-referencja: przekazywanie wartosci" << endl;
	this->autor = autor;
	this->tytul = tytul;
}

//move --> obiekt ma charakter tymczasowy i można go przekazać jego r-referencje do jakieś metody --> uruchamianie metody z r-referencja
Book::Book(std::string&& autor, std::string&& tytul) {
	cout << "  konstr r-referencja: nie jest tworzona kopia" << endl;
	this->autor = move(autor);
	this->tytul = move(tytul);
}

Book::Book(const Book& other)
	:tytul(other.tytul), autor(other.autor) {
	cout << "  konstr kopiujacy: " << endl;
}

Book::Book(Book&& other) {
	cout << "  konstr przenoszacy: " << endl;
	tytul = move(other.tytul);
	autor = move(other.autor);
}

//Autor --> getery i setery
std::string Book::GetAutor() {
	return autor;
}

void Book::SetAutor(const std::string& autor) {
	cout << "autor l-ref " << endl;
	this->autor = autor;
}

void Book::SetAutor(std::string&& autor) {
	cout << "autor r-ref " << endl;
	this->autor = std::move(autor);
}

//Tytul --> getery i setery
std::string Book::GetTytul() {
	return tytul;
}

void Book::SetTytul(const std::string& tytul) {
	cout << "tytul l-ref " << endl;
	this->tytul = tytul;
}

void Book::SetTytul(std::string&& tytul) {
	cout << "tytul r-ref " << endl;
	this->tytul = std::move(tytul);
}

//operatory przypisania
//kopiujacy
Book& Book::operator=(const Book& right) {
	cout << "  przypisanie kopiujacy" << endl;
	Book temp = right;
	tytul = temp.tytul;
	autor = temp.autor;
	return *this;
}

// przenoszacy
Book& Book::operator=(Book&& right) {
	cout << "  przypisanie przenoszacy (ze swapem)" << endl;
	std::swap(tytul, right.tytul);
	std::swap(autor, right.autor);
	return *this;
}

Book::~Book() {
	cout << "  destruktor ksiazki: " << tytul << "  " << autor << endl;
}


int main() {
	string a = "AAAAA", t = "BBBBB";
	Book e;
	cout << "Bezparametrowy: " << e << endl << endl;

	Book v1(a, t);
	std::cout << "v1: " << v1 << std::endl;

	Book b1 = { a, t };
	cout << "b1: " << b1 << endl;

	Book b2 = { "CCCCC", "DDDDD" };
	cout << "b2: " << b2 << endl;

	Book b3 = b1;
	cout << "b3: " << b3 << " b1: " << b1 << endl;

	Book e1 = std::move(b2);
	cout << "e: " << e << " b2:" << b2 << endl;

	string napis = "string";

	e.SetAutor(napis);
	cout << "e: " << e << endl;

	e.SetTytul("Ksiazka o mnie");
	cout << "e: " << e << endl;

	return 0;
}

