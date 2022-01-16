#include <iostream>
#include <iomanip>
using namespace std;

int main() {

	//0xFF123456

	unsigned char alpha = 0xFF;
	unsigned char red = 0x12;
	unsigned char green = 0x34;
	unsigned char blue = 0x56;

	unsigned int colour = 0;

	colour += alpha;
	colour <<= 8;
	colour += red;
	colour <<= 8;
	colour += green;
	colour <<= 8;
	colour += blue;

	cout << setfill('0') << setw(8) << hex << colour << endl;

	std::getchar();
	return 0;
}