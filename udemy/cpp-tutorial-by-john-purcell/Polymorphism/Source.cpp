#include <iostream>
using namespace std;


class Animal {
public:
	virtual void speak() = 0;
	virtual ~Animal() {};
};

class Cat : public Animal {
public:
	void speak() {
		cout << "RrrrrrrrRRRrrrrrr" << endl;
	}
	virtual ~Cat() {};
};

class HouseCat : public Cat {
public:
	void speak() {
		cout << "Meowwwwwww" << endl;
	}
	virtual ~HouseCat() {};
};


int main() {

	Animal* pAnimal = new HouseCat();

	(*pAnimal).speak();

	std::getchar();
	return 0;
}