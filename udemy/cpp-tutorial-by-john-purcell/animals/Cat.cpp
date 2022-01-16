#include "Cat.h"
#include <iostream>

namespace caveofprogramming {

	void saySomething() {
		std::cout << "Hello" << std::endl;

	}

	Cat::Cat()
	{
	}


	Cat::~Cat()
	{
	}

	void Cat::speak() {
		std::cout << "meow" << std::endl;
	}

};