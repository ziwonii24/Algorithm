#include <iostream>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0);
}

int main() {
	init();
	int sum = 0;
	for (int i = 0; i < 5; i++) {
		int num;
		cin >> num;
		sum += num * num;
	}
	cout << sum % 10;
	return 0;
}
