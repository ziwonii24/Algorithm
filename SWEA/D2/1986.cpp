#include <iostream>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0);
}

int n;

int sol() {
	int ans = 0;
	for (int i = 1; i <= n; i++) {
		if (i % 2 == 1) ans += i;
		else ans -= i;
	}
	return ans;
}

int main() {
	init();
	int tc;
	cin >> tc;
	for (int T = 1; T <= tc; T++) {
		cin >> n;
		cout << '#' << T << ' ';
		cout<< sol();
		cout << '\n';
	}
	
	return 0;
}
