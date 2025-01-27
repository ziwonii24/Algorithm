#include <iostream>
using namespace std;

int a, b;

int gcd(int a, int b) {
	if (b == 0)
		return a;
	else
		return gcd(b, a%b);
}

int lcm(int a, int b) {
	int g = gcd(a, b);
	return a * b / g;
}

int main() {
	cin >> a >> b;
	cout << gcd(a, b)<<'\n';
	cout << lcm(a, b) << '\n';

	return 0;
}
