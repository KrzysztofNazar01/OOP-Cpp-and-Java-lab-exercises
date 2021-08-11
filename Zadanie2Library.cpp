#include "library.h"

Library::Library() {
	cout << "  konstr bezparametrowy: " << endl;
	array = nullptr;
	books_count = 0;
}
//dodac info
Library::Library(std::size_t books_count)
	:books_count{ books_count }, array{ new Book[books_count] }{
}

Library::Library(std::initializer_list<Book> list)
	: books_count{ list.size() }, array{ new Book[list.size()] } {
	cout << "  konstr z lista inicjalizacyjna: " << endl;
	std::size_t i = 0;
	for (Book ksiazka : list) {
		array[i++] = ksiazka;
	}
}

Library::Library(const Library& Lib)
	:books_count{ Lib.books_count }, array{ new Book[Lib.books_count] }{
	cout << "  konstr kopiujacy: lib " << endl;
	for (std::size_t i = 0; i < books_count; i++) {
		array[i] = Lib.array[i];
	}
}

Library::Library(Library&& Lib) {
	cout << "  konstr przenoszacy: " << endl;
	books_count = Lib.books_count;
	array = Lib.array;
	Lib.array = nullptr;
	Lib.books_count = 0;
}

std::size_t Library::GetSize() const {
	return books_count;
}

Library::~Library() {
	if (array != nullptr) {
		cout << "  destruktor biblioteki: " << endl;
		delete[] array;
	}
}

Library& Library::operator=(const Library& right) {
	cout << "  kopiujujacy operator przypisania (kopia): " << endl;
	Library temp = right;
	array = temp.array;
	books_count = temp.books_count;
	return *this;
}

Library& Library::operator=(Library&& right) {
	cout << "  przenoszacy operator przypisania (kopia): " << endl;
	Library temp = right;
	std::swap(books_count, temp.books_count);
	std::swap(array, temp.array);
	return *this;
}

Book& Library::operator[](std::size_t i) {
	return array[i];
}

const Book& Library::operator[](std::size_t i) const {
	return array[i];
}


std::ostream& operator<<(std::ostream& ostr, const Library& Bib) {
	ostr << "Library{";
	for (std::size_t i = 0; i < Bib.GetSize(); i++) {
		if (i > 0) ostr << ',';

		ostr << Bib[i];
	}
	ostr << '}';
	return ostr;
}



/*
int main() {
	Library e;
	cout << "e: " << e << endl;

	cout << "-------------" << endl;

	Library l1 = { {"A1", "T1"}, {"A2", "T2"}, {"A3", "T3"}, {"A4", "T4"} };
	cout << "l1: " << l1 << endl;

	cout << "-------------" << endl;

	Library l2(2);
	cout << "l2: " << l2 << endl;

	cout << "-------------" << endl;

	l2[0] = { "AUTOR_0", "TYTUL_0" };
	l2[1] = { "AUTOR_1", "TYTUL_1" };
	cout << "l2: " << l2 << endl;

	cout << "-------------" << endl;

	e = std::move(l2);
	cout << "e: " << e << endl << "l2: " << l2 << endl;

	cout << "-------------" << endl;

	l1[0] = std::move(e[1]);
	cout << "l1: " << l1 << " e: " << e << endl;

	return 0;
}

*/