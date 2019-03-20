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
		int d, score = 0;
		cin >> d;
		if (d < 100) score = 0;
		else if (d >= 100 && d < 1000) score = 1;
		else if (d >= 1000 && d < 10000) score = 2;
		else if (d >= 10000 && d < 100000) score = 3;
		else if (d >= 100000 && d < 1000000) score = 4;
		else if (d >= 1000000) score = 5;
			
		cout << '#' << T << ' ' << score << '\n';
	}	
	return 0;
}