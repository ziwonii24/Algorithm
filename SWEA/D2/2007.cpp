#include <iostream>
#include <string>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0);
}

string str;

int get_repeating_size() {
	for (int size = 2; size <= 10; size++) {
		bool check = true;
		for (int i = 0; i < size; i++) {
			if (str[i] != str[i + size]) {
				check = false;
				break;
			}
		}
		if (check) return size;
	}
	return 1;
}

int main() {
	init();
	int tc;
	cin >> tc;
	for (int T = 1; T <= tc; T++) {
		cin >> str;
		cout << '#' << T << ' ' << get_repeating_size() << '\n';
	}
	
	return 0;
}
