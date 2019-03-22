#include <iostream>
#include <algorithm>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0);
}

int p,q,r,s,w;

int sol() {
	int a, b;
	a = p * w;
	if (w <= r) b = q;
	else b = q + (w - r)*s;
	return min(a, b);
}

int main() {
	init();
	int tc;
	cin >> tc;
	for (int T = 1; T <= tc; T++) {
		cin >> p >> q >> r >> s >> w;
		cout << '#' << T << ' ' << sol() << '\n';
	}
	
	return 0;
}
