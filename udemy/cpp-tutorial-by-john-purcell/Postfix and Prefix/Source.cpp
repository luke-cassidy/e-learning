#include <iostream>
using namespace std;

int main() {

	int value = 8;

	cout << value++ << endl;
	cout << value << endl;

	int number = value++;

	cout << number << endl;
	cout << value << endl;

	number = ++value;

	cout << number << endl;
	cout << value << endl;

	std::getchar();
	return 0;
}