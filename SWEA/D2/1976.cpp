#include <iostream>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0);
}

int main() {
	init();
	int tc;
	cin >> tc;
	for (int T = 1; T <= tc; T++) {
		int ah, am, bh, bm, ph = 0;
		cin >> ah >> am >> bh >> bm;
		if (am + bm > 60) {
			am = am + bm - 60;
			ph = 1;
		}
		else am = am + bm;

		if (ph == 1) ah += ph;
		if (ah + bh > 12) ah = ah + bh - 12;
		else ah = ah + bh;

		cout << '#' << T << ' ' << ah << ' ' << am << '\n';
	}	
	return 0;
}