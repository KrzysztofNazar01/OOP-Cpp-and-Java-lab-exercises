#pragma once
#include "book.h"

class Library {
	Book* array;
	std::size_t books_count;
public:

	Library();
	Library(std::size_t books_count);
	Library(std::initializer_list<Book> list);
	Library(const Library& Lib);
	Library(Library&& Lib);
	std::size_t GetSize() const;
	~Library();

	friend ostream& operator<< (ostream& ostr, const Library& Bib);
	Library& operator=(const Library& right);
	Library& operator=(Library&& right);
	Book& operator[](std::size_t i);
	const Book& operator[](std::size_t i) const;	
};