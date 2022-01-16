#include <iostream>
using namespace std;

int main() {
	
	int colour = 0x123456;

	unsigned char red = (colour & 0xFF0000) >> 16;
	unsigned char green = (colour & 0x00FF00) >> 8;
	unsigned char blue = (colour & 0x0000FF);

	cout << hex << (int)red << endl;
	cout << hex << (int)green << endl;
	cout << hex << (int)blue << endl;

	//or do the following

	unsigned char redAgain = colour >> 16;
	unsigned char greenAgain = colour << 8 >> 16;
	unsigned char blueAgain = colour << 16 >> 16;

	cout << hex << (int)redAgain << endl;
	cout << hex << (int)greenAgain << endl;
	cout << hex << (int)blueAgain << endl;


	std::getchar();
	return 0;
}