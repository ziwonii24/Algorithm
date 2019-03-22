#include <iostream>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0);
}

int n;

void sol() {
	int arr[5];	//2 3 5 7 11
	for (int i = 0; i < 5; i++)
		arr[i] = 0;

	while (n % 2 == 0) {
		n /= 2;
		arr[0]++;
	}
	while (n % 3 == 0) {
		n /= 3;
		arr[1]++;
	}
	while (n % 5 == 0) {
		n /= 5;
		arr[2]++;
	}
	while (n % 7 == 0) {
		n /= 7;
		arr[3]++;
	}
	while (n % 11 == 0) {
		n /= 11;
		arr[4]++;
	}
	for (int i = 0; i < 5; i++)
		cout << arr[i] << ' ';
}

int main() {
	init();
	int tc;
	cin >> tc;
	for (int T = 1; T <= tc; T++) {
		cin >> n;
		cout << '#' << T << ' ';
		sol();
		cout << '\n';
	}
	
	return 0;
}
