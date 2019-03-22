#include <iostream>
#include <string>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0);
}

int n;

int main() {
	init();
	cin >> n;
	for (int i = 1; i <= n; i++) {
		string str = to_string(i);
		int cnt = 0;
		for (int j = 0; j < str.size(); j++)
			if (str[j] == '3' || str[j] == '6' || str[j] == '9') 
				cnt++;

		if (cnt) {
			for (int j = 0; j < cnt; j++)
				cout << '-';
		}
		else cout << i;
		cout << ' ';
	}
	
	return 0;
}
